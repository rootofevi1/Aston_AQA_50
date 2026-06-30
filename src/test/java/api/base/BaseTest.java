package api.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    protected static final String BASE_URL = "https://postman-echo.com";
    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setUp() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.config = RestAssured.config()
                .httpClient(
                        io.restassured.config.HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 5000)
                                .setParam("http.socket.timeout", 10000)
                );
    }

    // Вспомогательный метод для GET-запросов
    protected RequestSpecification givenRequest() {
        return RestAssured.given()
                .spec(requestSpec);
    }

    // Вспомогательный метод для запросов с телом
    protected RequestSpecification givenRequestWithBody(Object body) {
        return RestAssured.given()
                .spec(requestSpec)
                .body(body);
    }
}
