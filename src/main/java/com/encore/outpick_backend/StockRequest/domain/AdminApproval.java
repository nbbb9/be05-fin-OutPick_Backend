package com.encore.outpick_backend.StockRequest.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum AdminApproval {
    미승인("미승인"),
    승인("승인");

    private final String status;

    AdminApproval(final String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static AdminApproval of(final String parameter) {
        return Arrays.stream(values())
                .filter(status -> status.status.equals(parameter))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("관리자 승인 상태가 잘못되었습니다: " + parameter));
    }
}
