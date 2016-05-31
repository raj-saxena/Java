package com.xyz.helper;

import java.util.ArrayList;
import java.util.List;

import com.xyz.model.Station;

/**
 * Created by raj on 17/4/16.
 */
public class StationManager {

    private static final List<Station> STATIONS = new ArrayList<>();

    static public void initializeStations() {
        STATIONS.add(new Station("A1"));
        STATIONS.add(new Station("A2"));
        STATIONS.add(new Station("A3"));
        STATIONS.add(new Station("A4"));
        STATIONS.add(new Station("A5"));
        STATIONS.add(new Station("A6"));
        STATIONS.add(new Station("A7"));
        STATIONS.add(new Station("A8"));
        STATIONS.add(new Station("A9"));
        STATIONS.add(new Station("A10"));
    }

    public static int getStationTravelledCount(Station exitStation, Station enterStation) {
        return Math.abs(STATIONS.indexOf(exitStation) - STATIONS.indexOf(enterStation));
    }

    public static Station getStationAt(int location) {
        return STATIONS.get(location);
    }
}
