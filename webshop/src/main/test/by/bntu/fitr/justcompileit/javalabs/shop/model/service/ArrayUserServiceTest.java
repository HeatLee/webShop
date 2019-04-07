package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.UserArrayList;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Role;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.EnumSet;

import static org.junit.Assert.*;

public class ArrayUserServiceTest {

    private UserArrayList userArrayList;
    private User[] users;

    @Before
    public void init() {
        users = new User[]{
                new User("test1", "test1", true, EnumSet.of(Role.USER), 100, new ArrayStock(new Product[0])),
                new User("test2", "test2", true, EnumSet.of(Role.USER), 200, new ArrayStock(new Product[0])),
                new User("test3", "test3", true, EnumSet.of(Role.USER), 300, new ArrayStock(new Product[0]))};
        userArrayList = new UserArrayList(users);
    }

    @Test
    public void testSize() {
        int actual = userArrayList.count();
        int expected = users.length;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAll() {
        User[] actual = userArrayList.toArray();
        assertArrayEquals(users, actual);
    }

    @Test
    public void testContains() {
        User testUser = users[1];
        assertTrue(userArrayList.contains(testUser));
    }

    @Test
    public void testContainsNonexistentUser() {
        User testUser = new User("test4", "test4", true, EnumSet.of(Role.USER), 3000, new ArrayStock());
        assertFalse(userArrayList.contains(testUser));
    }

    @Test
    public void testAdd() {
        User testUser = new User("test4", "test4", true, EnumSet.of(Role.USER), 3000, new ArrayStock());
        User[] expected = Arrays.copyOf(users, users.length + 1);
        expected[expected.length - 1] = testUser;

        assertTrue(userArrayList.add(testUser));
        assertArrayEquals(expected, userArrayList.toArray());
    }

    @Test
    public void testAddNullUser() {
        assertFalse(userArrayList.add(null));
    }

//    @Test
//    public void testRemove() {
//        int index = 1;
//        String testUserName = users[index].getUsername();
//
//        User[] expected = new User[users.length - 1];
//        System.arraycopy(users, 0, expected, 0, index);
//        System.arraycopy(users, index + 1, expected, index, users.length - index - 1);
//        assertEquals(users[index], userArrayList.delete(testUserName));
//
//        assertArrayEquals(expected, userArrayList.getAll());
//    }
//
//    @Test
//    public void testRemoveNonexistentUser() {
//        String testUserName = new User("test4", "test4", true, EnumSet.of(Role.USER), 3000, new ArrayStock()).getUsername();
//
//        assertNull(userArrayList.remove(testUserName));
//    }
//
//    @Test
//    public void findByUsername() {
//        int index = 1;
//        User expected = users[index];
//        String testUserName = users[index].getUsername();
//
//        User actual = userArrayList.findByUsername(testUserName);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void findByNonexistentUsername() {
//        String testUserName = "nonexistentUserName";
//        User actual = userArrayList.findByUsername(testUserName);
//
//        assertNull(actual);
//    }
//
//    @Test
//    public void equals() {
//        fail();
//    }
}