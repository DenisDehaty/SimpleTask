package com.ddehaty.simpletask.message;

import com.ddehaty.simpletask.util.MessageStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timestamp;
    private String origin;
    private String destination;
    private String messageContent;
    @Enumerated(EnumType.STRING)
    private MessageStatus messageStatus;

    public Message(
            String timestamp,
            String origin,
            String destination,
            String messageContent,
            MessageStatus messageStatus
    ) {
        this.timestamp = timestamp;
        this.origin = origin;
        this.destination = destination;
        this.messageContent = messageContent;
        this.messageStatus = messageStatus;
    }

    public Message() {
    }
}
