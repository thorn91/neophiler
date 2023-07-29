package com.neophiler.api.controller.external.dto;

import java.util.Map;

public class TokenDTO {
    public String token;
    public Map<String, Object> additionalInfo;

    public TokenDTO(String token, Map<String, Object> additionalInfo) {
        this(token);
        this.additionalInfo = additionalInfo;
    }

    public TokenDTO(String token) {
        this.token = token;
    }

    public TokenDTO() {
    }
}
