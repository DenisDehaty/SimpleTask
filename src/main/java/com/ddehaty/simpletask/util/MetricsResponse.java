package com.ddehaty.simpletask.util;

public record MetricsResponse(
        long numberOfProcessedJsons,
        long numberOfRows,
        long numberOfCalls,
        long numberOfMessages,
        long numberOfDistinctOriginCodes,
        long numberOfDistinctDestinationCodes
) {
}
