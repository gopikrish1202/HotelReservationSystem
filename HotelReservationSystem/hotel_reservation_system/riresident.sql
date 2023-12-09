
create TABLE riresident(
    resident_id varchar(25) primary key,
    resident_name varchar(25),
    age int,
    gender varchar(25),
    contact_number bigint,
    email varchar(25),
    address varchar(25),
    number_of_adults int,
    number_of_children_above12 int,
    number_of_children_above5 int,
    duration_of_stay int,
    resident_type varchar(25),
    idproof_aadharno bigint
    );