package com.unitTest.Mockito.and.unitTest.Business;

import com.unitTest.Mockito.and.unitTest.Data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[ ] {1,2,3};
    }
}

class SomeDataServiceStubEmpty implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[ ] {};
    }
}

class SomeDataServiceStubOneValue implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {5};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_Basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDatService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDatService(new SomeDataServiceStubEmpty());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDatService(new SomeDataServiceStubOneValue());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}
