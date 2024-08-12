-- liquibase formatted sql

-- changeset dnikulin:1

CREATE TABLE notification
(
    id          TEXT PRIMARY KEY,
    customer_id TEXT,
    message     TEXT,
    sent_at     TEXT
);
