package currancy.service;

import currancy.Client;
import currancy.UtilClass;
import currancy.exeption.DataNotFound;
import currancy.model.ActualCurrencyRates;
import currancy.model.CurrencyPair;
import currancy.model.ExchangeRate;
import currancy.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
@EnableScheduling
public class Service {

    private final Client client;
    private final ExchangeRateRepository exchangeRateRepository;

    @Scheduled(fixedRate = 60000)
    public void saveActualCurrencyRates() {
        log.info("запущен метод saveActualCurrencyRates");
        List<CurrencyPair> pairs = getCurrencyPairs();
        ActualCurrencyRates currencyRates = getActualCurrencyRates();
        List<ExchangeRate> exchangeRates = createExchangeRates(pairs, currencyRates);
        List<ExchangeRate> list = exchangeRateRepository.saveAll(exchangeRates);
        log.info("Курсы валют сохранены" + list);
    }

    private List<ExchangeRate> createExchangeRates(List<CurrencyPair> pairs, ActualCurrencyRates currencyRates) {
        LocalDate actualRateDate = UtilClass.toLocalDate(currencyRates.getDate());
        Map<String, Double> actualRate = currencyRates.getRates();
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        for(CurrencyPair pair : pairs) {
            exchangeRates.add(new ExchangeRate(actualRateDate, actualRate.get(pair.getQuotedCharcode()), pair));
        }
        return exchangeRates;
    }

    private List<CurrencyPair> getCurrencyPairs() {
        if(client.getPairs().getBody() == null)
            throw new DataNotFound("Валютные пары в базе не обнаружены");
        return List.of(client.getPairs().getBody());
    }

    private ActualCurrencyRates getActualCurrencyRates(){
        return client.getActualCurrencyRates().getBody();
    }
}
