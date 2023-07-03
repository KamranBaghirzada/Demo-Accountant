package selfstudy.transactions.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import selfstudy.transactions.api.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
