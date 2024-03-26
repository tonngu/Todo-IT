package se.lexicon.student.model;

import java.util.Objects;

public class AppUser {
    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {
        setUsername(username);
        setPassword(password);
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("username cannot be null or empty.");
        }
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("username cannot be null or empty.");
        }
        this.password = password;
    }


    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if (role == null) {
            throw new IllegalArgumentException("AppRole cannot be null or empty.");
        }
        this.role = role;
    }

    @Override
    public String toString(){
        return "AppUser{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppUser other = (AppUser) obj;
        return Objects.equals(username, other.username) && Objects.equals(role, other.role);
    } //I copied this solution from Google, I do not understand how this method works even after looking at the java.lang.Object class.

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        return result;
    } //I copied this solution from Google, I do not understand how this method works even after looking at the java.lang.Object class.

}
