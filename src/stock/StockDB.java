/**
 * StockDB 클래스
 * 역할: 모든 종목 객체와 각 종목의 데이터를 소유
 */

package stock;

import stock.Stock.DailyData;

public class StockDB {
	static SAMSUNG samsung = new SAMSUNG();
	static DailyData p1;
	
	/**
	 * 삼성전자 종목에 대한 일별 데이터를 저장하는 메소드로, Simulator의 main에서 딱 한 번 실행된다.
	 */
	public static void setSamsung() {
		p1 = new DailyData(63300, -0.0078f, "직원 성과급 축소");
		samsung.setDailyData(p1, 0);
		
		p1 = new DailyData(61700, -0.0252f, "잠정실적 발표 임박");
		samsung.setDailyData(p1, 1);
		
		p1 = new DailyData(61400, -0.0048f, "2분기 영업이익 반토막");
		samsung.setDailyData(p1, 2);
		
		p1 = new DailyData(60400, -0.0016f, "장내 매수로 자사주 매입 결정");
		samsung.setDailyData(p1, 3);
		
		p1 = new DailyData(61000, 0.0099f, "3단 폴더블폰 출시 예고");
		samsung.setDailyData(p1, 4);
		
		p1 = new DailyData(62600, 0.0262f, "포럼서 디지털 헬스케어 방향 논의");
		samsung.setDailyData(p1, 5);
		
		p1 = new DailyData(62500, -0.0015f, "");
		samsung.setDailyData(p1, 6);
		
		p1 = new DailyData(63700, 0.0192f, "TV에 빅스비 적용 발표");
		samsung.setDailyData(p1, 7);
		
		p1 = new DailyData(64700, 0.0156f, "엔비디아 중국 수출길 확보");
		samsung.setDailyData(p1, 8);
		
		p1 = new DailyData(66700, 0.0309f, "이재용 회장, 무죄 확정");
		samsung.setDailyData(p1, 9);
	}
	
	static SK_HYNIX sk_hynix = new SK_HYNIX();
	static DailyData p2;
	
	/**
	 * SK하이닉스 종목에 대한 일별 데이터를 저장하는 메소드로, Simulator의 main에서 딱 한 번 실행된다.
	 */
	public static void setSK() {
		p2 = new DailyData(270500, -0.0287f, "올 2분기 영업이익 9조원 전망");
		sk_hynix.setDailyData(p2, 0);
		
		p2 = new DailyData(271000, 0.0018f, "HBM 독점 지위 유지 우려");
		sk_hynix.setDailyData(p2, 1);
		
		p2 = new DailyData(282000, 0.0405f, "");
		sk_hynix.setDailyData(p2, 2);
		
		p2 = new DailyData(281000, -0.0035f, "박빙으로 D랩 시장 매출 1위");
		sk_hynix.setDailyData(p2, 3);
		
		p2 = new DailyData(297000, 0.0569f, "HBM 납품 업체인 엔비디아 시총 상승");
		sk_hynix.setDailyData(p2, 4);
		
		p2 = new DailyData(294500, -0.0084f, "");
		sk_hynix.setDailyData(p2, 5);
		
		p2 = new DailyData(300000, 0.0186f, "장중 30만원 돌파");
		sk_hynix.setDailyData(p2, 6);
		
		p2 = new DailyData(298500, -0.005f, "엔비디아 제품 중국 수출 재개");
		sk_hynix.setDailyData(p2, 7);
		
		p2 = new DailyData(296000, -0.0083f, "하나증권, 목표주가 35만원으로 높임");
		sk_hynix.setDailyData(p2, 8);
		
		p2 = new DailyData(269500, -0.0895f, "미국 글로벌 금융사인 골드만삭스, 투자의견 중립 리포트 발표");
		sk_hynix.setDailyData(p2, 9);
	}
	
	static LG_ES lg_es = new LG_ES();
	static DailyData p3;
	
	/**
	 * LG에너지솔루션 종목에 대한 일별 데이터를 저장하는 메소드로, Simulator의 main에서 딱 한 번 실행된다.
	 */
	public static void setLG() {
		p3 = new DailyData(310500, -0.0251f, "시총 3위 재탈환");
		lg_es.setDailyData(p3, 0);
		
		p3 = new DailyData(215000, 0.0144f, "2분기 영업이익 전년대비 152% 증가");
		lg_es.setDailyData(p3, 1);
		
		p3 = new DailyData(307000, -0.0253f, "");
		lg_es.setDailyData(p3, 2);
		
		p3 = new DailyData(305000, -0.0065f, "");
		lg_es.setDailyData(p3, 3);
		
		p3 = new DailyData(318000, 0.0426f, "EU의 보조금 지원에 따라 유럽 시장 재공략 검토 예정");
		lg_es.setDailyData(p3, 4);
		
		p3 = new DailyData(321500, 0.011f, "미국 계열사에 자기자본 대비 4.9% 채무보증 결정");
		lg_es.setDailyData(p3, 5);
		
		p3 = new DailyData(315000, -0.0202f, "정부 추진 대규모 ESS 단지 조성 사업에 응찰");
		lg_es.setDailyData(p3, 6);
		
		p3 = new DailyData(316500, 0.0047f, "국내 배터리사 최초로 미국에 전기차용 LFP 배터리 라인 생산 예정");
		lg_es.setDailyData(p3, 7);
		
		p3 = new DailyData(311000, -0.0173f, "");
		lg_es.setDailyData(p3, 8);
		
		p3 = new DailyData(317000, 0.0192f, "에너지저장장치 사업 점차 두각");
		lg_es.setDailyData(p3, 9);
	}
	
	private static Stock[] stocks = { samsung, sk_hynix, lg_es }; // 주식 종류 전체 저장
	
	/**
	 * 주식 종류를 저장하는 stocks 배열의 길이를 반환한다.
	 */
	public static int getStocksLength() {
		return stocks.length;
	}
	
	/**
	 * 주식 종류를 저장하는 stocks 배열의 항목, 즉 주식 종목 객체를 반환한다.
	 * 
	 * @param i stocks 배열에서 종목이 갖는 인덱스
	 */
	public static Stock getStock(int i) {
		return stocks[i];
	}
	
}

