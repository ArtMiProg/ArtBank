package BankOfArt.service;

import BankOfArt.dto.UserDto;
import BankOfArt.model.entity.Role;
import BankOfArt.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Arrays;
import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAll();

    User getById(Integer id);

    User createUserForRegistration(UserDto userDto);

    boolean saveUser(User user);

    boolean saveUserByAdmin(User user);

    boolean deleteUser(Integer id);

    List<User> userGetList(Integer idMin);
}
