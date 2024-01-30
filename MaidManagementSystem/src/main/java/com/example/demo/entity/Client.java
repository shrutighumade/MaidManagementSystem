package com.example.demo.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@DiscriminatorValue("Client")
@Table(name = "client")
public class Client extends User {

    
	@OneToMany(mappedBy = "client")
	@JsonIgnore
	private List<Feedback> reviews;
    
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> booking;


	public List<Feedback> getReviews() {
		return reviews;
	}


	public void setReviews(List<Feedback> reviews) {
		this.reviews = reviews;
	}


	public List<Booking> getBooking() {
		return booking;
	}


	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	
}
