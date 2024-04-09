package requests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;

public class apiCase {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://demoqa.com";

        RequestSpecification httpRequest = RestAssured.given();

         httpRequest.request(Method.GET, "/BookStore/v1/Books").then().
                assertThat().statusCode(200)
                .body("books[0].title", equalTo("Git Pocket Guide"))
                .body("books[1].title", equalTo("Learning JavaScript Design Patterns"))
                .body("books[2].title", equalTo("Designing Evolvable Web APIs with ASP.NET"))
                .body("books[3].title", equalTo("Speaking JavaScript"))
                .body("books[4].title", equalTo("You Don't Know JS"))
                .extract().response();







    }


}
