package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsUserListException;

import java.io.Serializable;

public interface UserList extends Serializable {

    User get(int index) throws IndexOutOfBoundsUserListException;

    User set(int index, User newUser) throws IndexOutOfBoundsUserListException;

    boolean add(User user);

    boolean addAll(User[] users);

    int count();

    void clear();

    boolean contains(User user);

    boolean delete(User user);

    User delete(int index) throws IndexOutOfBoundsUserListException;

    int indexOf(User user);

    User[] toArray();

    User[] toArray(User[] users);
}
