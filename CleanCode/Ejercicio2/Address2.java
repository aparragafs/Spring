package Ejercicio2;
public class Address2 {
    
    private String country;
    private String city;
    private String street;
    private String house;
    private String quarter;

    public String getFullAddress() {
        return String.format("%s, %s, %s, %s %s",
                country, city, street, house, quarter);
    }
    
}
