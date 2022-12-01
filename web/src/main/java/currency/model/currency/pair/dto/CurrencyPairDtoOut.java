package currency.model.currency.pair.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyPairDtoOut implements AbstractCurrencyPairDto{

    private Integer id;
    private String baseCharcode;
    private String quotedCharcode;
    private String description;
}
