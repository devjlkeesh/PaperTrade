package dev.jlkeesh.papertrade.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data<T> {
    private T body;
    private AppErrorDto error;
    private final boolean success;
    private Long total;

    public Data(T body) {
        this(body, null);
    }

    public Data(T body, Long total) {
        this.body = body;
        this.total = total;
        this.success = true;
    }

    public Data(AppErrorDto error) {
        this.error = error;
        this.success = false;
    }

}
