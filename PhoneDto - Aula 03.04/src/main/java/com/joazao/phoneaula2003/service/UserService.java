package com.joazao.phoneaula2003.service;

import com.joazao.phoneaula2003.dto.PhoneDto;
import com.joazao.phoneaula2003.dto.UserDto;
import com.joazao.phoneaula2003.model.Phone;
import com.joazao.phoneaula2003.model.User;
import com.joazao.phoneaula2003.repository.PhoneRepository;
import com.joazao.phoneaula2003.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private PhoneRepository phoneRepository;

    public UserService(UserRepository userRepository, PhoneRepository phoneRepository) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
    }




    public long createUser(UserDto createUserDto) {
        User user = new User(createUserDto.name(),createUserDto.email());
        userRepository.save(user);

        List<Phone> phones = createUserDto.phones()
                .stream()
                .map (p -> new Phone(p.number(),user))
                .toList();

        phones.forEach(p -> phoneRepository.save(p));
        return user.getId();


    }

//    public List<UserDto> getUsers(User user) {
//        List<User> users = userRepository.findAll();
//        List<Phone> phones = phoneRepository.findByUser();
//        return List<UserDto>
//    }

    public UserDto getUserById(Long id) {
    User user = userRepository.findById(id).get();
    List<PhoneDto> phones = phoneRepository.findByUser()
            .stream()
            .map(p -> new PhoneDto(p.getNumber()))
            .toList();

    return new UserDto(user.getName(), user.getEmail(), phones);
    }


}
