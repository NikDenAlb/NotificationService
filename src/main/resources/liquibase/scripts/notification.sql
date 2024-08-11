-- liquibase formatted sql

-- changeset dnikulin:1

CREATE TABLE notification
(
    id          UUID,
    customer_id UUID,
    message     TEXT,
    sent_at     TEXT
);
