package selfstudy.transactions.api.model;

import com.querydsl.core.annotations.QueryEntity;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@QueryEntity
@Table(name = "a_receivables")
public class Receivable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "last_transaction_value")
    private BigDecimal lastTransactionValue;

    @Column(name = "reg_date")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate regDate;

    @Column(name = "last_transaction_date")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate lastTransactionDate;

    @Column(name = "transaction_count")
    private Long transactionCount;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    @JoinColumn(name = "contract_id", referencedColumnName = "id", nullable = true)
    private Contract contract;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLastTransactionValue() {
        return lastTransactionValue;
    }

    public void setLastTransactionValue(BigDecimal lastTransactionValue) {
        this.lastTransactionValue = lastTransactionValue;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public LocalDate getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(LocalDate lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public Long getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(Long transactionCount) {
        this.transactionCount = transactionCount;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
