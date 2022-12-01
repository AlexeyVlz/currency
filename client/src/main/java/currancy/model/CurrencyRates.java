package currancy.model;

import lombok.Data;


@Data
public class CurrencyRates {

    private String Date;
    private String PreviousDate;
    private String PreviousURL;
    private String Timestamp;
    private Object[] Valute;

    public CurrencyRates() {
    }
}
