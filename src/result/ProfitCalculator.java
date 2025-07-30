/**
 * ProfitCalculator 클래스
 * 역할: 수익률 계산
 */

package result;

public class ProfitCalculator {
	
	/**
	 * 수익률을 계산 해 반환한다.
	 * @return 수익률
	 */
	public static float calculateROI(int principal, int revenue) {
	    return (float) revenue / principal * 100;
	}
}
