package pe.com.bootcamp.microservice.account.service;

import pe.com.bootcamp.microservice.account.dto.AccountDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
    public void createAcc(AccountDTO a);    
    public Mono<AccountDTO> findByAccId(String id); 
    public Flux<AccountDTO> findAllAcc(); 
    public Mono<AccountDTO> updateAcc(String id, AccountDTO a); 
    public Mono<Void> deleteAcc(String id);   
}
