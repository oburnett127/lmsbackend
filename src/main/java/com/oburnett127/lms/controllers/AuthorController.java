package com.oburnett127.lms.controllers;

import com.oburnett127.MyEcomm.model.Author;
import com.oburnett127.MyEcomm.service.AuthorService;
import com.oburnett127.MyEcomm.util.ServiceError;
import com.oburnett127.lms.models.Author;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Controller
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(value = "/author", method = RequestMethod.POST)
	public @ResponseBody
	Author createauthor(@RequestBody Author author) {
		return authorService.createAuthor(author);
	}
	
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public @ResponseBody List<Author> getauthors() {
		return authorService.getAuthors();
	}
	
	@RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
	public @ResponseBody Author getauthor(@PathVariable(value="id") Integer id) {
		return authorService.getAuthor(id);
	}
	
	@RequestMapping(value = "/author", method = RequestMethod.PUT)
	public @ResponseBody Author updateauthor(@RequestBody Author author) {
		return authorService.updateAuthor(author);
	}
	
	@RequestMapping(value = "author/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
		authorService.deleteAuthor(id);
		return null;
	}
}