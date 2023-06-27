package BankOfArt.service.Impl;

import BankOfArt.dto.UserDto;
import BankOfArt.model.entity.Role;
import BankOfArt.model.entity.User;
import BankOfArt.model.repository.UserRepository;
import BankOfArt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User createUserForRegistration(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRoles(Arrays.asList(Role.ROLE_USER));
        return user;
    }

    @Override
    public boolean saveUser(User user) {
        return true;
    }

    @Override
    public boolean saveUserByAdmin(User user){
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) {
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }

    @Override
    public List<User> userGetList(Integer idMin) {
        return null;
    }

}
