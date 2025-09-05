import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class RequestMethodsTest {

    private static final String BASE_URL = "https://postman-echo.com";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo(BASE_URL + "/get?foo1=bar1&foo2=bar2"))
                .log().body();
    }

    @Test
    public void testPostRequest() {
        String returnString = "return string";

        given()
                .contentType("text/plain")
                .body(returnString)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(returnString))
                .body("json", nullValue())
                .body("headers", notNullValue())
                .body("headers", hasKey("host"))
                .body("headers", hasKey("content-type"))
                .body("headers", hasKey("user-agent"))
                .body("headers.content-type", startsWith("text/plain"))
                .body("url", equalTo(BASE_URL + "/post"))
                .log().body();
    }

    @Test
    public void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                    .post("/post")
                .then()
                    .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(""))
                .body("headers", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers", hasKey("user-agent"))
                .body("headers", hasKey("accept"))
                .body("headers.content-type", startsWith("application/x-www-form-urlencoded"))
                .body("url", equalTo(BASE_URL + "/post"))
                .log().body();
    }
    @Test
    public void testPutRequest() {
        String returnString = "return string";

        given()
                .baseUri(BASE_URL)
                .body(returnString)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data",  equalTo(returnString))
                .body("url", equalTo(BASE_URL + "/put"))
                .body("headers", notNullValue())
                .log().body();
    }

    @Test
    public void testPatchRequest() {
        String returnString = "return string";

        given()
                .contentType("text/plain")
                .body(returnString)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(returnString))
                .log().all();
    }

    @Test
    public void testDeleteRequest() {
        String returnString = "return string";

        given()
                .contentType("text/plain")
                .body(returnString)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(returnString))
                .body("url", equalTo(BASE_URL + "/delete"))
                .body("headers", notNullValue())
                .log().all();
    }
}
