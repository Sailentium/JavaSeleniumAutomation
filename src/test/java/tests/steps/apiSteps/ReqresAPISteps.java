package tests.steps.apiSteps;

import api.ReqresAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

public class ReqresAPISteps {
    ReqresAPI reqresAPI = new ReqresAPI();
    public static Response API_RESPONSE_DATA;

    @Given("^I register user with following data to the reqres service:$")
    public void iRegisterUserWithFollowingDataToTheReqresService(DataTable userRegisterData) {
        List<Map<String, String>> rows = userRegisterData.asMaps(String.class, String.class);
        for (Map<String, String> user : rows) {
            reqresAPI.registerUser(user);
        }
    }

    @Then("^I should have (.*) status code for the previous api request$")
    public void iShouldHaveXxxCodeForThePreviousApiRequest(String statusCode) {
        assertThat("Status code from the last API request is incorrect", String.valueOf(API_RESPONSE_DATA.getStatusCode()), equalTo(statusCode));
    }

    @Then("^I should have following data in the response body for the previous api request:$")
    public void iShouldHaveXxxCodeForThePreviousApiRequest(DataTable responseJsonData) {
        List<Map<String, String>> rows = responseJsonData.asMaps(String.class, String.class);
        for (Map<String, String> response : rows) {
            if (response.containsKey("id")) {
                assertThat("Response does not contain id row", API_RESPONSE_DATA.getBody().asString(), containsStringIgnoringCase(response.get("id")));
            }
            if (response.containsKey("token")) {
                assertThat("Response does not contain id row", API_RESPONSE_DATA.getBody().asString(), containsStringIgnoringCase(response.get("token")));
            }
        }
    }

    @When("^I login as user to the reqres service:$")
    public void iLoginAsUserToTheReqresService(DataTable userLoginData) {
        List<Map<String, String>> rows = userLoginData.asMaps(String.class, String.class);
        for (Map<String, String> user : rows) {
            reqresAPI.loginUser(user);
        }
    }
}
