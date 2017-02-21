package me.hoangnd.learn.bean;

public enum Marital{
    SINGLE("Độc thân"), MARRIED("Đã kết hôn"), DIVORCED("Li dị"), SEPARATE("Ly thân");

    private final String name;

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    private Marital(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
