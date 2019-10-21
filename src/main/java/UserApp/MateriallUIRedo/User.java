package UserApp.MateriallUIRedo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *  @author Adam Renak
 */
@Entity
public class User {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String imagePath;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private String phone;


    
    /** 
     * @param firstName
     * @param lastName
     * @param email
     * @param imagePath
     * @param address
     * @param city
     * @param state
     * @param zipcode
     * @param country
     * @param phone
     * @return 
     */
    User() {}

    
    /** 
     * @param firstName
     * @param lastName
     * @param email
     * @param imagePath
     * @param address
     * @param city
     * @param state
     * @param zipcode
     * @param country
     * @param phone
     * @return 
     */
    public User(String firstName, String lastName, String email, String imagePath, 
        String address, String city, String state, String zipcode, String country, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imagePath = imagePath;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.phone = phone;
    }

    
    /** 
     * @return Long
     */
    public Long getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    
    /** 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    /** 
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    
    /** 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    } 

    
    /** 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * @return String
     */
    public String getImagePath() {
        return imagePath;
    }

    
    /** 
     * @param imagePath
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    
    /** 
     * @return String
     */
    public String getAddress() {
        return address;
    }

    
    /** 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    
    /** 
     * @return String
     */
    public String getCity() {
        return city;
    }

    
    /** 
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    
    /** 
     * @return String
     */
    public String getState() {
        return state;
    }

    
    /** 
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    
    /** 
     * @return String
     */
    public String getZipcode() {
        return zipcode;
    }

    
    /** 
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    
    /** 
     * @return String
     */
    public String getCountry() {
        return country;
    }

    
    /** 
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    
    /** 
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    
    /** 
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
            Objects.equals(lastName, user.lastName) &&
            Objects.equals(email, user.email);
    }

    
    /** 
     * @return String
     */
    @Override 
    public String toString() {
        return "id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + 
            ", email: " + email + "\n";
    }





}