package com.document.automation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataResponseFormat<T> {
    private int status;
    private T data;

    public DataResponseFormat(final int status, T data) {
        this.status = status;
        this.data = data;
    }

    public static<T> DataResponseFormat<T> response(final int status, T data) {
        return DataResponseFormat.<T>builder()
                .status(status)
                .data(data)
                .build();
    }


}
