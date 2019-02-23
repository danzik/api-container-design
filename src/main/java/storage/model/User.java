package storage.model;

import storage.model.files.File;
import storage.model.files.Folder;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User {
    private int age;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private boolean disabled;
    private UserType userType;
    private List<Folder> folders;
    private Set<File> sharedFiles;
    private String profilePhotoUrl;

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

    public boolean isDisabled() {
        return disabled;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
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
