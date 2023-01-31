package CountryCode.CountryCode.dto;

public class CountryDto {

    private String countryName;
    private String phoneNumber;
    private Boolean valid;

    public CountryDto() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "countryName='" + countryName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", valid=" + valid +
                '}';
    }
}
