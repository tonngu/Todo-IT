package se.lexicon.student.data;

import se.lexicon.student.model.AppUser;

import java.util.Collection;

public interface AppUserDao {
AppUser persist(AppUser appUser);
AppUser findByUsername(String username);
Collection<AppUser> findAll();
void remove(String username);

}
