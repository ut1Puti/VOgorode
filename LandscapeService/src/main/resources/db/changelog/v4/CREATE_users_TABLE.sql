create table if not exists users
(
    id bigserial primary key,
    u_type text not null,
    u_login varchar(42) not null check (u_login ~* '[^\W\w\d]'),
    email text not null check (email ~ '^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$'),
    telephone varchar(22) not null check (octet_length(telephone) between 1 + 8 and 1 + 15 and telephone ~ '^\+\d+$'),
    creation_date timestamp not null,
    last_update_date timestamp not null
);
