package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EchoResponse {

    // Поля из ответа сервера
    private Map<String, String> args;
    private Object data;
    private Map<String, String> files;
    private Map<String, String> form;
    private Map<String, String> headers;
    private Object json;
    private String url;
}
