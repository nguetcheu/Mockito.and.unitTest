package com.unitTest.Mockito.and.unitTest.Business;
import com.unitTest.Mockito.and.unitTest.Data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessMockTest {

    SomeBusinessImpl business = new SomeBusinessImpl();
    // Création du mock de la classe service
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @Test
    public void calculateSumUsingDataService_Basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});

        // Liaison du resultat du mock avec le service utilisé dans notre classe implémentation du business
        business.setSomeDatService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});

        // Liaison du resultat du mock avec le service utilisé dans notre classe implémentation du business
        business.setSomeDatService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1});

        // Liaison du resultat du mock avec le service utilisé dans notre classe implémentation du business
        business.setSomeDatService(dataServiceMock);
        int actualResult = business.calculateSum(dataServiceMock.retrieveAllData());
        int expectedResult = 1;

        assertEquals(expectedResult, actualResult);
    }
}
