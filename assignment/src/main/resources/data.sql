DROP TABLE IF EXISTS prices;

DROP TABLE IF EXISTS brand;

CREATE TABLE prices (
  id bigint not null auto_increment,
  brand_id bigint null,
  price_list bigint null,
  curr varchar null,
  start_date timestamp null,
  product_id bigint null,
  priority int null,
  end_date timestamp null,
  price double null,
  primary key (id)
);

CREATE TABLE brand (
  id bigint not null auto_increment,
  name varchar null,
  primary key (id)
);

ALTER TABLE prices
  add foreign key (brand_id)
  references brand (id);
  
INSERT INTO brand (name) VALUES ('Zara');

INSERT INTO prices (brand_id, price_list, curr, start_date, product_id, priority, end_date, price) VALUES
(1, 1, 'EUR', '2020-06-14 00:00:00', 35455, 0, '2020-12-31 23:59:59', 35.50 ),
(1, 2, 'EUR', '2020-06-14 15:00:00', 35455, 1, '2020-06-14 18:30:00', 25.45 ),
(1, 3, 'EUR', '2020-06-15 00:00:00', 35455, 1, '2020-06-15 11:00:00', 30.50 ),
(1, 4, 'EUR', '2020-06-15 16:00:00', 35455, 1, '2020-12-31 23:59:59', 38.95 );