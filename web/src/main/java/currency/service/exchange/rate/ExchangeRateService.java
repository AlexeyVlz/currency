package currency.service.exchange.rate;



public interface ExchangeRateService {

    Double getExchangeRate(Integer currencyPairId, String stringDate);

    Double getCurrentExchangeRate(Integer currencyPairId);
}
