create table room(
    room_number varchar(25) PRIMARY KEY,
    floor_number varchar(25),
    is_occupied varchar(25),
    max_occupancy int,
    has_ac varchar(25),
    has_swimming_pool_access varchar(25),
    has_gym_access varchar(25)
    );