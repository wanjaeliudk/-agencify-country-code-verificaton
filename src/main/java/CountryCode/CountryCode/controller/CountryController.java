package CountryCode.CountryCode.controller;

import CountryCode.CountryCode.dto.CountryDto;
import CountryCode.CountryCode.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<CountryDto> getAllCountryCodes() {
        return countryService.getAllCountryCodes();
    }
}
