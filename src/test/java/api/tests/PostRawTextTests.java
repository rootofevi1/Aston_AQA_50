package api.tests;

import api.base.BaseTest;
import api.models.EchoResponse;
import io.restassured.response.Response;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("POST-запросы к /post (Raw Text)")
public class PostRawTextTests extends BaseTest {

    private static final String POST_ENDPOINT = "/post";

    @Test
    @DisplayName("Позитивный тест: POST с JSON в теле")
    void postWithJsonBody_shouldReturn200AndCorrectData() {

        var requestBody = Map.of("test", "value");

        Response response = givenRequestWithBody(requestBody)
                .when()
                .post(POST_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getJson())
                .isNotNull()
                .isInstanceOf(Map.class)
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .containsExactlyInAnyOrderEntriesOf(requestBody);

        assertThat(echoResponse.getData())
                .isNotNull()
                .isInstanceOf(Map.class)  // проверяем как Map
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .containsExactlyInAnyOrderEntriesOf(requestBody);

        assertThat(echoResponse.getForm()).isEmpty();
        assertThat(echoResponse.getArgs()).isEmpty();

        assertThat(echoResponse.getUrl())
                .isEqualTo("https://postman-echo.com/post");
    }

    @Test
    @DisplayName("Негативный тест: POST с пустым телом")
    void postWithEmptyBody_shouldReturn200AndEmptyData() {

        Response response = givenRequest()
                .when()
                .post(POST_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getJson()).isNull();
        assertThat(echoResponse.getData())
                .isInstanceOf(Map.class)
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .isEmpty();
        assertThat(echoResponse.getForm()).isEmpty();
        assertThat(echoResponse.getArgs()).isEmpty();
    }

    @Test
    @DisplayName("Негативный тест: POST с невалидным JSON")
    void postWithInvalidJson_shouldReturn200AndNullJson() {

        String invalidJson = "this is not json";

        Response response = givenRequest()
                .contentType("text/plain")
                .body(invalidJson)
                .when()
                .post(POST_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getJson()).isNull();
        assertThat(echoResponse.getData())
                .isInstanceOf(String.class)
                .asString()
                .isEqualTo("this is not json");
    }

    @Test
    @DisplayName("Негативный тест: POST с числом вместо объекта")
    void postWithNumber_shouldReturn200AndNullJson() {

        var requestBody = 12345;

        Response response = givenRequestWithBody(requestBody)
                .when()
                .post(POST_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getJson()).isNull();
        assertThat(echoResponse.getData()).isEqualTo("12345");
    }
}
