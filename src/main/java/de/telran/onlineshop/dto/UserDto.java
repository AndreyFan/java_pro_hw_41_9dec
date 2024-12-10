package de.telran.onlineshop.dto;

import java.util.Objects;

public class UserDto {
    private long userID;
    private String name;
    private String email;
    private String phoneNumber;
    private String passwordHash;
    private Role role;

        public enum Role {
            CLIENT,
            ADMINISTRATOR
        }

    public UserDto(long userID, String name, String email, String phoneNumber, String passwordHash, Role role) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public long getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return userID == userDto.userID && Objects.equals(name, userDto.name) && Objects.equals(email, userDto.email) && Objects.equals(phoneNumber, userDto.phoneNumber) && Objects.equals(passwordHash, userDto.passwordHash) && role == userDto.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, name, email, phoneNumber, passwordHash, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", role=" + role +
                '}';
    }
}
