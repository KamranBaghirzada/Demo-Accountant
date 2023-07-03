package selfstudy.transactions.api.model;

import com.querydsl.core.annotations.QueryEntity;
import jakarta.persistence.*;

@Entity
@QueryEntity
@Table(name = "a_contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "contract_number")
    private String contractNumber;

    @OneToOne(mappedBy = "contract")
    private Receivable receivable;

    @OneToOne(mappedBy = "contract")
    private Payable payable;
}
