package com.users.user_app.Accounts;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restful_web_services.user.Post;
import com.rest.webservices.restful_web_services.user.UserNotFoundException;
import com.users.user_app.Applicants.Applicant;
import com.users.user_app.jpa.AccountRepository;
import com.users.user_app.jpa.ApplicantRepository;

import jakarta.validation.Valid;

@RestController
public class AccountResource {
	
	private ApplicantRepository repository;
	private AccountRepository repository2;

	public AccountResource(ApplicantRepository repository, AccountRepository repository2) {
		super();
		this.repository = repository;
		this.repository2 = repository2;
	}

	
	@PostMapping("/applicants/{id}/accounts")
	public ResponseEntity<Post> createPost(@Valid @RequestBody Account account, @PathVariable Integer id) {
		Optional<Applicant> applicant = repository.findById(id);
		if(applicant.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		// uloží se instance třídy applicant
		account.setApplicant(applicant.get());
		Account savedAccount = repository2.save(account);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAccount.getID()).toUri();
		//.created = response požadavek 201
		return ResponseEntity.created(location).build();
	}
	
	/*	
	@GetMapping(path = "/accounts")
	public List<Account> retrieveAllApplicants(){
		return repository.findAll();
	}
	
	@PostMapping(path = "/accounts")
	public ResponseEntity<Object> createAccount(@RequestBody Account account) {
		Account savedAccount = repository.save(account);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAccount.getID()).toUri();
		//.created = response požadavek 201
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/accounts/{id}")
	public void DeleteUser(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	*/
}
