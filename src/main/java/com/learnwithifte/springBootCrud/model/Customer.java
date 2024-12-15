package com.learnwithifte.springBootCrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "First Name is required")
    @Size(min = 5, message = "First name should be at least 5 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Last Name is required")
    @Size(min = 5, message = "Last name should be at least 5 characters")
    private String lastName;

    @Column(name = "email")
    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "photo")
    private String photo;

    @Transient
    private String photosImagePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotosImagePath() {
        if(id == null || photo == null){
            return "images/avatar-default.jpg";
        }
        return "customer-photos/"+this.id+"/"+this.photo;
    }
}
