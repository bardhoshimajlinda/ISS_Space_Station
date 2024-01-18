package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.StationDao;
import dto.StationResponse;
import entities.Station;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StationService {
    protected StationDao stationDao;
    public StationService(StationDao stationDao) {
        this.stationDao = stationDao;
    }

    public void syncDatabaseWithWebService() {
        String url = "http://api.open-notify.org/iss-now.json";
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Call call = client.newCall(request);
            Response response = call.execute();
            String body = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            StationResponse stationResponse = mapper.readValue(body, StationResponse.class);
            String info = String.format("%s, %s",
                    stationResponse.getPosition().getLat(),
                    stationResponse.getPosition().getLng()
            );
            System.out.println(info);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
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
