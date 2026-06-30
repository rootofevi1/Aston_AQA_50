package api.tests;

import api.base.BaseTest;
import api.models.EchoResponse;
import io.restassured.response.Response;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PATCH-запросы к /patch")
public class PatchTests extends BaseTest {

    private static final String PATCH_ENDPOINT = "/patch";
    private static final String SAMPLE_TEXT = "This is expected to be sent back as part of response body.";

    @Test
    @DisplayName("Позитивный тест: PATCH с текстом в теле")
    void patchWithText_shouldReturn200AndCorrectData() {

        var requestBody = SAMPLE_TEXT;

        Response response = givenRequest()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .patch(PATCH_ENDPOINT);

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
    @DisplayName("Негативный тест: PATCH с пустым телом")
    void patchWithEmptyBody_shouldReturn200AndEmptyData() {

        Response response = givenRequest()
                .contentType("text/plain")
                .when()
                .patch(PATCH_ENDPOINT);

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
    @DisplayName("Негативный тест: PATCH с JSON вместо текста")
    void patchWithJson_shouldReturn200AndDataAsObject() {

        var requestBody = Map.of("test", "value");

        Response response = givenRequestWithBody(requestBody)
                .when()
                .patch(PATCH_ENDPOINT);

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
