package currancy.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyPair{

    private Integer id;
    private String baseCharcode;
    private String quotedCharcode;
    private String description;

    public CurrencyPair() {
    }
}
