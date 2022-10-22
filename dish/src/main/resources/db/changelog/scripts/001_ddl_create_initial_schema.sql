--liquibase formatted sql

--changeset nikishin:create_categories
create table if not exists categories (
    id serial primary key,
    name VARCHAR unique,
    img bytea,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

--changeset nikishin:create_dishes
create table if not exists dishes (
    id serial primary key,
    name VARCHAR,
    description VARCHAR,
    rating int,
    cost real,
    weight int,
    img bytea,
    category_id int references categories(id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

