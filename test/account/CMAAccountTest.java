package account;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CMAAccountTest {

    private CMAAccount cmaAccount;

    @BeforeEach
    void setUp() {
        cmaAccount = new CMAAccount(1000000); // 초기 잔액 100만원
    }

    @Test
    void testGetBalanceWithInterest_sameDay() {
        LocalDate date = LocalDate.of(2025, 7, 4);
        int balance = cmaAccount.getBalanceWithInterest(date, date);
        assertEquals(1_000_000, balance);
    }

    @Test
    void testGetBalanceWithInterest_afterDays() {
        LocalDate before = LocalDate.of(2025, 7, 4);
        LocalDate after = LocalDate.of(2025, 7, 8); // 4일 경과

        int updatedBalance = cmaAccount.getBalanceWithInterest(before, after);

        // 이자율: 0.0000522/day × 4일 × 1,000,000원 = 약 208원
        assertTrue(updatedBalance > 1_000_000, "이자가 반영되어야 합니다");
        assertEquals(1_000_000 + (int)(1_000_000 * 0.0000522 * 4), updatedBalance);
    }

    @Test
    void testTotalInterestAccumulatesCorrectly() {
        LocalDate before = LocalDate.of(2025, 7, 4);
        LocalDate after = LocalDate.of(2025, 7, 7); // 3일 경과

        int balance = cmaAccount.getBalanceWithInterest(before, after);
        int expectedInterest = (int)(1_000_000 * 0.0000522 * 3);

        assertEquals(expectedInterest, cmaAccount.getTotalInterest());
        assertEquals(1_000_000 + expectedInterest, balance);
    }
}
