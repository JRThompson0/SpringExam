package com.cohort15.SpringExam.Response;

import com.cohort15.SpringExam.Exceptions.ResourceNotFoundException;
import com.cohort15.SpringExam.Models.User;
import com.cohort15.SpringExam.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserResponse
{
    @Autowired
    UserService userService;

    public ResponseEntity<?> getAllUsers()
    {
        try{
            Body body = new Body();
            body.setData(userService.getAllUsers());
            body.setCode(HttpStatus.CREATED.value());
            body.setMessage("Users retrieved");
            return ResponseEntity.ok(body);
        }catch(Exception exception){
            Body body = new Body();
            body.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            body.setMessage("error retrieving users");

            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<?> deleteUserByID(long userID) {
        try {
            userService.deleteUserById(userID);
            Body body = new Body();
            body.setCode(HttpStatus.NO_CONTENT.value());
            body.setMessage("User deleted successfully");
            return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
        } catch (ResourceNotFoundException e) {
            Body body = new Body();
            body.setCode(HttpStatus.NOT_FOUND.value());
            body.setMessage(e.getMessage());
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> getUserByID(Long userID)
    {
        try {
            User user = userService.getUserByID(userID);
            Body body = new Body();
            body.setData(user);
            body.setCode(HttpStatus.OK.value());
            body.setMessage("Customer retrieval success");
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (ResourceNotFoundException u) {
            Body body = new Body();
            body.setCode(HttpStatus.NOT_FOUND.value());
            body.setMessage("Customer not found");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            Body body = new Body();
            body.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            body.setMessage("Error fetching User");
            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<?> makeNewUser(String userName)
    {
        try{
            User createdUser = userService.createUser(userName);
            Body body = new Body();
            body.setData(createdUser);
            body.setCode(HttpStatus.CREATED.value());
            body.setMessage("User created");
            return ResponseEntity.ok(body);
        }
        catch(Exception exception){
            Body body = new Body();
                    body.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                    body.setMessage("error creating user");
                    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


