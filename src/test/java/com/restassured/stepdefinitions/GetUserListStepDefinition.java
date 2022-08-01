package com.restassured.stepdefinitions;

import com.restassured.tasks.RequestTheUserList;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import net.thucydides.core.util.EnvironmentVariables;

import static org.hamcrest.Matchers.hasItem;

public class GetUserListStepDefinition {
    private EnvironmentVariables environmentVariables;

    @Given("^(.*) request the list of users$")
    public void thatAndreaRequestTheListOfUsers(String actorName){
        OnStage.theActorCalled(actorName).whoCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl")))
                .attemptsTo(RequestTheUserList.registered());
    }

    @Then("^sees the user list sucessfully$")
    public void seesTheUserListSucessfully(){
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(response->response.statusCode(200)));

    }

    @And("^sees (.*) in the list$")
    public void seesLinsayInTheList(String username){
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(response->response.body("data.first_name", hasItem(username))));
    }
}
