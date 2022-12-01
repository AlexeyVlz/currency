package currency.model.currency.pair;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "currency_pair")
public class CurrencyPair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_pair_id", nullable = false)
    private Integer id;
    @Column(name = "base_charcode", nullable = false, length = 5)
    private String baseCharcode;
    @Column(name = "quoted_charcode", nullable = false, length = 5)
    private String quotedCharcode;
    @Column(name = "description", nullable = false, length = 100)
    private String description;

    public CurrencyPair(String baseCharcode, String quotedCharcode, String description) {
        this.baseCharcode = baseCharcode;
        this.quotedCharcode = quotedCharcode;
        this.description = description;
    }

    public CurrencyPair() {
    }
}
