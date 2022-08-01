package com.restassured.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class RequestTheUserList implements Task {
    private static final String ENDPOINT ="/api/users?page=2";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(ENDPOINT));
    }

    public static RequestTheUserList registered(){
        return Tasks.instrumented(RequestTheUserList.class);
    }
}
