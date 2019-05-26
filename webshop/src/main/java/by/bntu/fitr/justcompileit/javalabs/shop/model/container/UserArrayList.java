package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsUserListException;

import java.util.Arrays;

public class UserArrayList implements UserList {

    private static final long serialVersionUID = 1002L;

    public static final int OFFSET = 1;
    public static final int HASH_NUM = 31;
    public static final int DEFAULT_INDEX = -1;
    public static final int BEGIN_VALUE = 0;

    public static final String EXCEPTION_DESCRIPTION = "Out of bound UserList!";

    private User[] list;
    private int count;

    public UserArrayList() {
        this.list = new User[BEGIN_VALUE];
        this.count = BEGIN_VALUE;
    }

    public UserArrayList(User[] users) {
        this.list = Arrays.copyOf(users, users.length);
        this.count = users.length;
    }

    public UserArrayList(UserArrayList userArrayList) {
        this.list = new User[userArrayList.count];
        System.arraycopy(userArrayList.list, BEGIN_VALUE, this.list, BEGIN_VALUE, userArrayList.count);
        count = userArrayList.count;
    }

    public User get(int indexUser) throws IndexOutOfBoundsUserListException {
        belongRange(indexUser);
        return list[indexUser];
    }

    public User set(int index, User newUser) throws IndexOutOfBoundsUserListException {
        belongRange(index);
        User user = list[index];
        list[index] = newUser;
        return user;
    }

    public boolean add(User user) {
        if (user != null) {
            User[] newList = new User[count + OFFSET];
            System.arraycopy(list, BEGIN_VALUE, newList, BEGIN_VALUE, count);
            newList[count] = user;
            list = new User[newList.length];
            System.arraycopy(newList, BEGIN_VALUE, list, BEGIN_VALUE, newList.length);
            count = newList.length;
            return true;
        }
        return false;
    }

    public boolean addAll(User[] users) {
        User[] newList = new User[count + users.length];
        System.arraycopy(list, BEGIN_VALUE, newList, BEGIN_VALUE, count);
        System.arraycopy(users, BEGIN_VALUE, newList, count, users.length);
        list = new User[newList.length];
        System.arraycopy(newList, BEGIN_VALUE, list, BEGIN_VALUE, newList.length);
        count = newList.length;
        return users.length != BEGIN_VALUE;
    }

    public void belongRange(int index) throws IndexOutOfBoundsUserListException {
        if (index < 0 && index > count) {
            throw new IndexOutOfBoundsUserListException(EXCEPTION_DESCRIPTION + " Index: " + index + ", Count: " + count);
        }
        if (count == BEGIN_VALUE) {
            throw new IndexOutOfBoundsUserListException(EXCEPTION_DESCRIPTION);
        }
    }

    public void clear() {
        for (int i = 0; i < count; i++) {
            list[i] = null;
        }
        count = BEGIN_VALUE;
    }

    public int count() {
        return count;
    }

    public boolean contains(User user) {
        return indexOf(user) > DEFAULT_INDEX;
    }

    public User delete(int indexUser) throws IndexOutOfBoundsUserListException {
        belongRange(indexUser);
        User userDeleted = get(indexUser);
        deleteMain(indexUser);
        return userDeleted;
    }

    public boolean delete(User user) {
        int indexUser = indexOf(user);
        if (indexUser > DEFAULT_INDEX) {
            deleteMain(indexUser);
            return true;
        }
        return false;
    }

    private void deleteMain(int indexUser) {
        User[] newList = new User[count - OFFSET];
        System.arraycopy(list, BEGIN_VALUE, newList, BEGIN_VALUE, indexUser);
        System.arraycopy(list, indexUser + OFFSET, newList, indexUser,
                count - indexUser - OFFSET);
        list = new User[newList.length];
        System.arraycopy(newList, BEGIN_VALUE, list, BEGIN_VALUE, newList.length);
        count = newList.length;
    }

    public int indexOf(User user) {
        int indexUser = DEFAULT_INDEX;
        for (int i = 0; i < count; i++) {
            if (list[i].equals(user)) {
                indexUser = i;
                break;
            }
        }
        return indexUser;
    }

    public User[] toArray() {
        return Arrays.copyOf(list, count);
    }

    public User[] toArray(User[] users) {
        if (users.length < count) {
            return Arrays.copyOf(list, count, users.getClass());
        }
        System.arraycopy(list, BEGIN_VALUE, users, BEGIN_VALUE, count);
        if (users.length > count) {
            users[count] = null;
        }
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserArrayList that = (UserArrayList) o;
        return count == that.count &&
                Arrays.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        int result = OFFSET;
        for (User user : list) {
            result = HASH_NUM * result + (user == null ? BEGIN_VALUE : user.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}

