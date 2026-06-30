package api.tests;

import api.base.BaseTest;
import api.models.EchoResponse;
import io.restassured.response.Response;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DELETE-запросы к /delete")
public class DeleteTests extends BaseTest {

    private static final String DELETE_ENDPOINT = "/delete";
    private static final String SAMPLE_TEXT = "This is expected to be sent back as part of response body.";

    @Test
    @DisplayName("Позитивный тест: DELETE с текстом в теле")
    void deleteWithText_shouldReturn200AndCorrectData() {

        var requestBody = SAMPLE_TEXT;

        Response response = givenRequest()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .delete(DELETE_ENDPOINT);

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
    @DisplayName("Негативный тест: DELETE с пустым телом")
    void deleteWithEmptyBody_shouldReturn200AndEmptyData() {

        Response response = givenRequest()
                .contentType("text/plain")
                .when()
                .delete(DELETE_ENDPOINT);

        response.then()
                .statusCode(200)
                .contentType("application/json");

        EchoResponse echoResponse = response.as(EchoResponse.class);

        assertThat(echoResponse.getData())
                .isInstanceOf(Map.class)
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .isEmpty();

        assertThat(echoResponse.getJson()).isNull();
    }

    @Test
    @DisplayName("Негативный тест: DELETE с JSON вместо текста")
    void deleteWithJson_shouldReturn200AndDataAsObject() {

        var requestBody = Map.of("test", "value");

        Response response = givenRequestWithBody(requestBody)
                .when()
                .delete(DELETE_ENDPOINT);

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
}
