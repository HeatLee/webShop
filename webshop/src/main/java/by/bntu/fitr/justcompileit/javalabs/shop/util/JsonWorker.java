package by.bntu.fitr.justcompileit.javalabs.shop.util;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.service.UserService;
import by.bntu.fitr.justcompileit.javalabs.shop.service.UserServiceImpl;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

@EnableAutoConfiguration
public class JsonWorker {

    private static final String FILE_NAME = "dataSource/users.json";

    public static UserService getUserList() throws Exception {
        FileReader fileReader = new FileReader(FILE_NAME);
        Scanner scanner = new Scanner(fileReader);
        StringBuilder usersString = new StringBuilder();
        while (scanner.hasNextLine()) {
            usersString.append(scanner.nextLine());
        }
        fileReader.close();
        User[] users=new Gson().fromJson(usersString.toString(), User[].class);
        UserService userService = new UserServiceImpl(users);
        return userService;
    }

    public static void update(UserService userService)throws Exception{
        FileWriter fileWriter = new FileWriter(FILE_NAME);
        fileWriter.write(new Gson().toJson(userService.findAll()));
        fileWriter.close();
    }
}
