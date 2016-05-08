drop table if exists temp;
create table temp (
  id integer primary key autoincrement,
  temp text not null,
  pub_date text not null
);

drop table if exists hum;
create table hum (
  id integer primary key autoincrement,
  hum text not null,
  pub_date text not null
);