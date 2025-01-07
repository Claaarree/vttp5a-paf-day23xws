-- select the database
use acme;

-- create one or more tables
-- you let the person choose their id if the id means smt to them
-- eg social media handles
-- application generated identity vs user supplied identity
-- line below is a print statement
select "Creating po table...";
create table po (
    po_id varchar(128) not null, -- this is the PK
    name varchar(128) not null,
    address varchar(128) not null,
    delivery_date date not null,

    constraint pk_po_id primary key(po_id)
);

select "Creating line items table...";
create table line_item (
    name varchar(128) not null, -- this is the PK
    quantity int not null,
    unit_price decimal(5, 2) not null
    po_id varchar(128) not null, 

    constraint pk_name primary key(name),
    constraint fk_po_id foreign key (po_id)
        references po(po_id)
);

-- line below is a print statement
select "Grant privileges to fred";
grant all privileges on acme.* to 'fred'@'%';
flush privileges;