package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users") // Renamed table to "users" for better clarity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Username can't be empty")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Only Alphabets and Numeric Values are Allowed.")
    @Size(min = 3, max = 20, message = "Username should be between 3 and 20 characters.")
    @Column(name = "username", length = 20)
    private String username;

    @NotEmpty(message = "User password can't be empty")
    private String password;

    @NotEmpty(message = "User email can't be empty")
    @Email(message = "Please Enter Appropriate Email Id")
    @Column(name = "email", length = 40)
    private String email;

    @NotEmpty(message = "First Name can't be empty.")
    @Size(min = 3, max = 20, message = "First Name should be between 3 and 20 characters.")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Allowed")
    @Column(name = "first_name", length = 20)
    private String firstName;

    @NotBlank(message = "Last Name can't be empty.")
    @Size(min = 3, max = 20, message = "Last Name should be between 3 and 20 characters.")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Allowed.")
    @Column(name = "last_name", length = 20)
    private String lastName;
    
    
    @Column(name = "Street", length = 50)
    @Size(max = 50, message = "Street length must be at most 50 characters")
    //@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only alphabets and spaces allowed")
    @NotBlank(message = "Street cannot be empty")
    private String street;

    @Column(name = "City", length = 50)
    @Size(max = 50, message = "City length must be at most 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only alphabets and spaces allowed")
    @NotBlank(message = "City cannot be empty")
    private String city;

    @Column(name = "State", length = 50)
    @Size(max = 50, message = "State length must be at most 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only alphabets and spaces allowed")
    @NotBlank(message = "State cannot be empty")
    private String state;

    @Column(name = "Country", length = 50)
    @Size(max = 50, message = "Country length must be at most 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only alphabets and spaces allowed")  // Consider using a more restrictive pattern or enum for country validation
    @NotBlank(message = "Country cannot be empty")
    private String country;

    @Column(name = "Pin_Code", length = 6)
    @Digits(integer = 6, fraction = 0, message = "Pin code must be exactly 6 digits")
    @NotBlank(message = "Pin code cannot be empty")
    private String pinCode;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    private Role role;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
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


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
    
}
