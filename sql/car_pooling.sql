-- Delete all objects in current schema

BEGIN
   FOR cur_rec IN (SELECT object_name, object_type
                     FROM user_objects
                    WHERE object_type IN
                             ('TABLE',
                              'VIEW',
                              'PACKAGE',
                              'PROCEDURE',
                              'FUNCTION',
                              'SEQUENCE'
                             ))
   LOOP
      BEGIN
         IF cur_rec.object_type = 'TABLE'
         THEN
            EXECUTE IMMEDIATE    'DROP '
                              || cur_rec.object_type
                              || ' "'
                              || cur_rec.object_name
                              || '" CASCADE CONSTRAINTS';
         ELSE
            EXECUTE IMMEDIATE    'DROP '
                              || cur_rec.object_type
                              || ' "'
                              || cur_rec.object_name
                              || '"';
         END IF;
      EXCEPTION
         WHEN OTHERS
         THEN
            DBMS_OUTPUT.put_line (   'FAILED: DROP '
                                  || cur_rec.object_type
                                  || ' "'
                                  || cur_rec.object_name
                                  || '"'
                                 );
      END;
   END LOOP;
END;
/
commit;

create table locations (
	loc VARCHAR2(30) PRIMARY KEY
);

create table user_details (
	user_id VARCHAR2(10) PRIMARY KEY,
	login_id VARCHAR2(50) NOT NULL UNIQUE CHECK (LENGTH(login_id) >= 8),
	fname VARCHAR2(50) NOT NULL,
	lname VARCHAR2(50) NOT NULL,
	passwd VARCHAR2(50) NOT NULL CHECK (LENGTH(passwd) >= 8)
);

create table customer (
	customer_id VARCHAR2(10) PRIMARY KEY,
	user_id VARCHAR2(10),
	phone NUMBER(10) NOT NULL UNIQUE,
	email VARCHAR2(255) NOT NULL UNIQUE,
	balance NUMBER(12,4) DEFAULT 0,
	license CHAR(10) UNIQUE,
	address VARCHAR2(255),
	loc VARCHAR2(30),
	CONSTRAINT fk_uid_customer FOREIGN KEY (user_id) REFERENCES user_details(user_id),
	CONSTRAINT fk_loc_customer FOREIGN KEY (loc) REFERENCES locations(loc)
);

create table employee (
	employee_id VARCHAR2(10) PRIMARY KEY,
	user_id VARCHAR2(10),
	qualification CHAR(3) NOT NULL CHECK (qualification in ('BM','FM','TSE','SE')),
	loc VARCHAR2(255) NOT NULL,
	CONSTRAINT fk_uid_employee FOREIGN KEY (user_id) REFERENCES user_details(user_id),
	CONSTRAINT fk_loc_employee FOREIGN KEY (loc) REFERENCES locations(loc)
);

create table car (
	car_number VARCHAR2(10) PRIMARY KEY,
	car_name VARCHAR2(255) NOT NULL,
	car_type VARCHAR2(10) NOT NULL CHECK (car_type in ('HATCHBACK', 'SEDAN', 'WAGON', 'SUV')),
	order_type CHAR(4) NOT NULL CHECK (order_type in ('POOL', 'RENT')),
	availability VARCHAR2(10) DEFAULT 'AVAILABLE' NOT NULL CHECK (availability in ('AVAILABLE','BOOKED','EXPIRED')),
	no_of_passengers NUMBER(1) NOT NULL,
	maintenance_cost NUMBER(8,2) DEFAULT 0,
	fuel_cost NUMBER(8,2) DEFAULT 0
);

create table carrental (
	rental_id VARCHAR2(10) PRIMARY KEY,
	car_number VARCHAR2(10),
	rate_per_km NUMBER(5,2) NOT NULL,
	km_travelled NUMBER(7,2) DEFAULT 0 NOT NULL,
	basic_rent NUMBER(6,2) NOT NULL,
	loc VARCHAR2(30),
	CONSTRAINT fk_carnum_carrental FOREIGN KEY (car_number) REFERENCES car(car_number),
	CONSTRAINT fk_loc_carrental FOREIGN KEY (loc) REFERENCES locations(loc)
);

create table carpooling (
	pooling_id VARCHAR2(10) PRIMARY KEY,
	car_number VARCHAR2(10),
	driver_salary NUMBER(8,2) NOT NULL,
	fare NUMBER(8,2) DEFAULT 0 NOT NULL,
	origin VARCHAR2(255) NOT NULL,
	destination VARCHAR2(255) NOT NULL,
	departure DATE NOT NULL,
	CONSTRAINT fk_carnum_carpool FOREIGN KEY (car_number) REFERENCES car(car_number)
);

create table booking (
	order_no VARCHAR2(10) PRIMARY KEY,
	customer_id VARCHAR2(10),
	car_number VARCHAR2(10),
	rental_id VARCHAR2(10),
	pooling_id VARCHAR2(10),
	booking_date DATE NOT NULL,
	end_date DATE NOT NULL,
	fare NUMBER(8,2) NOT NULL,
	tax NUMBER(7,2),
	tax_rate NUMBER(5,2),
	no_of_passengers NUMBER(1),
	pickup_point VARCHAR2(255),
	dropoff_point VARCHAR2(255),
	status VARCHAR2(10) CHECK (status in ('CAN','CNF','PEN','PENCAN','COMP','PENCOMP')),
	cancellation_reason VARCHAR2(255),
	CONSTRAINT fk_carnum_booking FOREIGN KEY (car_number) REFERENCES car(car_number),
	CONSTRAINT fk_custid_booking FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	CONSTRAINT fk_rentid_booking FOREIGN KEY (rental_id) REFERENCES carrental(rental_id),
	CONSTRAINT fk_poolid_booking FOREIGN KEY (pooling_id) REFERENCES carpooling(pooling_id)
);

create table invoice (
	invoice_no NUMBER(8) PRIMARY KEY,
	order_no VARCHAR2(10),
	customer_name VARCHAR2(255) NOT NULL,
	car_name VARCHAR2(255) NOT NULL,
	car_number VARCHAR2(10) NOT NULL,
	order_type CHAR(4) NOT NULL CHECK (order_type in ('POOL', 'RENT')),
	fare NUMBER(8,2) NOT NULL,
	tax NUMBER(7,2) NOT NULL,
	tax_rate NUMBER(5,2) NOT NULL,
	booking_date DATE NOT NULL,
	CONSTRAINT fk_ordernum_invoice FOREIGN KEY (order_no) REFERENCES booking(order_no)
);

create or replace function getUniqueVal
return VARCHAR2
as
	begin
	return dbms_random.string('X',10);
END getUniqueVal;
/

commit;
