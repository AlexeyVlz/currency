package currency.service.exchange.rate;

import currency.UtilClass;
import currency.exeption.DataNotFound;
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
        Double exchangeRate = exchangeRateRepository.getExchangeRate(currencyPairId, date);
        if(exchangeRate == null) throw new DataNotFound(String.format("Курс валютной пары с id = %d и датой = %s не " +
                        "обнаружен.Проверьте наличие валютной пары в базе и корректность даты", currencyPairId, stringDate));
        return exchangeRate;
    }

    public Double getCurrentExchangeRate(Integer currencyPairId) {
        Double exchangeRate = exchangeRateRepository.getCurrentExchangeRate(currencyPairId);
        if(exchangeRate == null) throw new DataNotFound(String.format
                ("Курс валютной пары с id = %d не обнаружен. Проверьте наличие валютной пары в базе", currencyPairId));
        return exchangeRate;
    }
}
