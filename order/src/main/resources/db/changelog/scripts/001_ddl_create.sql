--liquibase formatted sql

--changeset nikishin:create_orders
create table if not exists orders (
    id serial primary key,
    price real,
    created timestamp,
    is_done bool default false
)

--changeset nikishin:create_order_item
create table if not exists order_item (
    id serial primary key,
    name VARCHAR,
    category_name VARCHAR,
    item_price real,
    item_id int references orders(id)
)