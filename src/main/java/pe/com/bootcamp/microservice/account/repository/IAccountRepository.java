package pe.com.bootcamp.microservice.account.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.bootcamp.microservice.account.dto.AccountDTO;
 

@Repository
public interface IAccountRepository extends ReactiveMongoRepository<AccountDTO, String>{
}
