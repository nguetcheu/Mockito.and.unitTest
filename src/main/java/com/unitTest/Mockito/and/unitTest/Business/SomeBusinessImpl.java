package com.unitTest.Mockito.and.unitTest.Business;

import com.unitTest.Mockito.and.unitTest.Data.SomeDataService;

public class SomeBusinessImpl {

    private SomeDataService someDatService;

    public void setSomeDatService(SomeDataService someDatService) {
        this.someDatService = someDatService;
    }

    public int calculateSum(int[] data){
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService(){
        int sum = 0;
        int[] data = someDatService.retrieveAllData();
        for (int value : data) {
            sum += value;
        }
        return sum;
    }
}
