package selfstudy.transactions.api.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface TransactionService {

    void accountCreditSale(String amount);
}
