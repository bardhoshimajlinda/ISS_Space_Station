package services;

import dao.StationDao;
import entities.Station;

public class StationService {
    protected StationDao stationDao;
    public StationService(StationDao stationDao) {
        this.stationDao = stationDao;
    }

    public void printIssLocation() {
        Station iss = stationDao.getStationByTitle("ISS");
        if (iss != null)
            System.out.println(
                    String.format(
                            "Station: %s Lat: %s Lng: %s",
                            iss.getTitle(),
                            iss.getLat(),
                            iss.getLng()
                    )
            );
        else
            System.out.println("ISS information is not present in database!");
    }
}
