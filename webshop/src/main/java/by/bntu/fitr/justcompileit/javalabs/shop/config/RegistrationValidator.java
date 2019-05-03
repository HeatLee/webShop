package by.bntu.fitr.justcompileit.javalabs.shop.config;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class RegistrationValidator implements Validator {

    @Value("${NotEmpty}")
    private String notEmpty;

    @Value("${Failed.userForm.username}")
    private String failedUsername;

    @Value("${Duplicate.userForm.username}")
    private String dublicateUsername;

    @Value("${Failed.userForm.password}")
    private String failedPassword;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", notEmpty);
        Pattern patternUserName = Pattern.compile("[a-zA-Z0-9_]{6,20}");
        Pattern nonPatternUsername = Pattern.compile("[0-9_]{6,20}");
        if (nonPatternUsername.matcher(user.getUsername()).matches() ||
                !patternUserName.matcher(user.getUsername()).matches()) {
            errors.rejectValue("username", failedUsername);
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", dublicateUsername);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", notEmpty);
        Pattern patternPassword = Pattern.compile("[a-zA-Z0-9]{6,32}");
        if (!patternPassword.matcher(user.getPassword()).matches()) {
            errors.rejectValue("password", failedPassword);
        }

    }
}
