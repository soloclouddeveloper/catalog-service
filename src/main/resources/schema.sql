DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    author              varchar(255) not null,
    isbn                varchar(255) not null,
    price               float8 not null,
    title               varchar(255) not null,
    created_date        timestamp not null,
    last_modified_date  timestamp not null,
    version             integer not null
)