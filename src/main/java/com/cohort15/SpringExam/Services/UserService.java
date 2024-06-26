package com.cohort15.SpringExam.Services;

import com.cohort15.SpringExam.Exceptions.ResourceNotFoundException;
import com.cohort15.SpringExam.Models.User;
import com.cohort15.SpringExam.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
      if (deletedUser.isEmpty())
          throw new ResourceNotFoundException("Can't find that user in database!");
      logger.info("Deleted User: "+deletedUser);
      userRepository.delete(deletedUser);
  }
  public User getUserByID(long userID)
  {
      User foundUser = userRepository.getReferenceById(userID);
      if (foundUser.isEmpty())
          throw new ResourceNotFoundException("Can't find that user in database!");
      else
          return foundUser;
  }
  public Iterable<User> getAllUsers()
  {
      return userRepository.findAll();
  }
  public User updateUserByID(User user, Long ID)
  {
      User currentUser = userRepository.getReferenceById(ID);

      if (currentUser.isEmpty())
          throw new ResourceNotFoundException("Can't find that user in database!");
      currentUser.setGender(user.getGender());
      currentUser.setUsername(user.getUsername());
      logger.info("Updated user "+currentUser.getId()+". New Username: " +currentUser.getUsername());
      return currentUser;
  }
}
