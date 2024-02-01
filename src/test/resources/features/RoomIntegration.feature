Feature: I want to able to integration test Spring endpoints

  Scenario Outline:
    Given I have a Spring Endpoint
    When I call the endpoint by <Room> name for rooms
    Then <Room> should return from the server

    Examples:
      | Room          |
      | "Cliffhanger" |
      | "Slickrock" |