package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;

import java.util.Set;

public class User extends Human {

    private static Long amount;
    private Long id;
    private String username;
    private String password;
    private boolean active;
    private Set<Role> roles;
    private double money;

    static {
        amount = 1L;
    }

    {
        this.id = amount++;
    }

    public User() {
    }

    public User(double money, String username, String password, boolean active, Set<Role> roles, Stock basket) {
        super(basket);
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.money = money;
    }

    public User(User user) {
        super(user);
        this.username = user.username;
        this.password = user.password;
        this.active = user.active;
        this.roles = user.roles;
        this.money = user.money;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User:" + " id = " + id + ", username = " + username +
                ", password = " + password + " ,money = " + money + ", active = " + active + ", basket = " +
                super.getBasket();
    }
}
