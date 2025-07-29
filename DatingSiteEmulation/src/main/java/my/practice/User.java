package my.practice;

import java.util.List;

public class User
{
    private final int id;
    private String name;
    private String surname;
    private Sex sex;
    private boolean isPaid = false;

    public User(Sex sex, int id) {
        this.sex = sex;
        this.id = id;
    }


    public void setSex(Sex sex){
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Sex getSex(){
        return this.sex;
    }


    public enum Sex{
        M,
        F
    }

    @Override
    public String toString() {
        return
                "ID пользователя: " + this.id + "\n" +
                "Имя: " + this.name + "\n" +
                "Фамилия: " + this.surname;
    }
}

