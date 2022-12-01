package currency.service.exchange.rate;

import currency.UtilClass;
import currency.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService{

    private final ExchangeRateRepository exchangeRateRepository;

    public Double getExchangeRate(Integer currencyPairId, String stringDate) {
        LocalDate date = UtilClass.toLocalDate(stringDate);
        return exchangeRateRepository.getExchangeRate(currencyPairId, date);
    }

    public Double getCurrentExchangeRate(Integer currencyPairId) {
        return exchangeRateRepository.getCurrentExchangeRate(currencyPairId);
    }
}
