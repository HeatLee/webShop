package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;

import java.util.Objects;
import java.util.Set;

public class User extends Human {

    private static Long amount;

    static {
        amount = 1L;
    }

    private double money;
    private boolean active;

    private Long id;

    private String username;
    private String password;

    private Set<Role> roles;

    {
        this.id = amount++;
    }

    public User() {
    }

    public User(String username, String password, boolean active, Set<Role> roles, double money, Stock stock) {
        super(stock);
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.money = money;
    }

    public User(User user) {
        super(user);
        username = user.username;
        password = user.password;
        active = user.active;
        roles = user.roles;
        money = user.money;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Double.compare(user.money, money) == 0 &&
                active == user.active &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), money, active, id, username, password, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "money=" + money +
                ", active=" + active +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                "} " + super.toString();
    }
}
