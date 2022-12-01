package currancy.service;

import currancy.Client;
import currancy.exeption.DataNotFound;
import currancy.model.CurrencyPair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Slf4j
public class Service {

    private final Client client;

    public void updateExchangeRate() {
        if(client.getPairs().getBody() == null)
            throw new DataNotFound("Валютные пары в базе не обнаружены");
        List<CurrencyPair> pairs = List.of(client.getPairs().getBody());
    }

    public void getActualCurrencyRates(){
        log.info("log: " + String.valueOf(client.getActualCurrencyRates().getBody()));
    }
}
