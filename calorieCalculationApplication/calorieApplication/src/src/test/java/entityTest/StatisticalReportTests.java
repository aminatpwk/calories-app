package entityTest;

import entity.StatisticalReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticalReportTests {
    private StatisticalReport statisticalReport;

    @BeforeEach
    public void setUp() {
        statisticalReport = new StatisticalReport();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, statisticalReport.getTotalCalories());
        assertEquals(0.0, statisticalReport.getTotalSpendingMoney());
        assertEquals(0, statisticalReport.getDaysAboveCalorieThreshold());
        assertEquals(0, getUserId(statisticalReport));
    }

    @Test
    public void testThreeParamConstructor() {
        statisticalReport = new StatisticalReport(2500.5, 75.25, 3);
        assertEquals(2500.5, statisticalReport.getTotalCalories());
        assertEquals(75.25, statisticalReport.getTotalSpendingMoney());
        assertEquals(3, statisticalReport.getDaysAboveCalorieThreshold());
        assertEquals(0, getUserId(statisticalReport));
    }

    @Test
    public void testGetters() {
        statisticalReport = new StatisticalReport(1800.0, 50.0, 2);

        assertEquals(1800.0, statisticalReport.getTotalCalories());
        assertEquals(50.0, statisticalReport.getTotalSpendingMoney());
        assertEquals(2, statisticalReport.getDaysAboveCalorieThreshold());
    }

    //helper methods
    private int getUserId(StatisticalReport report) {
        try {
            java.lang.reflect.Field field = StatisticalReport.class.getDeclaredField("userId");
            field.setAccessible(true);
            return (int) field.get(report);
        } catch (Exception e) {
            throw new RuntimeException("Failed to access userId field", e);
        }
    }

    private void setUserId(StatisticalReport report, int userId) {
        try {
            java.lang.reflect.Field field = StatisticalReport.class.getDeclaredField("userId");
            field.setAccessible(true);
            field.set(report, userId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set userId field", e);
        }
    }
}
