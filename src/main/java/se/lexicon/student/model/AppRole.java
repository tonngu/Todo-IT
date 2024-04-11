package se.lexicon.student.model;

public enum AppRole {
    ROLE_APP_USER(0, "User"),
    ROLE_APP_ADMIN(1, "Admin");

    private final int code;
    private final String name;

    AppRole(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode()    {
        return code;
    }

    public String getName() {
        return name;
    }


}
