create table payment (
 payment_id varchar(26) primary key,
    booking_id varchar(26),
    resident_name varchar(26),
    floor_number varchar(26),
    check_in_date date,
    check_out_date date,
    payment_date date,
    payment_method varchar(26),
    bill_amount double,
    FOREIGN KEY(booking_id) REFERENCES booking(booking_id)

);
