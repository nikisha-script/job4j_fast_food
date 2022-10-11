--liquibase formatted sql

--changeset nikishin:create_categories
create table if not exists categories (
    id serial primary key,
    title VARCHAR
);

--changeset nikishin:create_dishes
create table if not exists dishes (
    id serial primary key,
    name VARCHAR,
    cost real,
    category_id int references categories(id)
)

