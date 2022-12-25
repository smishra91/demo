package com.verify.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PasswordApiResponse extends APIResponse{

    @JsonProperty
    Boolean isValid = false;
    @JsonProperty
    Boolean is1dTrue = true;

    public Boolean getIs1dTrue() {
        return is1dTrue;
    }

    public void setIs1dTrue(Boolean is1dTrue) {
        this.is1dTrue = is1dTrue;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

}
