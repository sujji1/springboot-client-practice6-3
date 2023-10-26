package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
public class VechileOntr {

	@Autowired
	private VechileRepo vr;
	@PostMapping("/vech")
	public ResponseEntity<Vechile>savedata(@RequestBody Vechile v){
		return new ResponseEntity<Vechile>(vr.save(v),HttpStatus.CREATED);
	}
	@GetMapping("/vech")
	public ResponseEntity<List<Vechile>>getall(){
		return new ResponseEntity<>(vr.findAll(),HttpStatus.CREATED);
	}
	@GetMapping("/vech/{id}")
	public ResponseEntity<Vechile>getdata(@PathVariable int vid,@RequestBody Vechile v){
		Optional<Vechile>op=vr.findById(vid);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@PutMapping("/vech/{id}")
	public ResponseEntity<Vechile>updatedata(@PathVariable int vid,@RequestBody Vechile v){
		Optional<Vechile>op=vr.findById(vid);
		if(op.isPresent()) {
			return new ResponseEntity<>(vr.save(op.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/vech/{id}")
	public ResponseEntity<User>deletedata(@PathVariable int vid,@RequestBody Vechile v){
		Optional<Vechile>op=vr.findById(vid);
		if(op.isPresent()) {
			vr.deleteById(vid);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
