package com.hpk.api.service;

import com.hpk.api.component.model.Location;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class LocationService {
    public static final Map<String, Location> locationMap = new HashMap<>();

    @PostConstruct
    private void setLocationMap(){
        //TODO add realization for part of college
        locationMap.put("1 корпус", new Location());
        locationMap.put("2 корпус", new Location());
    }
}
