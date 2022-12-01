package currency.model.currency.pair.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CurrencyPairDtoIn implements AbstractCurrencyPairDto{

    @NotNull @NotBlank
    private String baseCharcode;
    @NotNull @NotBlank
    private String quotedCharcode;

    public CurrencyPairDtoIn(String baseCharcode, String quotedCharcode) {
        this.baseCharcode = baseCharcode;
        this.quotedCharcode = quotedCharcode;
    }
}
