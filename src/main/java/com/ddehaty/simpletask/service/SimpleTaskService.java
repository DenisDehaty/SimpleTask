package com.ddehaty.simpletask.service;

import com.ddehaty.simpletask.util.HttpBadRequestException;
import com.ddehaty.simpletask.util.ImportJson;
import com.ddehaty.simpletask.util.MetricsResponse;
import com.ddehaty.simpletask.call.Call;
import com.ddehaty.simpletask.call.CallRepository;
import com.ddehaty.simpletask.message.Message;
import com.ddehaty.simpletask.message.MessageRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.ddehaty.simpletask.util.MessageStatus.DELIVERED;
import static com.ddehaty.simpletask.util.MessageStatus.SEEN;
import static com.ddehaty.simpletask.util.StatusCode.*;

@Service
@Transactional
public class SimpleTaskService {

    private final CallRepository callRepository;
    private final MessageRepository messageRepository;

    public SimpleTaskService(CallRepository callRepository, MessageRepository messageRepository) {
        this.callRepository = callRepository;
        this.messageRepository = messageRepository;
    }

    public void loadMessages(List<ImportJson> importJsons) {
        var calls = new ArrayList<Call>();
        var messages = new ArrayList<Message>();

        for (var json : importJsons) {
            var messageType = json.getMessageType();

            if (messageType.equals("CALL")) {
                calls.add(createCall(json));
            } else if (messageType.equals("MSG")) {
                messages.add(createMessage(json));
            } else {
                throw new HttpBadRequestException(
                        "Message type does not have valid format. Received type is: " + messageType
                );
            }
        }

        callRepository.saveAll(calls);
        messageRepository.saveAll(messages);
    }

    public MetricsResponse getMetrics() {
        var numberOfCalls = callRepository.countAllCalls();
        var numberOfMessages = messageRepository.countAllMessages();
        var numberOfRows = numberOfCalls + numberOfMessages;
        var callOrigins = callRepository.getDistinctOrigins();
        var messageOrigins = messageRepository.getDistinctOrigins();
        var callDestinations = callRepository.getDistinctDestination();
        var messageDestinations = messageRepository.getDistinctDestination();

        var distinctOrigins = Stream
                .concat(callOrigins.stream(), messageOrigins.stream())
                .distinct()
                .count();

        var distinctDestinations = Stream
                .concat(callDestinations.stream(), messageDestinations.stream())
                .distinct()
                .count();


        return new MetricsResponse(
                // here I was unsure what to do
                0,
                numberOfRows,
                numberOfCalls,
                numberOfMessages,
                distinctOrigins,
                distinctDestinations
        );
    }

    private Call createCall(ImportJson importJson) {
        var timestamp = importJson.getTimestamp();
        var origin = importJson.getOrigin();
        var destination = importJson.getDestination();
        var duration = importJson.getDuration();
        var statusCode = importJson.getStatusCode();
        var statusDescription = importJson.getStatusDescription();

        if (!timestamp.equals("") && !origin.equals("")
                && !destination.equals("") && !duration.equals("")
                && !statusCode.equals("") && !statusDescription.equals("")
        ) {
            if (statusCode.equals("OK")) {

                return new Call(timestamp, origin, destination, Long.parseLong(duration), OK, statusDescription);

            } else if (statusCode.equals("KO")) {

                return new Call(timestamp, origin, destination, Long.parseLong(duration), KO, statusDescription);

            } else {
                throw new HttpBadRequestException(
                        "Status code is not valid. Received code is: " + statusCode
                );
            }
        } else {
            throw new HttpBadRequestException(
                    "One of fields is not valid"
            );
        }
    }

    private Message createMessage(ImportJson importJson) {
        var timestamp = importJson.getTimestamp();
        var origin = importJson.getOrigin();
        var destination = importJson.getDestination();
        var messageContent = importJson.getMessageContent();
        var messageStatus = importJson.getMessageStatus();

        if (!timestamp.equals("") && !origin.equals("")
                && !destination.equals("") && !messageContent.equals("")
                && !messageStatus.equals("")
        ) {
            if (messageStatus.equals("DELIVERED")) {

                return new Message(timestamp, origin, destination, messageContent, DELIVERED);

            } else if (messageStatus.equals("SEEN")) {

                return new Message(timestamp, origin, destination, messageContent, SEEN);

            } else {
                throw new HttpBadRequestException(
                        "Message status is not valid. Received status is: " + messageStatus
                );
            }
        } else {
            throw new HttpBadRequestException(
                    "One of fields is not valid"
            );
        }
    }


}
