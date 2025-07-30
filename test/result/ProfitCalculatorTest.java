package result;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProfitCalculatorTest {

    @Test
    void testCalculateROI() {
        int principal = 1000000;
        int revenue = 100000;

        float roi = ProfitCalculator.calculateROI(principal, revenue);
        
        assertEquals(10.0f, roi, 0.01f); // 오차 0.01 이내 허용
    }
}
