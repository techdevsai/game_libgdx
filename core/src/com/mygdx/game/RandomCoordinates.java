package com.mygdx.game;

import java.util.Random;

/**
 * Created by SAI KIRAN on 7/26/2017.
 */

public class RandomCoordinates {
    public static int randomGenerate(int max,int min){

        Random rn = new Random();
        int x_ran =max- min+ 1;
        int x =  rn.nextInt(x_ran) ;
        
        return  x;


    }
}
