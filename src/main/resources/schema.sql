drop table if exists Book;

create table Book (
                      id int primary key auto_increment ,
                      title varchar(500) not null ,
                      author varchar(100) not null,
                      year_of_publishing int check (year_of_publishing<2023),
                      price double check (price>0),
                      description varchar not null,
                      book_type varchar(50)not null
);

drop table if exists Person;

create table Person (
                        id int primary key auto_increment ,
                        name varchar(100) not null ,
                        surname varchar(100) not null,
                        email varchar(50) not null ,
                        card_last_four_digits varchar,
                        book_id int,
                        foreign key (book_id) references Book(id) on delete set null
);

