package currency.repository;

import currency.model.currency.pair.CurrencyPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CurrencyPairRepository extends JpaRepository<CurrencyPair, Integer> {

    @Query("select c.id from CurrencyPair c where c.baseCharcode = ?1 and c.quotedCharcode = ?2")
    Integer findCurrencyPair(String baseCharcode, String quotedCharcode);
}
