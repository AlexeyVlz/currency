package currancy;

import currancy.model.ActualCurrencyRates;
import currancy.model.CurrencyPair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Client {

    public Client() {
    }

    @Value("${web.url}")
    private String baseUri;

    public ResponseEntity<CurrencyPair[]> getPairs() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Object> requestEntity = new HttpEntity<>(null, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080" + "/currency-pairs",
                HttpMethod.GET,
                requestEntity,
                CurrencyPair[].class
        );
    }

    public ResponseEntity<ActualCurrencyRates> getActualCurrencyRates() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Object> requestEntity = new HttpEntity<>(null, headers);
        RestTemplate restTemplate = new RestTemplate();
        setIgnoreMediaType(restTemplate);
        return restTemplate.exchange(
                "https://www.cbr-xml-daily.ru/latest.js",
                HttpMethod.GET,
                requestEntity,
                ActualCurrencyRates.class
        );
    }

    private void setIgnoreMediaType(RestTemplate restTemplate) {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
    }
}
