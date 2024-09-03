package com.example.journalApp.service;

import com.example.journalApp.entity.User;
import com.example.journalApp.entity.journalEntry;
import com.example.journalApp.repository.Userrepository;
import com.example.journalApp.repository.journalentryrepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class Userservice {

    private static final Logger log = LoggerFactory.getLogger(Userservice.class);
    @Autowired
    private Userrepository userrepository;

    public void saveEntry(User user){
         userrepository.save(user);
    }

    public List<User> getAll(){

        return userrepository.findAll();
    }

    public Optional<User> getByindex(ObjectId Myid){
        return userrepository.findById(Myid);
    }

    public void DeletetheIntry(ObjectId deleId){

        userrepository.deleteById(deleId);
    }

    public User findByUserName(String userName){

        return userrepository.findByUserName(userName);
    }

}
