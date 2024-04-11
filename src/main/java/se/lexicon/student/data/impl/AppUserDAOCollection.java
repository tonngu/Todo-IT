package se.lexicon.student.data.impl;

import se.lexicon.student.data.AppUserDao;
import se.lexicon.student.model.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDAOCollection implements AppUserDao {

    private List<AppUser> storage = new ArrayList<>();

    @Override
    public AppUser persist(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("User Data cannot be null");
//todo: add further validations
        storage.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        for (AppUser appUser : storage) {
            if (appUser.getUsername().equals(username)) {
                return appUser;
            }
        }
        System.out.println("Username not found");
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(String username) {
        storage.remove(findByUsername(username));
    }
}
