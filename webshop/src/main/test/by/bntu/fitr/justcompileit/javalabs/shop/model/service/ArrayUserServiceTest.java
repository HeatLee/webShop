package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Role;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.EnumSet;

import static org.junit.Assert.*;

public class ArrayUserServiceTest {

    private ArrayUserService arrayUserService;
    private User[] users;

    @Before
    public void init() {
        users = new User[]{
                new User("test1", "test1", true, EnumSet.of(Role.USER), 100, new ArrayStock()),
                new User("test2", "test2", true, EnumSet.of(Role.USER), 200, new ArrayStock()),
                new User("test3", "test3", true, EnumSet.of(Role.USER), 300, new ArrayStock())};
        arrayUserService = new ArrayUserService(users);
    }

    @Test
    public void testSize() {
        int actual = arrayUserService.size();
        int expected = users.length;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAll() {
        User[] actual = arrayUserService.getAll();
        assertArrayEquals(users, actual);
    }

    @Test
    public void testIsExist() {
        User testUser = users[1];
        assertTrue(arrayUserService.isExist(testUser));
    }

    @Test
    public void testIsExistNonexistentUser() {
        User testUser = new User("test4", "test4", true, EnumSet.of(Role.USER), 3000, new ArrayStock());
        assertFalse(arrayUserService.isExist(testUser));
    }

    @Test
    public void testSave() {
        User testUser = new User("test4", "test4", true, EnumSet.of(Role.USER), 3000, new ArrayStock());
        User[] expected = Arrays.copyOf(users, users.length + 1);
        expected[expected.length - 1] = testUser;

        assertTrue(arrayUserService.save(testUser));
        assertArrayEquals(expected, arrayUserService.getAll());
    }

    @Test
    public void testSaveNullUser() {
        assertFalse(arrayUserService.save(null));
    }

    @Test
    public void testRemove() {
        int index = 1;
        User testUser = users[index];

        User[] expected = new User[users.length - 1];
        System.arraycopy(users, 0, expected, 0, index);
        System.arraycopy(users, index + 1, expected, index, users.length - index - 1);
        assertEquals(testUser, arrayUserService.remove(testUser));
        assertArrayEquals(expected, arrayUserService.getAll());
    }

    @Test
    public void testRemoveNonexistentUser() {
        User testUser = new User("test4", "test4", true, EnumSet.of(Role.USER), 3000, new ArrayStock());

        assertNull(arrayUserService.remove(testUser));
    }

    @Test
    public void findByUsername() {
        int index = 1;
        User expected = users[index];
        String testUserName = users[index].getUsername();

        User actual = arrayUserService.findByUsername(testUserName);

        assertEquals(expected, actual);
    }

    @Test
    public void findByNonexistentUsername() {
        String testUserName = "nonexistentUserName";
        User actual = arrayUserService.findByUsername(testUserName);

        assertNull(actual);
    }

    @Test
    public void equals() {
        fail();
    }
}