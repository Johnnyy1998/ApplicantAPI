package com.users.user_app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.user_app.Accounts.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
