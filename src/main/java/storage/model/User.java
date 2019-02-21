package storage.model;

import java.util.Objects;

public class User {
    private int age;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private UserType userType;

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(email, user.email) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(firstName, user.firstName) &&
                userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, email, lastName, firstName, userType);
    }

}
