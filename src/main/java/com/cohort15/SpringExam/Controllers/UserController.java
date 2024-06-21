package com.cohort15.SpringExam.Controllers;

import com.cohort15.SpringExam.Models.User;
import com.cohort15.SpringExam.Response.UserResponse;
import org.hibernate.sql.Delete;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class UserController
{
    @Autowired UserResponse userResponse;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers()
    {
        return new ResponseEntity<>(userResponse.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<?> createUser(String userName)
    {
        return new ResponseEntity<>(userResponse.makeNewUser(userName), HttpStatus.CREATED);
    }
    @GetMapping("/users/{userID}")
    public ResponseEntity<?> getUserByID(@PathVariable long userID)
    {
        return new ResponseEntity<>(userResponse.getUserByID(userID), HttpStatus.FOUND);
    }
    @DeleteMapping("/users/{userID}")
    public ResponseEntity<?> deleteUserByID(@PathVariable long userID)
    {
        return new ResponseEntity<>(userResponse.deleteUserByID(userID), HttpStatus.ACCEPTED);
    }
    @PutMapping("/users/{userID}")
    public ResponseEntity<?> updateUserByID(@PathVariable long userID, @RequestBody User user) {
        return new ResponseEntity<>(UserResponse.ReplaceUserAtID(userID), HttpStatus.ACCEPTED);
    }
    @GetMapping("/users/search/")
    public ResponseEntity<?> searchByName(@RequestParam(name = "usernamesearch") String searchName)
    {
        return new ResponseEntity<>(UserResponse.userNameSearch(searchName, HttpStatus.ACCEPTED));
    }

}
