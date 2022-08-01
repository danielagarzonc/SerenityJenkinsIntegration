package com.restassured.tasks;

import com.restassured.utils.GetJsonObject;
import model.UserInfo;
import model.UserInfoBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;


public class CreateANewUser implements Task {
    private UserInfo userInfo;

    public CreateANewUser(UserInfo userInfo){
        this.userInfo = userInfo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/api/users").with(
                requestSpecification ->
                        requestSpecification.header("Content-Type", "application/json")
                                .body(GetJsonObject.convertToJson(userInfo))
        ));
    }

    public static CreateANewUser inTheSystem(String name, String job){
        return Tasks.instrumented(CreateANewUser.class, UserInfoBuilder.with().theName(name).andTheJob(job).build());
    }
}
