create table if not exists users
(
    id         bigserial not null primary key,
    first_name varchar   not null,
    last_name  varchar   not null,
    birthday   date      not null
)
