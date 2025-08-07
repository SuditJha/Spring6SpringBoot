package com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bean.ATMCard;
import com.bean.Account;
import com.repository.ATMCardRepository;
import com.repository.AccountRepository;
import java.util.Optional;

@Component
public class ATMCardDAO {
    
    private static final Logger logger = LoggerFactory.getLogger(ATMCardDAO.class);
    
    @Autowired
    private ATMCardRepository atmCardRepository;
    
    @Autowired
    private AccountRepository accountRepository;
    
    public void issueATMCardToAccount(int accountNumber, ATMCard atmCardObject) {
        Optional<Account> accountOpt = accountRepository.findById(accountNumber);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            
            // Check if account already has an ATM card
            ATMCard existingCard = atmCardRepository.findByAccountAccountNumber(accountNumber);
            if (existingCard != null) {
                logger.error("ATM card not issued to account number {}", accountNumber);
                return;
            }
            
            atmCardObject.setAccount(account);
            atmCardRepository.save(atmCardObject);
            logger.info("ATM card successfully issued to account number {}", accountNumber);
        } else {
            logger.error("ATM card not issued to account number {}", accountNumber);
        }
    }
}