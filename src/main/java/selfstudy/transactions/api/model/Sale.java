package selfstudy.transactions.api.model;

import com.querydsl.core.annotations.QueryEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@QueryEntity
@Table(name = "a_sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "last_transaction")
    private BigDecimal lastTransaction;

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

    public BigDecimal getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(BigDecimal lastTransaction) {
        this.lastTransaction = lastTransaction;
    }
}
