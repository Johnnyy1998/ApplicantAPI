package com.users.user_app.Applicants;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restful_web_services.user.User;
import com.rest.webservices.restful_web_services.user.UserNotFoundException;
import com.users.user_app.Accounts.Account;
import com.users.user_app.jpa.ApplicantRepository;

import jakarta.validation.Valid;

@RestController
public class ApplicantResource {

	private ApplicantRepository repository;

	public ApplicantResource(ApplicantRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping(path = "/applicants")
	public List<Applicant> retrieveAllApplicants(){
		return repository.findAll();
	}
	
	@GetMapping(path = "/applicants/{id}")
	public Optional<Applicant> retriveUser(@PathVariable Integer id){
		Optional<Applicant> applicant = repository.findById(id);
		return applicant;
		
	}	
	
	@PostMapping("/applicants")
	public ResponseEntity<Applicant> createUser(@Valid @RequestBody Applicant applicant) {
		Applicant savedUser = repository.save(applicant);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		//.created = response požadavek 201
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/applicants/{id}/accounts")
	public List<Account> retrieveAllUserPosts(@PathVariable Integer id){
		Optional<Applicant> applicant = repository.findById(id);
		if(applicant.isEmpty())
			throw new UserNotFoundException("id:"+id);
		return applicant.get().getAccount();
		
	}
	
			
}
