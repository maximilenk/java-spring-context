drop table if exists users cascade;

CREATE TABLE IF NOT EXISTS users(
    id serial PRIMARY KEY,
    email varchar(15) NOT NULL,
    password varchar(15) NOT NULL
);
