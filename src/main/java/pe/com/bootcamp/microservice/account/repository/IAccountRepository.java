package pe.com.bootcamp.microservice.account.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.bootcamp.microservice.account.entity.Account;

@Repository
public interface IAccountRepository extends ReactiveCrudRepository<Account, String>{
}
