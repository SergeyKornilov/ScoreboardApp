package ru.kornilov.scoreboard;

import ru.kornilov.scoreboard.DTO.EventDTO;

import javax.ejb.Singleton;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Named
@Singleton
@ManagedBean(name="restClient")
@SessionScoped
public class RestClient {


    private static List<EventDTO> events;


    private static final String REST_URI
            = "http://localhost:8080/rest/event";

    private Client client = ClientBuilder.newClient();

    public void getJsonEvent() {
        System.out.println("hello from getJsonEvent");

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URI);

        Response response = target.request().get();
        RestClient.events = Arrays.asList(response.readEntity(EventDTO[].class));

    }




    public List<EventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }

    public String formatDate(String date) throws ParseException {

        LocalDateTime datetime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));

        String formatedDate = datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return formatedDate;
    }

}