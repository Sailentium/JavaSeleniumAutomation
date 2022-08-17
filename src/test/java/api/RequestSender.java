package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestSender {

    protected RequestSpecification client;

    RequestSender() {
        client = RestAssured.given().relaxedHTTPSValidation();
    }

    protected Response requestMaker(Method method, String endPointUrl) {
        return requestMaker(method, endPointUrl, null);
    }

    protected Response requestMaker(Method method, String endPointUrl, String body) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        if (endPointUrl.contains("plugin")) {
            builder.setBaseUri("/test");
        }

        builder.setContentType(ContentType.JSON);

        if (body != null) {
            builder.setBody(body);
        }

        RequestSpecification requestSpecification = builder.build();
        client.spec(requestSpecification);

        try {
            Response response = client.request(method, endPointUrl);
            System.out.println("************************");
            System.out.println(response.getStatusCode());
            System.out.println("************************");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String sendGet(String url) {
        Response response = requestMaker(Method.GET, url);
        return response.body().asString();
    }

    protected String sendDelete(String url) {
        Response response = requestMaker(Method.DELETE, url);
        return response.body().asString();
    }

    protected String sendPut(String url, String body) {
        Response response = requestMaker(Method.PUT, url, body);
        return response.body().asString();
    }

    protected String sendPatch(String url, String body) {
        String response = requestMaker(Method.PATCH, url, body).body().asString();
        try {
            Pattern pattern = Pattern.compile("4\\d{2} [^0-9]]");
            Matcher matcher = pattern.matcher(response);
            if (matcher.find()) {
                System.out.println("***********Bad response*************");
                System.out.println(response);
                System.out.println("************************");
            }
        } catch (NullPointerException e) {
            response = "No data in the response";
        }
        return response;
    }

    protected String sendPost(String url, String body) {
        String response = requestMaker(Method.POST, url, body).body().asString();
        try {
            Pattern pattern = Pattern.compile("4\\d{2} [^0-9]]");
            Matcher matcher = pattern.matcher(response);
            if (matcher.find()) {
                System.out.println("***********Bad response*************");
                System.out.println(response);
                System.out.println("************************");
            }
        } catch (NullPointerException e) {
            response = "No data in the response";
        }
        return response;
    }
}
