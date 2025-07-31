package org.example.spring_jpa.service.impl;

import org.example.spring_jpa.dto.UserDto;
import org.example.spring_jpa.model.User;
import org.example.spring_jpa.repository.UserRepository;
import org.example.spring_jpa.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Iterable<User> getAllUsers()
    {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC,"lastname"));

    }
    @Override
    public User getUserById(Integer id)
    {
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        return null;
    }

    @Override
    public User getUserByLastName(String lastname)
    {
        return userRepository.findUserByLastname(lastname);
    }

    @Override
    public User getUserByFirstName(String firstname)
    {
        return userRepository.findUserByFirstname(firstname);
    }

    @Override
    public User getUserByEmail(String email)
    {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void saveUser(User user)
    {
         userRepository.save(user);
    }

    @Override
    public void deleteUser(User user)
    {
        userRepository.delete(user);
    }

    @Override
    public void deleteUserById(int id)
    {
        userRepository.deleteById(id);
    }

    @Override
    public void registerUser(UserDto userDto)
    {
        User user = modelMapper.map(userDto, User.class);
        user.setCreatedDate(LocalDateTime.now());
        userRepository.save(user);
    }
}
