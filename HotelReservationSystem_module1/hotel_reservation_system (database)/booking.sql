create table booking (
    booking_id varchar(26) primary key,
    resident_id varchar(26),
    resident_name varchar(26),
    duration_of_stay int,
    number_of_adults int,
    number_of_children_above12 int,
    number_of_children_above5 int,
    check_in_date date,
    check_out_date date,
    floor_number varchar(25),
    room_number varchar(26),
    preferred_package varchar(27),
    ac_access varchar(28),
    pool_access varchar(29),
    gym_access varchar(30),
    foreign key (resident_id) references nriresident(resident_id),
    foreign key (resident_id) references riresident(resident_id)
);
