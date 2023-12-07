package pojo;

public class BillingAddress {

    private String firstName;
    private String lastName;
    private String address1;
    private String city;
    private String postalCode;
    private String email;
    private String country;
    private String state;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }





    public BillingAddress() {
    }

    public BillingAddress(String firstName, String lastName, String address1, String city, String postalCode, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.city = city;
        this.postalCode = postalCode;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    private void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    private void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }


}
