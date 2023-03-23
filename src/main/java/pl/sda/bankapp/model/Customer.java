package pl.sda.bankapp.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Customer {

    private long id;
    private int age;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String pesel;
    private Address address;
    private LocalDate dateOfBirth;

    public Customer() {
    }

    public Customer(long id, String name, String surname, String phone,
                    String email, String pesel, Address address, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.pesel = pesel;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

//    private int calculateAge() {
//        LocalDate now = LocalDate.now();
//        int years = now.getYear() - dateOfBirth.getYear();
//        int month = now.getMonthValue() - dateOfBirth.getMonthValue();
//        if (month >= 0) {
//            int days = now.getDayOfMonth() - dateOfBirth.getDayOfMonth();
//            if (days >= 0) {
//                years++;
//            }
//        }
//        return years;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                age == customer.age &&
                Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(pesel, customer.pesel) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(dateOfBirth, customer.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, surname, phone, email,
                pesel, address, dateOfBirth);
    }
}
