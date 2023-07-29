alter database neophiler set timezone to 'UTC';

drop table if exists "user";

create table if not exists "user"
(
    id         serial
        primary key,
    first_name varchar(255)                        not null,
    last_name  varchar(255)                        not null,
    username   varchar(255)                        not null
        unique,
    email      varchar(255)                        not null,
    password   varchar(255)                        not null,
    created_at timestamp default CURRENT_TIMESTAMP not null,
    updated_at timestamp default CURRENT_TIMESTAMP not null
);

alter table "user"
    owner to postgres;

insert into "user" (first_name, last_name, username, email, password)
values ('test', 'test', 'test', 'test', 'test');
