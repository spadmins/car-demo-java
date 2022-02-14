package com.sample.factory;

import com.sample.persistence.CarsDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.sample.model.Cars;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class CarsFactoryTest {

    @Test
    public final void testListAllCars(@Mocked final CarsDAO dao) {
        final Cars[] cList = new Cars[3];
        cList[0] = new Cars(1, "Nissan", 2300000.00);
        cList[1] = new Cars(2, "XUV700", 2800000.00);
        cList[2] = new Cars(3, "EcoSport", 1400000.00);

        new Expectations() {
            {
                dao.listAllCars();
                result = cList;
            }
        };

        new MockUp<CarsFactory>(){
            @Mock
            CarsDAO dao() {
                return dao;
            }
        };

        Cars[] list = CarsFactory.listAllCars();
        assertArrayEquals(cList, list);
    }

    @Test
    public final void testFindACar(@Mocked final CarsDAO dao) {
        final Cars car = new Cars(2, "XUV700", 2800000.00);

        new Expectations() {
            {
                dao.findACar(2);
                result = car;
            }
        };

        new MockUp<CarsFactory>(){
            @Mock
            CarsDAO dao() {
                return dao;
            }
        };

        Cars c = CarsFactory.findCar(2);
        assertEquals(car, c);
    }

    @Test
    public final void testAddCar(@Mocked final CarsDAO dao) {
        new Expectations() {
            {
                dao.addCar("XUV700", 3500000.00);
                result = 1;
            }
        };

        new MockUp<CarsFactory>() {
            @Mock
            CarsDAO dao() {
                return dao;
            }
        };

        int res = CarsFactory.addCar("XUV700", 3500000.00);
        assertEquals(1, res);
    }
}
