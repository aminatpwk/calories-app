package entityTest;

import entity.AdminReport;
import entity.Food;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AdminReportTests {
    private AdminReport adminReport;
    private User testUser;
    private List<Food> testFoods;

    @BeforeEach
    public void setUp() {
        testUser = new User(1, "test_name", "test@example.com", "testpass123", "USER");
        testFoods = new ArrayList<>();
        testFoods.add(new Food(1, 1, "Apple", 52.0, 0.5, Date.valueOf("2025-02-25")));
        testFoods.add(new Food(2, 1, "Pizza", 800.0, 12.99, Date.valueOf("2025-02-26")));
        adminReport = new AdminReport();
    }

    @Test
    public void testDefaultConstructor() {
        assertNull(adminReport.getUser());
        assertNull(adminReport.getFoods());
        assertEquals(0.0, adminReport.getAvgWeeklyConsumedCaloriesForAUser());
    }

    @Test
    public void testFullConstructor() {
        adminReport = new AdminReport(testUser, testFoods, 426.0);
        assertEquals(testUser, adminReport.getUser());
        assertEquals(testFoods, adminReport.getFoods());
        assertEquals(426.0, adminReport.getAvgWeeklyConsumedCaloriesForAUser());
    }

    @Test
    public void testUserOnlyConstructor() {
        adminReport = new AdminReport(testUser);
        assertEquals(testUser, adminReport.getUser());
        assertNull(adminReport.getFoods());
        assertEquals(0.0, adminReport.getAvgWeeklyConsumedCaloriesForAUser());
    }

    @Test
    public void testGetters() {
        adminReport = new AdminReport(testUser, testFoods, 500.5);
        assertEquals(testUser, adminReport.getUser());
        assertEquals(testFoods, adminReport.getFoods());
        assertEquals(500.5, adminReport.getAvgWeeklyConsumedCaloriesForAUser());
    }
}
