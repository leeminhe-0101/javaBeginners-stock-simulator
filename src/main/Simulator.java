/**
 * Simulator 클래스
 * 역할: 실행 클래스로, 시뮬레이터의 시작점 역할을 하며 전체 흐름 관리
 */

package main;

import account.CMAAccount;
import atm.ATM;
import calendar.Calendar;
import exception.InsufficientBalanceException;
import result.ProfitCalculator;
import result.Result;
import stock.Holding;
import stock.SAMSUNG;
import stock.Stock;
import stock.Stock.DailyData;
import stock.StockDB;
import stock.StockMarket;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Simulator {
	private static CMAAccount cmaAccount = new CMAAccount(2000000);
	public static ATM atm = new ATM(cmaAccount);
	private static final Scanner scanner = new Scanner(System.in);
	public static StockMarket stockMarket = new StockMarket(cmaAccount);
	public static Result result = new Result(atm);
	
	
	// ----------- ATM 메뉴 진입 -------------
	public static void startATM() {
		while(true) {
			System.out.println(Calendar.getNowDate());
			System.out.println("어서오세요. 이용하실 메뉴의 숫자를 입력해주십시오.");
			System.out.println("1. CMA 계좌조회");
			System.out.println("2. 출금");
			System.out.println("3. 주식");
			System.out.println("4. 종료");

			int input = Integer.parseInt(scanner.nextLine());
			
			switch(input) {
			case 1: System.out.println("잔액: " + atm.accountInquiry() + "원"); break;
			case 2: withdrawATM(); break;
			case 3: startStockMarket(); break;
			case 4: System.exit(0);
			default: System.out.println("잘못된 입력입니다.");
			}
			
			System.out.println();
		}
	}
	
	/**
	 * startATM() 메소드에서 사용자가 2번을 입력함으로써 출금을 선택했을 시 띄워지는 출금 기능 제공 메소드이다.
	 * atm에서 출금 후 cmaAccount에서 잔액을 불러온다.
	 */
	public static void withdrawATM() {
		int money = 0;
		while (true) {
		    try {
		    	System.out.println();
		        System.out.print("출금하실 금액을 입력해주십시오. ");
		        money = Integer.parseInt(scanner.nextLine());
		        if (money <= 0) throw new IllegalArgumentException();
		        break;
		    } catch (Exception e) {
		        System.out.println("잘못된 입력입니다.");
		    }
		}
			
		
		try {
			atm.withdraw(money);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			System.out.println();
			withdrawATM();
		}
		
		System.out.println("잔액: " + cmaAccount.getBalanceWithInterest(Calendar.getBeforeDate(), Calendar.getNowDate()) + "원");
		System.out.println();
	}
	
	// ----------- 주식 시장 메뉴 진입: 보유 주식 확인 / 종목별 주가 확인 -------------
	public static void startStockMarket() {
		while(true) {
			System.out.println();
			System.out.println("이용하실 메뉴의 숫자를 입력해주십시오.");
			System.out.println("1. 보유주식");
			System.out.println("2. 종목별 주가 보기");
			System.out.println("3. 뒤로 가기");
			
			int input = Integer.parseInt(scanner.nextLine());
			
			switch(input) {
			case 1: {
				for(int i=0; i<StockDB.getStocksLength(); i++) {
					Holding holding = StockDB.getStock(i).getHolding();
					
					if(!holding.list.isEmpty()) {
						holding.setTotalStock(i);
					    System.out.println(i+1 + ". " + StockDB.getStock(i).getName());
						System.out.println("- 보유주식가치: " + holding.sum);
						System.out.println("- 원금: " + holding.principal);
						System.out.println("- 수익률: " + holding.ROI +"%");
					}
				}
			}
			break;
			case 2: {
				LocalDate nowdate = Calendar.getNowDate();
				System.out.println(nowdate);
				System.out.println();
				for(int i=0; i<StockDB.getStocksLength(); i++) {
					System.out.println(i+1 + ". " + StockDB.getStock(i).getName() + " " + StockDB.getStock(i).getDailyData(nowdate).buyPrice() +"원 / " + StockDB.getStock(i).getDailyData(nowdate).comparedToPreviousDay()*100 +"%");
					System.out.println("오늘의 힌트: " + StockDB.getStock(i).getDailyData(nowdate).hint());
				}
			}
			break;
			case 3: break;
			default: System.out.println("잘못된 입력입니다.");
			}
			
			System.out.println();
			
			if(input == 1) {
				System.out.println("이용하실 메뉴의 숫자를 입력해주십시오.");
				System.out.println("1. 매도");
				System.out.println("2. 날짜이동");
				System.out.println("3. 뒤로가기");
				
				int input2 = Integer.parseInt(scanner.nextLine());
				
				switch(input2) {
				case 1: {
					while(true) {
						int input3;
						try {
							System.out.println("매도하실 주식의 번호를 입력하세요.");
							input3 = Integer.parseInt(scanner.nextLine())-1;
							if(input3<0 || input3>(StockDB.getStocksLength()-1)) throw new IllegalArgumentException();
							
							stockMarket.sell(StockDB.getStock(input3), input3);
							System.out.println("매도가 완료되었습니다.");
							break;
						} catch (Exception e) {
							System.out.println("잘못된 입력입니다.");
						}
					}
				}
				break;
				case 2: {
				    int input3;
				    
				    while (true) {
				        try {
				        	System.out.println();
				            System.out.println(Calendar.getNowDate().plusDays(1) + "~2025-07-10 이동하실 날짜의 ‘일’(day) 숫자를 입력해 주세요.");
				            input3 = Integer.parseInt(scanner.nextLine());
				            if ((input3 < Calendar.getNowDate().plusDays(1).getDayOfMonth()) || (input3 > 10)) 
				                throw new IllegalArgumentException();
				            break;
				        } catch (Exception e) {
				            System.out.println(Calendar.getNowDate().plusDays(1).getDayOfMonth() + "에서 10까지의 수를 입력하세요.");
				        }
				    }

				    LocalDate newDate = LocalDate.of(2025, 07, input3);
				    Calendar.setNowDate(newDate);

				    for (int i = 0; i < StockDB.getStocksLength(); i++) {
				        StockDB.getStock(i).getHolding().setTotalStock(i);
				    }
				    
				    if(Calendar.getNowDate().equals(LocalDate.of(2025, 7, 10))) {
				    	result.startResult();
				    }
				}
				break;
				case 3: break;
				default: System.out.println("잘못된 입력입니다.");
				}
				
				System.out.println();
			}
	
			if(input == 2) {
				while(true) {
					int input2=0, input3=0;
					
					try {
						System.out.println("매수하실 종목 번호 (1~3)을 입력해주십시오.");
						input2 = Integer.parseInt(scanner.nextLine())-1;
						if(input2<0 || input2>2) throw new IllegalArgumentException();
				    } catch (Exception e) {
				        System.out.println("잘못된 입력입니다.");
				        System.out.println();
				        continue;
				    }
					
					try {
						System.out.println("매수하실 수량을 입력해주십시오.");
						input3 = Integer.parseInt(scanner.nextLine());
						if(input3<=0) throw new IllegalArgumentException();
				    } catch (Exception e) {
				        System.out.println("잘못된 입력입니다.");
				        System.out.println();
				        continue;
				    }
					
					
					StockDB.getStock(input2).getHolding().setHolding(Calendar.getNowDate(), StockDB.getStock(input2), input3);
					
					List<Holding.HoldingStock> list = StockDB.getStock(input2).getHolding().getHoldingStock();
					
	
					int lastIndex = list.size() - 1;
					int withdrawalAmount = list.get(lastIndex).buyPrice() * list.get(lastIndex).quantity();
					
					try {
						if(withdrawalAmount > cmaAccount.getBalanceWithInterest(Calendar.getNowDate(), Calendar.getNowDate())) {
							throw new InsufficientBalanceException("잔액이 부족합니다.");
						}
						atm.withdraw(withdrawalAmount);
						System.out.println("매수를 완료했습니다.");
				    } catch (Exception e) {
				        System.out.println(e.getMessage());
				        System.out.println();
				        list.remove(lastIndex);
				    }
					
					break;
				}
				
			}
			if(input == 3) break;
		}
	}
	
	// ----------- 메인 시작: 초기 주식 데이터 설정 후 ATM 메뉴 실행 -------------
	public static void main(String[] args) {
		StockDB.setSamsung();
		StockDB.setSK();
		StockDB.setLG();
		
		startATM();
	}
	
}

