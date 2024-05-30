package com.example.client;

import com.example.ejb.PrecipitationSensorBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class WeatherForecastClient {
    public static void main(String[] args) {

        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            Context context = new InitialContext(props);
            PrecipitationSensorBean sensor = (PrecipitationSensorBean) context.lookup("ejb:/PrecipitationSensorEJB//PrecipitationSensor!com.example.ejb.PrecipitationSensorBean");

            int[] precipitationData = sensor.getMockPrecipitationData();
            System.out.println("Weather Forecast:");
            for (int i = 0; i < precipitationData.length; i++) {
                System.out.println("Day " + (i + 1) + ": Precipitation: " + precipitationData[i] + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
