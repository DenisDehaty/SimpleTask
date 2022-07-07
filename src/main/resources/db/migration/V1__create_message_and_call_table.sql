CREATE TABLE message
(
    id                      SERIAL          PRIMARY KEY,
    timestamp               VARCHAR(20)     NOT NULL,
    origin                  VARCHAR(20)     NOT NULL,
    destination             VARCHAR(20)     NOT NULL,
    message_content         VARCHAR(200)    NOT NULL,
    message_status          VARCHAR(10)     NOT NULL
);

CREATE TABLE call
(
    id                      SERIAL          PRIMARY KEY,
    timestamp               VARCHAR(20)     NOT NULL,
    origin                  VARCHAR(20)     NOT NULL,
    destination             VARCHAR(20)     NOT NULL,
    duration                VARCHAR(10)     NOT NULL,
    status_code             VARCHAR(10)     NOT NULL,
    status_description      VARCHAR(10)     NOT NULL
);