package selfstudy.transactions.api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import selfstudy.transactions.api.model.Receivable;
import selfstudy.transactions.api.model.Sale;
import selfstudy.transactions.api.repository.ReceivableRepository;
import selfstudy.transactions.api.repository.SaleRepository;
import selfstudy.transactions.api.service.TransactionService;

import java.math.BigDecimal;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final SaleRepository saleRepository;
    private final ReceivableRepository receivableRepository;

    public TransactionServiceImpl(SaleRepository saleRepository, ReceivableRepository receivableRepository) {
        this.saleRepository = saleRepository;
        this.receivableRepository = receivableRepository;
    }

    @Override
    public void accountCreditSale(String amount) {
        BigDecimal trAmount = new BigDecimal(amount);
        addSale(trAmount);
        addReceivable(trAmount);
    }

    private void addSale(BigDecimal trAmount) {
        Sale sale = saleRepository.findById(1L).get();
        BigDecimal currentBalance = sale.getBalance();
        BigDecimal changedBalance = currentBalance.add(trAmount);
        sale.setBalance(changedBalance);
        sale.setLastTransaction(changedBalance);
        saleRepository.save(sale);
        throw new RuntimeException("Test");
    }

    private void addReceivable(BigDecimal trAmount) {
        Receivable receivable = receivableRepository.findById(1L).get();
        BigDecimal currentBalance = receivable.getBalance();
        BigDecimal changedBalance = currentBalance.add(trAmount);
        receivable.setBalance(changedBalance);
        receivable.setLastTransactionValue(changedBalance);
        receivableRepository.save(receivable);
    }
}
