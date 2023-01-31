package CountryCode.CountryCode.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountryDataUtil {
    public Map<String, String> phoneNumberRegex = new HashMap<>();
    public Map<String, String> countryCode = new HashMap<>();

    public Map<String, String> checkCountryCodes() {
        if (countryCode.isEmpty()) {
            countryCode.put("Cameroon", "237");
            countryCode.put("Ethiopia", "251");
            countryCode.put("Morocco", "212");
            countryCode.put("Mozambique", "258");
            countryCode.put("Uganda", "256");
        }
        return countryCode;
    }

    public Map<String, String> checkPhoneNumberRegex() {
        if (phoneNumberRegex.isEmpty()) {
            phoneNumberRegex.put("cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$");
            phoneNumberRegex.put("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$");
            phoneNumberRegex.put("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$");
            phoneNumberRegex.put("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$");
            phoneNumberRegex.put("Uganda", "\\(256\\)\\ ?\\d{9}$");
        }
        return phoneNumberRegex;
    }
}
