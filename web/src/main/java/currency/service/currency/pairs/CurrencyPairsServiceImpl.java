package currency.service.currency.pairs;

import currency.exeption.ConflictDataException;
import currency.model.currency.pair.CurrencyPair;
import currency.model.currency.pair.CurrencyPairMapping;
import currency.model.currency.pair.dto.AbstractCurrencyPairDto;
import currency.model.currency.pair.dto.CurrencyPairDtoIn;
import currency.repository.CurrencyPairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyPairsServiceImpl implements CurrencyPairsService{

    private final CurrencyPairRepository currencyPairRepository;

    public List<AbstractCurrencyPairDto> getCurrencyPairs() {
        return currencyPairRepository.findAll()
                .stream()
                .map(CurrencyPairMapping::toCurrencyPairDtoOut)
                .collect(Collectors.toList());
    }

    public AbstractCurrencyPairDto addCurrencyPair(CurrencyPairDtoIn currencyPairDtoIn) {
        if (currencyPairRepository.findCurrencyPair(currencyPairDtoIn.getBaseCharcode(),
                currencyPairDtoIn.getQuotedCharcode()) != null)
            throw new ConflictDataException("Данная валютная пара уже занесена в базу");
        CurrencyPair currencyPair = currencyPairRepository.save(CurrencyPairMapping.toCurrencyPair(currencyPairDtoIn));
        return CurrencyPairMapping.toCurrencyPairDtoOut(currencyPair);
    }
}
