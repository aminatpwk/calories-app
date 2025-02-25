package entityTest;
import entity.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTests {
    private User user;

    @BeforeEach
    public void setUp(){
        user = new User();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, user.getUserId());
        assertNull(user.getUserName());
        assertNull(user.getUserEmail());
        assertNull(user.getUserPassword());
        assertNull(user.getRole());
        assertEquals(0.0, user.getAvgCalories());
        assertFalse(user.getHasExceededMoneyLimit());
    }

    @Test
    public void testFiveParameterConstructor() {
        user = new User(1, "test_name", "test@example.com", "testpass123", "USER");
        assertEquals(1, user.getUserId());
        assertEquals("test_name", user.getUserName());
        assertEquals("test@example.com", user.getUserEmail());
        assertEquals("testpass123", user.getUserPassword());
        assertEquals("USER", user.getRole());
        assertEquals(0.0, user.getAvgCalories());
        assertFalse(user.getHasExceededMoneyLimit());
    }

    @Test
    public void testSixParamConstructor() {
        user = new User(2, "test_name", "test@example.com", "testpass456", "ADMIN", true);
        assertEquals(2, user.getUserId());
        assertEquals("test_name", user.getUserName());
        assertEquals("test@example.com", user.getUserEmail());
        assertEquals("testpass456", user.getUserPassword());
        assertEquals("ADMIN", user.getRole());
        assertTrue(user.getHasExceededMoneyLimit());
    }

    @Test
    public void testThreeParamConstructor() {
        user = new User(3, "test", "test@example.com");
        assertEquals(3, user.getUserId());
        assertEquals("test", user.getUserName());
        assertEquals("test@example.com", user.getUserEmail());
        assertNull(user.getUserPassword());
        assertNull(user.getRole());
    }

    @Test
    public void testUserNameCaloriesConstructor() {
        user = new User("test", 1500.5);
        assertEquals("test", user.getUserName());
        assertEquals(1500.5, user.getAvgCalories());
        assertEquals(0, user.getUserId());
    }

    @Test
    public void testIdMoneyLimitConstructor() {
        user = new User(4, true);
        assertEquals(4, user.getUserId());
        assertTrue(user.getHasExceededMoneyLimit());
        assertNull(user.getUserName());
    }

    @Test
    public void testSettersAndGetters() {
        user.setUserId(5);
        user.setUserName("test_user");
        user.setEmail("test@example.com");
        user.setPassword("testpass");
        user.setRole("GUEST");
        user.setAvgCalories(2000.0);
        user.setHasExceededMoneyLimit(true);

        assertEquals(5, user.getUserId());
        assertEquals("test_user", user.getUserName());
        assertEquals("test@example.com", user.getUserEmail());
        assertEquals("testpass", user.getUserPassword());
        assertEquals("GUEST", user.getRole());
        assertEquals(2000.0, user.getAvgCalories());
        assertTrue(user.getHasExceededMoneyLimit());
    }
}
