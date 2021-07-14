package com.stock.tool.wealthycorgi.util;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

public class ApiUtils {

    public static <T> ApiResult<T> success(T response) {
        return new ApiResult<>(200, "null", response);
    }

    public static ApiResult<?> error(Throwable throwable, HttpStatus httpStatus) {
        return new ApiResult<>(httpStatus.value(), throwable.getMessage(), null);
    }

    public static ApiResult<?> error(String throwable, HttpStatus httpStatus) {
        return new ApiResult<>(httpStatus.value(), throwable, null);
    }

    @Data
    public static class ApiResult<T> {
        private final Integer code;
        private final String message;
        private final T response;

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("code", code)
                    .append("message", message)
                    .append("response", response)
                    .toString();
        }
    }
}
