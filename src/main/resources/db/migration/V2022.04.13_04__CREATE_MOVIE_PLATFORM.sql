create table movie_platform(
  movie_id text not null,
  platform_id text not null,
  constraint movie_platform_pk primary key (movie_id, platform_id)
);

alter table movie_platform
  add constraint movie_platform_movie_fk
  foreign key (movie_id)
  references movie(id) on delete cascade;

alter table movie_platform
  add constraint movie_platform_platform_fk
  foreign key (platform_id)
  references platform(id) on delete cascade;
