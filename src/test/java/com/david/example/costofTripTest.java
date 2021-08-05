package com.david.example;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class costofTripTest {


    private static CostofTrip costOfTrip = null;

    @Before
    public void init() throws IOException {
        costOfTrip =  new CostofTrip();
    }
    @Test
    public void caculateDistanceTest(){
        String startPointName="Keele Street";
        String endPointName = "Bathurst Street";
        double distance = costOfTrip.caculateDistance(startPointName,endPointName);
        System.out.println(distance);
        assert(distance==5.715);


    }
    @Test
    public void caculateAmountTest(){
        String startPointName="Keele Street";
        String endPointName = "Bathurst Street";
        double cost = costOfTrip.caculateCost(startPointName,endPointName) ;
        System.out.println(cost);
        assert(cost==1.429);

    }

}
