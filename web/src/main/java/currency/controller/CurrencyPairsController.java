package currency.controller;

import currency.model.currency.pair.dto.AbstractCurrencyPairDto;
import currency.model.currency.pair.dto.CurrencyPairDtoIn;
import currency.service.currency.pairs.CurrencyPairsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
public class CurrencyPairsController {

    private final CurrencyPairsService currencyPairsService;

    @GetMapping("/currency-pairs")
    public List<AbstractCurrencyPairDto> getCurrencyPairs() {
        log.info("Получен запрос к эндпоинту: GET /currency-pairs");
        return currencyPairsService.getCurrencyPairs();
    }

    @PostMapping("/create-currency-pair")
    public AbstractCurrencyPairDto addCurrencyPair(@RequestBody @Valid CurrencyPairDtoIn currencyPairDtoIn) {
        log.info("Получен запрос к эндпоинту: POST /create-currency-pair; currencyPairDtoIn =" + currencyPairDtoIn);
        return currencyPairsService.addCurrencyPair(currencyPairDtoIn);
    }
}
