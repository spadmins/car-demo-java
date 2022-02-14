package com.sample.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.sample.factory.CarsFactory;
import com.sample.persistence.CarsDAO;

// import org.junit.AfterClass;
// import org.junit.BeforeClass;
// import org.junit.After;
// import org.junit.Before;
// import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
// import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class CarsTest {
    // @Injectable
    // private Location loc;

    // @BeforeClass
    // public static void beforeClassSetUp() {
    //     System.out.println("In before class");
    // }

    // @AfterClass
    // public static void afterClassTearDown() {
    //     System.out.println("In after class");
    // }
    // Cars car = null;
    // @Before
    // public void setUp() {
    //     System.out.println("In before");
    //     car = new Cars();
    // }

    // @After
    // public void tearDown() {
    //     System.out.println("in after");
    //     car = null;
    // }
    /**
     * test for default constructor.
     */
    @Test
    public final void testCars() {
        Cars car = new Cars();
        car.setId(1);
        car.setCarName("Nexon");
        car.setPrice(1700000.00);

        assertEquals(1, car.getId());
        assertEquals("Nexon", car.getCarName());
        assertEquals(1700000.00, car.getPrice(), 0);
    }

    /**
     * test for parameterized constructor.
     */
    @Test
    public final void testCars1() {
        Cars car1 = new Cars(1, "Nexon", 1700000.00);
        assertEquals(1, car1.getId());
        assertEquals("Nexon", car1.getCarName());
        assertEquals(1700000.00, car1.getPrice(), 0);
    }

    @Test
    public final void testEquals() {
        Cars car1 = new Cars(1, "Nexon", 1700000.00);
        Cars car2 = new Cars(1, "Nexon", 1700000.00);
        Cars car3 = new Cars(2, "Nissan", 3400000.00);

        assertTrue(car1.equals(car2));
        assertFalse(car1.equals(car3));
        assertFalse(car2.equals(car3));
    }

    @Test
    public final void testHashCode() {
        Cars car1 = new Cars(1, "Nexon", 1700000.00);
        Cars car2 = new Cars(1, "Nexon", 1700000.00);
        Cars car3 = new Cars(2, "Nissan", 3400000.00);

        assertEquals(car1.hashCode(), car2.hashCode());
        assertNotEquals(car1.hashCode(), car3.hashCode());
        assertNotEquals(car2.hashCode(), car3.hashCode());
    }

    @Test
    public final void testToString() {
        Cars car1 = new Cars(1, "Nexon", 1700000.00);

        String msg = "Cars: [Id: " + car1.getId()  + " Name: " + car1.getCarName() + " Price: " + car1.getPrice() + "]";

        assertEquals(msg, car1.toString());
    }

    @Test
    public final void testSetId() {
        Cars car1 = new Cars(1, "Nexon", 1700000.00);
        car1.setId(2);
        assertEquals(2, car1.getId());
    }

    @Test
    public final void testAddNewCar(@Mocked final CarsDAO dao) {
        new Expectations() {
            {
                dao.addCar("Nissan", 2500000.00);
                result = 1;
            }
        };

        new MockUp<CarsFactory>(){
            @Mock
            CarsDAO dao() {
                return dao;
            }
        };

        Cars c = new Cars();
        String str = c.addNewCar("Nissan", 2500000.00);
        assertEquals("Car added successfully", str);

        String msg = c.addNewCar("Hyundai Accent", 1200000.00);
        assertEquals("Car Not Added", msg); 
    }
}
