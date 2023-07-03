package selfstudy.transactions.api.dto.request;

import java.math.BigDecimal;

public class PayableRequest {

    private String contractNumber;
    private BigDecimal balance;

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
