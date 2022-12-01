package currency.controller;

import currency.service.exchange.rate.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("/exchange-rate")
    public Double getExchangeRate(@RequestParam @Positive Integer currencyPairId,
                                  @RequestParam @NotNull @NotBlank String date) {
        log.info(String.format("Получен запрос к эндпоинту: GET /exchange-rate; currencyPairId = %d, date = %s",
                currencyPairId, date));
        return exchangeRateService.getExchangeRate(currencyPairId, date);
    }

    @GetMapping("/current-exchange-rate")
    public Double getCurrentExchangeRate(@RequestParam @Positive Integer currencyPairId) {
        log.info(String.format("Получен запрос к эндпоинту: GET /current-exchange-rate; currencyPairId = %d",
                currencyPairId));
        return exchangeRateService.getCurrentExchangeRate(currencyPairId);
    }
}
