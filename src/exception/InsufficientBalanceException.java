/**
 * InsufficientBalanceException 클래스
 * 역할: 계좌 잔액보다 많은 액수 출금 시 발생하는 예외
 */

package exception;

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException() {};
	public InsufficientBalanceException(String message) {
		super(message);
	}
}

