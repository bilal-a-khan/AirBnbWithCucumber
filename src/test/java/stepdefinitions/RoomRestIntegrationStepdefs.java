package stepdefinitions;

import com.airbnb.model.Room;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestClient;

public class RoomRestIntegrationStepdefs {

    RestClient restClient;

    String uriBase;

    Room room;

    @Given("I have a Rest Spring Endpoint at {string}")
    public void iHaveARestSpringEndpoint(String uri) {
        uriBase = uri;
        restClient = RestClient.create();
    }

    @When("I call the room {string} by name for rooms")
    public void iCallTheRoomEndpointByNameForRooms(String endpoint) {
        room = restClient.get()
                .uri(uriBase+endpoint)
                .retrieve()
                .body(Room.class);
    }

    @Then("{string} is the result from the server")
    public void cliffhangerIsTheResultFromTheServer(String roomName) {
        Assertions.assertEquals(roomName,room.getName());
    }

}
