package com.ddehaty.simpletask.call;

import com.ddehaty.simpletask.util.StatusCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private java.lang.String timestamp;
    private java.lang.String origin;
    private java.lang.String destination;
    private Long duration;
    @Enumerated(EnumType.STRING)
    private StatusCode statusCode;
    private String statusDescription;

    public Call(
            String timestamp,
            String origin,
            String destination,
            Long duration,
            StatusCode statusCode,
            String statusDescription
    ) {
        this.timestamp = timestamp;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }

    public Call() {
    }

}
