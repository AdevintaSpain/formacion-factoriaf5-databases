create table movie(
  id text constraint movie_pk primary key,
  title text not null,
  synopsis text not null,
  release_year smallint not null
    constraint movie_release_year_ck check (release_year > 0)
);