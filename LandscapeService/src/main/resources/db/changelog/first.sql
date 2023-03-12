-- https://github.com/garethflowers/docker-postgres-plperl-server/blob/main/Dockerfile
-- plperlu installation example
create or replace function validate_email(email varchar(42)) returns bool as $$
    use Email::Valid
    return Email::Valid->address(email)
$$ language plperlu;

create table if not exists users
(
    id bigserial primary key,
    u_login varchar(42) not null check (u_login ~* '[^\W\w\d]'),
    email text not null check (validate_email(email)),
    telephone varchar(22) not null check (octet_length(telephone) between 1 + 8 and 1 + 15 and telephone ~ '^\+\d+$'),
    creation_date timestamp with time zone not null,
    last_update_date timestamp with time zone not null
);