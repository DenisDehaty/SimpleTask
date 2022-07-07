package com.ddehaty.simpletask.util;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ImportJson {

    @JsonAlias("message_type")
    private String messageType;
    @JsonAlias("timestamp")
    private String timestamp;
    @JsonAlias("origin")
    private String origin;
    @JsonAlias("destination")
    private String destination;
    @JsonAlias("duration")
    private String duration;
    @JsonAlias("status_code")
    private String statusCode;
    @JsonAlias("status_description")
    private String statusDescription;
    @JsonAlias("message_content")
    private String messageContent;
    @JsonAlias("message_status")
    private String messageStatus;

    public ImportJson() {}

    public ImportJson(
            String messageType,
            String timestamp,
            String origin,
            String destination,
            String duration,
            String statusCode,
            String statusDescription
    ) {
        this.messageType = messageType;
        this.timestamp = timestamp;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }

    public ImportJson(
            String messageType,
            String timestamp,
            String origin,
            String destination,
            String messageContent,
            String messageStatus
    ) {
        this.messageType = messageType;
        this.timestamp = timestamp;
        this.origin = origin;
        this.destination = destination;
        this.messageContent = messageContent;
        this.messageStatus = messageStatus;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDuration() {
        return duration;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getMessageStatus() {
        return messageStatus;
    }
}
