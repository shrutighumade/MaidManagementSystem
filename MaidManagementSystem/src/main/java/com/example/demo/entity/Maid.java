package com.example.demo.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



//@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("MAID")
public class Maid {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maidId;

	  @Column(name = "Name", length = 30)
	    @NotEmpty(message = "Name cannot be empty")
	    @Size(max = 30, message = "Name length must be at most 30 characters")	
	  private String name;
	
	   @Column(name = "Gender", length = 7)
	    @Size(max = 7, message = "Gender length must be at most 7 characters")
	   private String gender;
  	
	    @Column(name = "Age", length = 2)
	    @Size(max = 2, message = "Age length must be at most 2 characters")
	    private String age;
	
	    @Column(name = "Location", length = 30)
	    @Size(max = 30, message = "Location length must be at most 30 characters")
	    private String location;
	
	
	
	    @Column(name = "Experience", length = 2)
	    private int experienceYears;
	
	@Column(name= "Salary_Expectation", length=7)
	private double expectedSalary;
	
	  @Column(name = "Native_Place", length = 30)
	    @Size(max = 30, message = "Native Place length must be at most 30 characters")
	    
	private String nativePlace;
	
	    @Column(name = "Preferred_City", length = 30)
	    @Size(max = 30, message = "Preferred City length must be at most 30 characters")
	    private String preferredCity;
	
	    @Column(name = "Marital_Status", length = 10)
	    @Size(max = 10, message = "Marital Status length must be at most 10 characters")
	    private String maritalStatus;
	
	    @Column(name = "Religion", length = 10)
	    @Size(max = 10, message = "Religion length must be at most 10 characters")
	    private String religion;
	
	    @Column(name = "Education", length = 30)
	    @Size(max = 30, message = "Education length must be at most 30 characters")
	    private String education;
	
	    @Column(name = "Languages", length = 50)
	    @Size(max = 50, message = "Languages length must be at most 50 characters")
	    private String languagesKnown;
	
	    @Column(name = "Vaccination", length = 30)
	    @Size(max = 30, message = "Vaccination length must be at most 30 characters")
	    private String vaccination;
	
	@Column(name="Pet_Friendly",  length=3)
	private boolean petFriendly;
	
	
	   @Column(name = "Availability", length = 10)
	    @Size(max = 10, message = "Availability length must be at most 10 characters")
	   private String availability;//FullTime, PartTime
	
	   @Column(name = "Skills")
	    @Size(max = 255, message = "Skills length must be at most 255 characters")
	   private String skills;
		
	@Column(name= "Hourly_Rate",  length=7)
	private double hourlyRate;

	
	@OneToMany(mappedBy = "maid")
	@JsonIgnore
	private List<Booking> booking;


	public int getMaidId() {
		return maidId;
	}


	public void setMaidId(int maidId) {
		this.maidId = maidId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getExperienceYears() {
		return experienceYears;
	}


	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}


	public double getExpectedSalary() {
		return expectedSalary;
	}


	public void setExpectedSalary(double expectedSalary) {
		this.expectedSalary = expectedSalary;
	}


	public String getNativePlace() {
		return nativePlace;
	}


	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}


	public String getPreferredCity() {
		return preferredCity;
	}


	public void setPreferredCity(String preferredCity) {
		this.preferredCity = preferredCity;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public String getReligion() {
		return religion;
	}


	public void setReligion(String religion) {
		this.religion = religion;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getLanguagesKnown() {
		return languagesKnown;
	}


	public void setLanguagesKnown(String languagesKnown) {
		this.languagesKnown = languagesKnown;
	}


	public String getVaccination() {
		return vaccination;
	}


	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}


	public boolean isPetFriendly() {
		return petFriendly;
	}


	public void setPetFriendly(boolean petFriendly) {
		this.petFriendly = petFriendly;
	}


	public String getAvailability() {
		return availability;
	}


	public void setAvailability(String availability) {
		this.availability = availability;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public double getHourlyRate() {
		return hourlyRate;
	}


	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}


	public List<Booking> getBooking() {
		return booking;
	}


	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	
	
//	@NotNull(message = "Enter the CategoryId for the Maid.")
//    private Integer maidcategoryid;	
//	
//	   // Publisher relationship
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "clientId")
//    private Client client;
//    
//    @NotNull(message = "Enter the ClientId for the Maid.")
//    private Integer maidclientid;

	

	 

}
