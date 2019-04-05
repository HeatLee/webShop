package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsUserListException;

public interface UserList {

    User[] toArray();

    User[] toArray(User[] users);

    int count();

    boolean contains(User user);

    User set(int index, User newUser) throws IndexOutOfBoundsUserListException;

    boolean add(User user);

    boolean addAll(User[] users);

    int indexOf(User user);

    boolean delete(User user);

    User delete(int index) throws IndexOutOfBoundsUserListException;

    void clear();

    User get(int index) throws IndexOutOfBoundsUserListException;
}
