package me.hoangnd.learn.bean;

public enum Sex{
    Male("Nam"),
    Female("Nữ");
    private final String name;

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    private Sex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}