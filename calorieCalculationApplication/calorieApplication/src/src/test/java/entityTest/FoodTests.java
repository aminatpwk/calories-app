package entityTest;

import entity.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FoodTests {
    private Food food;

    @BeforeEach
    public void setUp() {
        food = new Food();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, food.getFoodId());
        assertEquals(0, food.getUserId());
        assertNull(food.getFoodName());
        assertEquals(0.0, food.getCalorie());
        assertEquals(0.0, food.getPrice());
        assertNull(food.getDateWhenConsumed());
    }

    @Test
    public void testFullConstructor() {
        Date testDate = Date.valueOf("2025-02-25");
        food = new Food(1, 100, "Apple", 52.0, 0.5, testDate);
        assertEquals(1, food.getFoodId());
        assertEquals(100, food.getUserId());
        assertEquals("Apple", food.getFoodName());
        assertEquals(52.0, food.getCalorie());
        assertEquals(0.5, food.getPrice());
        assertEquals(testDate, food.getDateWhenConsumed());
    }

    @Test
    public void testSettersAndGetters() {
        Date testDate = Date.valueOf("2025-01-01");
        food.setFoodId(2);
        food.setUserId(200);
        food.setFoodName("Pizza");
        food.setCalorie(800.0);
        food.setPrice(12.99);
        food.setDateWhenConsumed(testDate);
        assertEquals(2, food.getFoodId());
        assertEquals(200, food.getUserId());
        assertEquals("Pizza", food.getFoodName());
        assertEquals(800.0, food.getCalorie());
        assertEquals(12.99, food.getPrice());
        assertEquals(testDate, food.getDateWhenConsumed());
    }
}
