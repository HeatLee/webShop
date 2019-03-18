package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import javax.persistence.*;
import java.util.Objects;

public class User extends Human {

    private static Long amount;
    private Long id;
    private String username;
    private String password;
    private boolean active;

    static {
        amount=0L;
    }
    {
        this.id=amount++;
    }

    public User() {
    }

    public User(double money, String username, String password, boolean active) {
        super(money);
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public User(User user) {
        super(user);
        this.username = user.username;
        this.password = user.password;
        this.active = user.active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return active == user.active &&
                id.equals(user.id) &&
                username.equals(user.username) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, username, password, active);
    }

    @Override
    public String toString() {
        return "User:" + " id = " + id + ", username = " + username +
                ", password = " + password +" ,money = "+super.getMoney()+ ", active = " + active + ".";
    }
}
