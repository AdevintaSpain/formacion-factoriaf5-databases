create table featurette(
  movie_id text,
  item_order smallint
    constraint featurette_item_order_ck check (item_order >= 0),
  name text not null,
  url text not null,
  constraint featurette_pk primary key (movie_id, item_order)
);

alter table featurette
  add constraint featurette_movie_fk
  foreign key (movie_id)
  references movie(id) on delete cascade;