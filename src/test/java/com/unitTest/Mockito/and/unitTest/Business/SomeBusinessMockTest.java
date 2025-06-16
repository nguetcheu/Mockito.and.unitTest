package com.unitTest.Mockito.and.unitTest.Business;
import com.unitTest.Mockito.and.unitTest.Data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {
    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();

    @Mock
    SomeDataService dataServiceMock;


    @Test
    public void calculateSumUsingDataService_Basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});

        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});

        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1});

        assertEquals(1, business.calculateSumUsingDataService());
    }
}
