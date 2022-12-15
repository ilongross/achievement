create table level
(
    id            serial primary key,
    parent_id     bigint,
    name          varchar(50) default '',
    jump_points   int not null,
    scored_points int not null ,
    start_tree    boolean default false not null,
    deleted       boolean default false
);