-- V1__Create_tables.sql

CREATE TABLE organizations (
                               id SERIAL PRIMARY KEY,
                               name VARCHAR(255) NOT NULL,
                               contact VARCHAR(255)
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(255) NOT NULL
);
