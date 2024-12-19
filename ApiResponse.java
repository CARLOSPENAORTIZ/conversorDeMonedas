public class ApiResponse {
    public String result;
    public String documentation;
    public String terms_of_use;
    public long time_last_update_unix;
    public String time_last_update_utc;
    public long time_next_update_unix;
    public String time_next_update_utc;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public void setTerms_of_use(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    public long getTime_last_update_unix() {
        return time_last_update_unix;
    }

    public void setTime_last_update_unix(long time_last_update_unix) {
        this.time_last_update_unix = time_last_update_unix;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public void setTime_last_update_utc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }

    public long getTime_next_update_unix() {
        return time_next_update_unix;
    }

    public void setTime_next_update_unix(long time_next_update_unix) {
        this.time_next_update_unix = time_next_update_unix;
    }

    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    public void setTime_next_update_utc(String time_next_update_utc) {
        this.time_next_update_utc = time_next_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public ConversionRatesData getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(ConversionRatesData conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public String base_code;
    public ConversionRatesData conversion_rates;

    // Getters and setters (opcional, pero recomendado)
}