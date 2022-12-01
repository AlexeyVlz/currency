package currency.model.currency.pair;

import currency.model.currency.pair.dto.CurrencyPairDtoIn;
import currency.model.currency.pair.dto.CurrencyPairDtoOut;

public class CurrencyPairMapping {

    public static CurrencyPair toCurrencyPair(CurrencyPairDtoIn currencyPairDtoIn) {
        return new CurrencyPair(currencyPairDtoIn.getBaseCharcode(),
                currencyPairDtoIn.getQuotedCharcode(),
                currencyPairDtoIn.getBaseCharcode() + "/" + currencyPairDtoIn.getQuotedCharcode());
    }

    public static CurrencyPairDtoOut toCurrencyPairDtoOut(CurrencyPair currencyPair) {
        return new CurrencyPairDtoOut(currencyPair.getId(),
                currencyPair.getBaseCharcode(),
                currencyPair.getQuotedCharcode(),
                currencyPair.getDescription());
    }
}
