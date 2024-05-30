package com.example.ejb;

import java.util.Random;
import javax.ejb.Stateless;

@Stateless
public class PrecipitationSensor {
    public int[] getMockPrecipitationData() {
        Random random = new Random();
        int[] precipitationData = new int[7]; // 7 days of data
        for (int i = 0; i < precipitationData.length; i++) {
            precipitationData[i] = random.nextInt(100); // Random precipitation values between 0 and 100
        }
        return precipitationData;
    }
}
