package currancy.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exchange_rate_id", nullable = false)
    private Integer id;
    @Column(name = "rate_date", nullable = false)
    private LocalDate rateDate;
    @Column(name = "rate_value", nullable = false)
    private Double rateValue;
    @ManyToOne
    @JoinColumn(name = "currency_pair_id")
    private CurrencyPair currencyPair;

    public ExchangeRate(LocalDate rateDate, Double rateValue, CurrencyPair currencyPair) {
        this.rateDate = rateDate;
        this.rateValue = rateValue;
        this.currencyPair = currencyPair;
    }

    public ExchangeRate() {
    }
}
