package selfstudy.transactions.api.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import selfstudy.transactions.api.dto.request.ReceivableRequest;
import selfstudy.transactions.api.model.Payable;
import selfstudy.transactions.api.model.QContract;
import selfstudy.transactions.api.model.QReceivable;
import selfstudy.transactions.api.model.Receivable;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PayableRepository extends JpaRepository<Payable, Long>, QuerydslPredicateExecutor<Payable> {
}
