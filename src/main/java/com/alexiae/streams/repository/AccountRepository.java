package com.alexiae.streams.repository;

import com.alexiae.streams.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
