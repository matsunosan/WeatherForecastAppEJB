package com.example.ejb;

import javax.ejb.Remote;

@Remote
public interface PrecipitationSensorBean {
    int[] getMockPrecipitationData();
}
