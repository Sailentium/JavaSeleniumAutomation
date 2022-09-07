package api;

import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.response.Response;
import tests.steps.apiSteps.ReqresAPISteps;

import java.util.Map;

public class ReqresAPI extends RequestSender {

    public void registerUser(Map<String, String> userData) {
        JsonObject userObject = new JsonObject();

        userObject.addProperty("email", userData.get("email"));
        userObject.addProperty("password", userData.get("password"));

        System.out.println("Request for register user" + "\n" + userObject);
        Response response = sendPost("https://reqres.in/api/register", userObject.toString());
        ReqresAPISteps.API_RESPONSE_DATA = response;
        System.out.println("Response from register user" + "\n" + response.body().asString());
    }

    public void loginUser(Map<String, String> userLoginData) {
        JsonObject userObject = new JsonObject();

        userObject.addProperty("email", userLoginData.get("email"));
        userObject.addProperty("password", userLoginData.get("password"));

        System.out.println("Request for register user" + "\n" + userObject);
        Response response = sendPost("https://reqres.in/api/register", userObject.toString());
        ReqresAPISteps.API_RESPONSE_DATA = response;
        System.out.println("Response from register user" + "\n" + response.body().asString());
    }
}
