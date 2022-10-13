package az.iktex.hibernatetask.models.enums;

public enum Gender {
    MALE("ERKEK"), FEMALE("KADIN");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
