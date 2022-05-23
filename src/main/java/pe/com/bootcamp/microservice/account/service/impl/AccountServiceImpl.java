package pe.com.bootcamp.microservice.account.service.impl;
 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import pe.com.bootcamp.microservice.account.dto.AccountDTO;
import pe.com.bootcamp.microservice.account.repository.IAccountRepository;
import pe.com.bootcamp.microservice.account.service.AccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	@Autowired
	private IAccountRepository iAccountRepo;

	@Override
	public void createAcc(AccountDTO account) {
		iAccountRepo.save(account).subscribe();
	}

	@Override
	public Mono<AccountDTO> findByAccId(String id) {
		return iAccountRepo.findById(id);
	}

	@Override
	public Flux<AccountDTO> findAllAcc() {
		return iAccountRepo.findAll();
	}

	@Override
	public Mono<AccountDTO> updateAcc(String id, AccountDTO account) {
		return iAccountRepo.findById(id)
				.switchIfEmpty(Mono.error(new Exception("TASK_NOT_FOUND")))
				.map(fetchedAccount  -> {
					account.setId(id);
					if (account.getTypeAccount() != null) {fetchedAccount.setTypeAccount(account.getTypeAccount());}
					if (account.getProfileAccount() != null) {fetchedAccount.setProfileAccount(account.getProfileAccount());}
					if (account.getCondition() != null) {fetchedAccount.setCondition(account.getCondition());}
					if (account.getIdCustomer() != null) {fetchedAccount.setIdCustomer(account.getIdCustomer());}
					if (account.getNumMaxDeposit() != 0) {fetchedAccount.setNumMaxDeposit(account.getNumMaxDeposit());}
					if (account.getNumMaxWithdraw() != 0) {fetchedAccount.setNumMaxWithdraw(account.getNumMaxWithdraw());}
					if (account.getCurrency() != null) {fetchedAccount.setCurrency(account.getCurrency());}
					if (account.getInitialAmount() != 0.0d) {fetchedAccount.setInitialAmount(account.getInitialAmount());}
					if (account.getCurrentAmount() != 0.0d) {fetchedAccount.setCurrentAmount(account.getCurrentAmount());}
					if (account.getMinAmountAverage() != 0.0d) {fetchedAccount.setMinAmountAverage(account.getMinAmountAverage());}
					return fetchedAccount;
				})
				.flatMap(iAccountRepo::save);
	}

	@Override
	public Mono<Void> deleteAcc(String id) {
		return iAccountRepo.deleteById(id);
	}
}
