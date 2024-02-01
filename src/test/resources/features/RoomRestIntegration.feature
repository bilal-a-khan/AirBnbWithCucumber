Feature:
  I want to be able to integration test Spring endpoints

  Scenario Outline:
    Given I have a Rest Spring Endpoint at <UriBase>
    When I call the room <Endpoint> by name for rooms
    Then <Room> is the result from the server

    Examples:
      | UriBase                 | Endpoint                 | Room          |
      | "http://localhost:8080" | "/room?name=Cliffhanger" | "Cliffhanger" |
      | "http://localhost:8080" | "/room?name=Slickrock" | "Slickrock"   |