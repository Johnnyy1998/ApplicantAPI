package com.users.user_app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.user_app.Applicants.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{

}
