package CountryCode.CountryCode.util;

import CountryCode.CountryCode.dto.CountryDto;
import CountryCode.CountryCode.model.Country;
import org.springframework.stereotype.Component;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CountryDataUtil {

    private final String cameroonCode = "237";
    private final String ethiopiaCode = "251";
    private final String moroccoCode = "212";
    private final String ugandaCode = "256";
    private final String mozambiqueCode = "258";

    private Pattern cameroon = Pattern.compile("\\(237\\)\\ ?[2368]\\d{7,8}$");
    private Pattern ethiopia = Pattern.compile("\\(251\\)\\ ?[1-59]\\d{8}$");
    private Pattern morocco = Pattern.compile("\\(212\\)\\ ?[5-9]\\d{8}$");
    private Pattern mozambique = Pattern.compile("\\(258\\)\\ ?[2368]\\d{7,8}$");
    private Pattern uganda = Pattern.compile("\\(256\\)\\ ?\\d{9}$");


    public CountryDto validateNumber(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setStatus(checkValidity(country.getPhone()));
        countryDto.setCountryName(determineCountry(country.getPhone()));
        countryDto.setPhoneNumber(country.getPhone());
        return countryDto;
    }


    public boolean checkValidity(String phoneNumber) {
        Matcher matcherCameroon = cameroon.matcher(phoneNumber);
        Matcher matcherMorocco = morocco.matcher(phoneNumber);
        Matcher matcherEthiopia = ethiopia.matcher(phoneNumber);
        Matcher matcherUganda = uganda.matcher(phoneNumber);
        Matcher matcherMozambique = mozambique.matcher(phoneNumber);

        if (matcherCameroon.matches()) {
            return true;
        }

        if (matcherMorocco.matches()) {
            return true;
        }
        if (matcherEthiopia.matches()) {
            return true;
        }
        if (matcherUganda.matches()) {
            return true;
        }

        if (matcherMozambique.matches()) {
            return true;
        }

        return false;
    }

    private String determineCountry(String phoneNumber) {

        String countryName = null;


        char[] arr = phoneNumber.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < 4; i++) {
            builder.append(arr[i]);
        }


        if (builder.toString().trim().equals(cameroonCode)) {
            countryName = "Cameroon";
        }

        if (builder.toString().trim().equals(ethiopiaCode)) {
            countryName = "Ethiopia";
        }
        if (builder.toString().trim().equals(moroccoCode)) {
            countryName = "Morocco";
        }
        if (builder.toString().trim().equals(ugandaCode)) {
            countryName = "Uganda";
        }
        if (builder.toString().trim().equals(mozambiqueCode)) {
            countryName = "Mozambique";
        }
        return countryName;
    }

}
