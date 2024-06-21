package com.cohort15.SpringExam.Services;

import com.cohort15.SpringExam.Exceptions.UserNotFoundException;
import com.cohort15.SpringExam.Models.User;
import com.cohort15.SpringExam.Repositories.UserRepository;
import com.cohort15.SpringExam.Response.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
  @Autowired
  UserRepository userRepository;
  public User createUser(String userName)
  {
      User createdUser = userRepository.save(new User(userName));
      logger.info("Created user: "+userName);
      return createdUser;
  }
  public void deleteUserById(long userID)
  {
      User deletedUser = userRepository.getReferenceById(userID);
      if (deletedUser == null)
          throw new UserNotFoundException("Can't find that user in database!");
      logger.info("Deleted User: "+deletedUser);
      userRepository.delete(deletedUser);
  }
  public User getUserByID(long userID)
  {
      User foundUser = userRepository.getReferenceById(userID);
      if (foundUser==null)
          throw new UserNotFoundException("Can't find that user in database!");
      else
          return foundUser;
  }
  public Iterable<User> getAllUsers()
  {
      return userRepository.findAll();
  }
}
