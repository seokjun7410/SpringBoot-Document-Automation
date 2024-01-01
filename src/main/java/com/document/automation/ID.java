package com.document.automation;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *  @client 반환시 정책에 맞게 변환 후 반환(ex UUID)
 *  @ID RequestDto
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class ID {
    @JsonProperty(value = "id")
    private Long value;
    public ID(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }


}
