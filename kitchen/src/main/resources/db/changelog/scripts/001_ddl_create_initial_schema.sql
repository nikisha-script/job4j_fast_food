--liquibase formatted sql

--changeset nikishin:create_orders
create table if not exists orders (
    id serial primary key,
    text varchar
)