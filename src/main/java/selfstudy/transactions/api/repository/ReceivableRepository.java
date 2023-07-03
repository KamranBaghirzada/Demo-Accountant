package selfstudy.transactions.api.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import selfstudy.transactions.api.dto.request.ReceivableRequest;
import selfstudy.transactions.api.model.QContract;
import selfstudy.transactions.api.model.QReceivable;
import selfstudy.transactions.api.model.Receivable;

import java.math.BigDecimal;
import java.util.List;

public interface ReceivableRepository extends JpaRepository<Receivable, Long>,
        QuerydslPredicateExecutor<Receivable> {


    default List<Receivable> findReceivableWithSearch(ReceivableRequest request, EntityManager entityManager) {
        QReceivable qReceivable = QReceivable.receivable;
        QContract qContract = QContract.contract;

        BooleanExpression predicate = qReceivable.contract.eq(qContract)
                .and(qContract.contractNumber.eq(request.getContractNumber()))
                .and(qReceivable.balance.eq(new BigDecimal(request.getBalance())));

        JPAQuery<Receivable> query = new JPAQuery<>(entityManager);

        List<Receivable> receivables = query.select(qReceivable)
                .from(qReceivable)
                .leftJoin(qReceivable.contract, qContract)
                .where(predicate)
                .fetch();
        return receivables;
    }
}