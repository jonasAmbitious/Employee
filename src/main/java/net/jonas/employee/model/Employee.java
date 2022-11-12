package net.jonas.employee.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDateTime;
@Entity
public class Employee implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "BUSINESS_UNIT")
    private String businessUnit;
    @Basic
    @Column(name = "CITY")
    private String city;
    @Basic
    @Column(name = "COUNTRY")
    private String country;
    @Basic
    @Column(name = "DATE_ADDED")
    private LocalDateTime dateAdded;

    @Basic
    @Column(name = "DATE_LAST_MODIFIED")
    private LocalDateTime date_last_modified;

    @Basic
    @Column(name = "MODIFICATION_COUNT")
    private  int modification_count;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalDateTime getDate_last_modified() {
        return date_last_modified;
    }

    public void setDate_last_modified(LocalDateTime date_last_modified) {
        this.date_last_modified = date_last_modified;
    }

    public int getModification_count() {
        return modification_count;
    }

    public void setModification_count(int modification_count) {
        this.modification_count = modification_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(businessUnit, employee.businessUnit) && Objects.equals(city, employee.city) && Objects.equals(country, employee.country) && Objects.equals(dateAdded, employee.dateAdded) && Objects.equals(date_last_modified, employee.date_last_modified) && Objects.equals(modification_count, employee.modification_count);
    }

    @Override
    public String toString(){
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                ", city='" + city + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", dateAdded=" + dateAdded + '\'' +
                ", date_last_modified=" + date_last_modified + '\'' +
                ", modification_count=" + modification_count +
                '}';
    }
}
