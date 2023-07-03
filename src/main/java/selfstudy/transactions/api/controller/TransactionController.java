package selfstudy.transactions.api.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import selfstudy.transactions.api.service.TransactionService;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PatchMapping("/credit-sale")
    public void accountCreditSale(@RequestParam String amount) {
        transactionService.accountCreditSale(amount);
    }
}
