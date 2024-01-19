package services;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PeopleDao;
import dao.StationDao;
import dto.PeopleDto;
import dto.PersonDto;
import entities.People;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.hibernate.Transaction;
import utils.DatabaseUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PeopleService {
    private PeopleDao peopleDao;

    public PeopleService(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }
    public void printPeopleInSpace() {
        String url = "http://api.open-notify.org/astros.json";
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Call call = client.newCall(request);
            Response response = call.execute();
            try {
                String body = response.body().string();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(body);

                if ("success".equals(jsonNode.path("message").asText())) {
                    int numberOfPeople = jsonNode.path("number").asInt();
                    System.out.println("Number of people in space: " + numberOfPeople);

                    JsonNode peopleNode = jsonNode.path("people");
                    for (JsonNode personNode : peopleNode) {
                        String name = personNode.path("name").asText();
                        String craft = personNode.path("craft").asText();
                        System.out.println("Name: " + name + ", Craft: " + craft);
                    }
                } else {
                    System.out.println("Error retrieving information about people in space.");
                }
            } finally {
                response.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
