package co.micol.sypertest.movie.web;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;

import co.micol.sypertest.api.MovieAPI;
import co.micol.sypertest.emp.service.Dept;

@Controller
public class MovieController {

	@GetMapping("/restMovieList")
	@ResponseBody
	public JsonNode restMovieList() throws Exception {
		return MovieAPI.restMovieList();
	}

	@GetMapping("/movieList")
	@ResponseBody
	public JsonNode movieList() throws Exception {
		return MovieAPI.movieList();
	}

	@GetMapping("/movieInfo/{cd}")
	@ResponseBody
	public JsonNode movieInfo(@PathVariable String cd) throws Exception {
		System.out.println("cd 확인용 ======= " + cd);
		return MovieAPI.movieInfo(cd);
	}

}
