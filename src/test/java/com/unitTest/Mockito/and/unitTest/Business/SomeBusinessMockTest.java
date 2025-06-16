package com.unitTest.Mockito.and.unitTest.Business;
import com.unitTest.Mockito.and.unitTest.Data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessMockTest {

    SomeBusinessImpl business = new SomeBusinessImpl();
    // Création du mock de la classe service
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    // Liaison du resultat du mock avec le service utilisé dans notre classe implémentation du business
    @BeforeEach
    public void before() {
        business.setSomeDatService(dataServiceMock);
    }


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
