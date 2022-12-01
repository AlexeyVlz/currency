package currency.service.currency.pairs;

import currency.model.currency.pair.dto.AbstractCurrencyPairDto;
import currency.model.currency.pair.dto.CurrencyPairDtoIn;

import java.util.List;

public interface CurrencyPairsService {

    List<AbstractCurrencyPairDto> getCurrencyPairs();

    AbstractCurrencyPairDto addCurrencyPair(CurrencyPairDtoIn currencyPairDtoIn);
}
