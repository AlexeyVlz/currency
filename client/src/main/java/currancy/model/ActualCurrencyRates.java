package currancy.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class ActualCurrencyRates {

    private String disclaimer;
    private String date;
    private String timestamp;
    private String base;
    private HashMap<String, Double> rates;

    public ActualCurrencyRates() {
    }
}