package api.tests;

import api.base.BaseTest;
import api.models.EchoResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GET-запросы к /get")
public class GetTests extends BaseTest {

    private static final String GET_ENDPOINT = "/get";

    @Test
    @DisplayName("Позитивный тест: GET с двумя параметрами")
    void getWithParams_shouldReturn200AndCorrectData() {

        var queryParams = Map.of("foo1", "bar1", "foo2", "bar2");

        Response response = givenRequest()
                .queryParams(queryParams)
                .when()
                .get(GET_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getArgs())
                .isNotNull()
                .containsExactlyInAnyOrderEntriesOf(queryParams);

        assertThat(echoResponse.getUrl())
                .isNotNull()
                .contains("foo1=bar1")
                .contains("foo2=bar2");

        assertThat(echoResponse.getHeaders())
                .isNotNull()
                .containsKey("host")
                .containsEntry("host", "postman-echo.com");
    }

    @Test
    @DisplayName("Негативный тест: GET без параметров")
    void getWithoutParams_shouldReturn200AndEmptyArgs() {

        Response response = givenRequest()
                .when()
                .get(GET_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getArgs())
                .isNotNull()
                .isEmpty();

        assertThat(echoResponse.getUrl())
                .isEqualTo("https://postman-echo.com/get");
    }

    @Test
    @DisplayName("Негативный тест: GET с одним параметром")
    void getWithOneParam_shouldReturn200AndOneArg() {

        var queryParams = Map.of("foo1", "bar1");

        Response response = givenRequest()
                .queryParams(queryParams)
                .when()
                .get(GET_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getArgs())
                .isNotNull()
                .hasSize(1)
                .containsExactlyInAnyOrderEntriesOf(queryParams);

        assertThat(echoResponse.getArgs())
                .doesNotContainKey("foo2");
    }

    @Test
    @DisplayName("Негативный тест: GET с пустыми значениями параметров")
    void getWithEmptyValues_shouldReturn200AndEmptyStrings() {

        var queryParams = Map.of("foo1", "", "foo2", "");

        Response response = givenRequest()
                .queryParams(queryParams)
                .when()
                .get(GET_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getArgs())
                .isNotNull()
                .containsEntry("foo1", "")
                .containsEntry("foo2", "");

        assertThat(echoResponse.getArgs().get("foo1")).isEmpty();
        assertThat(echoResponse.getArgs().get("foo2")).isEmpty();
    }
}
