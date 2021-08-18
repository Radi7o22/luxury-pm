package softuni.project.onlinestore.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.project.onlinestore.db.model.user.SignUpResponse;
import softuni.project.onlinestore.db.model.user.User;
import softuni.project.onlinestore.db.repository.UserRepository;
import softuni.project.onlinestore.dto.UserDto;

import static java.util.Objects.nonNull;
import static softuni.project.onlinestore.security.SignConstants.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public SignUpResponse registerCheckUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        String message;
        int statusCode;
        boolean usernameTaken = false;
        boolean emailTaken = false;

        if (nonNull(userRepository.findByUsername(user.getUsername()))) {
            usernameTaken = true;
        }
        if (nonNull(userRepository.findByEmail(user.getEmail()))) {
            emailTaken = true;
        }

        if (usernameTaken && emailTaken) {
            message = TAKEN_USERNAME_EMAIL;
            statusCode = CONFLICT;
        } else if (usernameTaken) {
            message = TAKEN_USERNAME;
            statusCode = CONFLICT;
        } else if (emailTaken) {
            message = TAKEN_EMAIL;
            statusCode = CONFLICT;
        } else {
            message = SUCCESSFUL_REGISTRATION;
            statusCode = OK;
        }

        if (message.equals(SUCCESSFUL_REGISTRATION)) {
            userRepository.save(user);
        }

        return new SignUpResponse(statusCode, message);
    }

    public UserDto updateUserProfile(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername());
        if (nonNull(user)) {
            user.setAddress(userDto.getAddress());
            user.setPhone(userDto.getPhone());
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            userRepository.save(user);
        }
        return userDto;
    }

    public UserDto getUserProfile(String username) {
        User user = userRepository.findByUsername(username);
        if (nonNull(user)) {
            return modelMapper.map(user, UserDto.class);
        }
        return null;
    }

}
