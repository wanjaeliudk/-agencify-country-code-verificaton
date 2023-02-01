package CountryCode.CountryCode.service;

import CountryCode.CountryCode.dto.CountryDto;
import CountryCode.CountryCode.model.Country;
import CountryCode.CountryCode.repository.CountryRepository;
import CountryCode.CountryCode.util.CountryDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountryDataUtil countryDataUtil;

    @Override
    public List<CountryDto> getAllCountryCodes() {
        List<Country> countries = countryRepository.findAll();
        return filterNumbersByCountry(countries);

    }

    private List<CountryDto> filterNumbersByCountry(List<Country> countries) {
        List<CountryDto> countryDtoList = new ArrayList<>();
        CountryDto countryDto = new CountryDto();
        for (Country country : countries) {
            countryDto = countryDataUtil.validateNumber(country);
            countryDtoList.add(countryDto);
        }

        return countryDtoList;
    }
}
