package api.tests;

import api.base.BaseTest;
import api.models.EchoResponse;
import io.restassured.response.Response;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PUT-запросы к /put")
public class PutTests extends BaseTest {

    private static final String PUT_ENDPOINT = "/put";
    private static final String SAMPLE_TEXT = "This is expected to be sent back as part of response body.";

    @Test
    @DisplayName("Позитивный тест: PUT с текстом в теле")
    void putWithText_shouldReturn200AndCorrectData() {

        var requestBody = SAMPLE_TEXT;

        Response response = givenRequest()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .put(PUT_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getData())
                .isInstanceOf(String.class)
                .asString()
                .isEqualTo(SAMPLE_TEXT);

        assertThat(echoResponse.getJson()).isNull();
        assertThat(echoResponse.getForm()).isEmpty();
        assertThat(echoResponse.getArgs()).isEmpty();
    }

    @Test
    @DisplayName("Негативный тест: PUT с пустым телом")
    void putWithEmptyBody_shouldReturn200AndEmptyData() {

        Response response = givenRequest()
                .contentType("text/plain")
                .when()
                .put(PUT_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getData())
                .isInstanceOf(String.class)
                .asString()
                .isEmpty();

        assertThat(echoResponse.getJson()).isNull();
    }

    @Test
    @DisplayName("Негативный тест: PUT с JSON вместо текста")
    void putWithJson_shouldReturn200AndDataAsObject() {

        var requestBody = Map.of("test", "value");

        Response response = givenRequestWithBody(requestBody)
                .when()
                .put(PUT_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getData())
                .isInstanceOf(Map.class)
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .containsExactlyInAnyOrderEntriesOf(requestBody);

        assertThat(echoResponse.getJson())
                .isInstanceOf(Map.class)
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .containsExactlyInAnyOrderEntriesOf(requestBody);
    }

    @Test
    @DisplayName("Негативный тест: PUT со специальными символами")
    void putWithSpecialCharacters_shouldReturn200AndCorrectText() {

        String specialText = "Hello! @#$%^&*()_+{}|:\"<>?~";

        Response response = givenRequest()
                .contentType("text/plain")
                .body(specialText)
                .when()
                .put(PUT_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getData())
                .isInstanceOf(String.class)
                .asString()
                .isEqualTo(specialText);
    }
}
