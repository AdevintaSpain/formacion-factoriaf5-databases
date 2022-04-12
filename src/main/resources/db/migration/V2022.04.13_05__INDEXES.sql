create index concurrently movie_title_idx
  on movie(title);

create index concurrently movie_platform_platform_idx
  on movie_platform(platform_id);
