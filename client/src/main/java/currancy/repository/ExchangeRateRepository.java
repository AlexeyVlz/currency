package currancy.repository;

import currancy.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {


}
