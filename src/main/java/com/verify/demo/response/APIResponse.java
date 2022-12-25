package com.verify.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APIResponse {

    @JsonProperty
    private ProcessSummary processSummary;

    public ProcessSummary getProcessSummary() {
        return processSummary != null ? processSummary : new ProcessSummary();
    }

    public void setProcessSummary(ProcessSummary processSummary) {
        this.processSummary = processSummary;
    }

}
