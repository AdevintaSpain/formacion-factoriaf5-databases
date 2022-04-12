package com.adevinta.factoriaf5.databases.infrastructure.controller;

import com.adevinta.factoriaf5.databases.application.movie.AddMovieUseCase;
import com.adevinta.factoriaf5.databases.application.movie.FindMoviesUseCase;
import com.adevinta.factoriaf5.databases.application.movie.LoadMovieUseCase;
import com.adevinta.factoriaf5.databases.domain.core.Page;
import com.adevinta.factoriaf5.databases.domain.core.PagedEntityCollection;
import com.adevinta.factoriaf5.databases.domain.movie.Featurette;
import com.adevinta.factoriaf5.databases.domain.movie.Movie;
import com.adevinta.factoriaf5.databases.domain.movie.request.AddMovieRequest;
import com.adevinta.factoriaf5.databases.domain.movie.request.SearchMovieRequest;
import com.adevinta.factoriaf5.databases.infrastructure.controller.resource.EntityCollectionResource;
import com.adevinta.factoriaf5.databases.infrastructure.controller.resource.MovieResource;
import com.adevinta.factoriaf5.databases.infrastructure.controller.resource.ResourceMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

  private final ResourceMapper resourceMapper;
  private final AddMovieUseCase addMovieUseCase;
  private final FindMoviesUseCase findMoviesUseCase;
  private final LoadMovieUseCase loadMovieUseCase;

  public MovieController(ResourceMapper resourceMapper,
                         AddMovieUseCase addMovieUseCase,
                         FindMoviesUseCase findMoviesUseCase,
                         LoadMovieUseCase loadMovieUseCase) {
    this.resourceMapper = resourceMapper;
    this.addMovieUseCase = addMovieUseCase;
    this.findMoviesUseCase = findMoviesUseCase;
    this.loadMovieUseCase = loadMovieUseCase;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MovieResource postMovie(@RequestBody MovieResource movieResource) {
    AddMovieRequest request = new AddMovieRequest(
          movieResource.getTitle(),
          movieResource.getSynopsis(),
          movieResource.getReleaseYear(),
          movieResource.getFeaturettes().stream().map(resource -> new Featurette(resource.getName(), resource.getUrl())).collect(Collectors.toList()),
          movieResource.getPlatforms().stream().map(resource -> resource.getId()).collect(Collectors.toList()));
    Movie movie = addMovieUseCase.execute(request);
    return resourceMapper.map(movie);
  }

  @GetMapping
  public EntityCollectionResource<MovieResource> getMoviesCollection(
        @RequestParam(name = "pageSize", required = false, defaultValue = "100") Integer pageSize,
        @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
        @RequestParam(name = "text", required = false) String text,
        @RequestParam(name = "minYear", required = false) Integer minYear,
        @RequestParam(name = "maxYear", required = false) Integer maxYear,
        @RequestParam(name = "platforms", required = false) List<String> platforms
  ) {
    Page page = new Page(pageSize, pageNumber);
    SearchMovieRequest request = new SearchMovieRequest(text, minYear, maxYear, platforms, page);
    PagedEntityCollection<Movie> entityCollection = findMoviesUseCase.execute(request);
    EntityCollectionResource<MovieResource> resource = new EntityCollectionResource<>();
    resource.setPageNumber(entityCollection.getPage().getNumber());
    resource.setPageSize(entityCollection.getPage().getSize());
    resource.setTotalCount(entityCollection.getTotalCount());
    List<MovieResource> movieResources = entityCollection.getCollection()
          .stream()
          .map(resourceMapper::map)
          .collect(Collectors.toList());
    resource.setCollection(movieResources);
    return resource;
  }

  @GetMapping("/{id}")
  public MovieResource loadMovie(@PathVariable("id") String id) {
    Movie movie = loadMovieUseCase.execute(id);
    return resourceMapper.map(movie);
  }
}
