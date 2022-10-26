--liquibase formatted sql

--changeset nikishin:notification_order
create table if not exists notification_order (
    id serial primary key,
    text varchar
)