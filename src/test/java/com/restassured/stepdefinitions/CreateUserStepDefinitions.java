package com.restassured.stepdefinitions;

import com.restassured.tasks.CreateANewUser;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import net.thucydides.core.util.EnvironmentVariables;

public class CreateUserStepDefinitions {
    private EnvironmentVariables environmentVariables;

    @When("^(.*) send a user creation request with his job (.*)$")
    public void stevSendAUserCreationRequestWithHisJobDeveloper(String name, String job) {
        OnStage.theActorCalled(name).whoCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl"))).attemptsTo(CreateANewUser.inTheSystem(name, job));

    }

    @Then("^he sees that the user was created$")
    public void hisSeesThatTheUserWasCreated() {
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(response->response.statusCode(201)));
    }
}
