create schema if not exists sandbox;

create table sandbox.t_product
(
    id UUID not null default gen_random_uuid(),
    c_title varchar(150) not null check ( length(trim(c_title)) >= 3 ),
    c_detail varchar(2500),
    c_depricated bool not null default false
);