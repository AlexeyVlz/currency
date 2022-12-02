package currency.repository;

import currency.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {

    @Query("select e.rateValue from ExchangeRate e where e.id = ?1 and e.rateDate = ?2")
    Double getExchangeRate(Integer id, LocalDate date);

    @Query(value = "select e.rate_value from exchange_rate e where e.currency_pair_id = ?1 " +
            "order by e.rate_date desc limit 1", nativeQuery = true)
    Double getCurrentExchangeRate(Integer id);
}
