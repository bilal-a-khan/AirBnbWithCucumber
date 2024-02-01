package stepdefinitions;

import com.airbnb.controller.RoomController;
import com.airbnb.model.Room;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomIntegrationStepdefs {

    @Autowired
    RoomController roomController;

    Room room;
    @Given("I have a Spring Endpoint")
    public void iHaveASpringEndpoint() {
        Assertions.assertNotNull(roomController);
    }

    @When("I call the endpoint by {string} name for rooms")
    public void iCallTheEndpointByNameForRooms(String roomName) {
        room = roomController.findByName(roomName);
    }


    @Then("{string} should return from the server")
    public void roomShouldReturnFromTheServer(String roomName) {
        Assertions.assertEquals(roomName, room.getName());
    }


}
