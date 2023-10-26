package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCont {

	@Autowired
	private UserRepo us;
	@GetMapping("/pageone1")
	List<User>getpageone(){
		Pageable paging = PageRequest.of(0, 10, Sort.by("pid").ascending());
		Page<User>p=us.findAll(paging);
		return p.getContent();
	}
	@PostMapping("/user")
	public ResponseEntity<User>savedata(@RequestBody User user){
		return new ResponseEntity<User>(us.save(user),HttpStatus.CREATED);
	}
	@GetMapping("/user")
	public ResponseEntity<List<User>>getall(){
		return new ResponseEntity<>(us.findAll(),HttpStatus.CREATED);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User>getdata(@PathVariable int id,@RequestBody User u){
		Optional<User>op=us.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@PutMapping("/user/{id}")
	public ResponseEntity<User>updatedata(@PathVariable int id,@RequestBody User u){
		Optional<User>op=us.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(us.save(op.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User>deletedata(@PathVariable int id,@RequestBody User u){
		Optional<User>op=us.findById(id);
		if(op.isPresent()) {
			us.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
