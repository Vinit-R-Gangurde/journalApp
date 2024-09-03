package com.example.journalApp.repository;




import com.example.journalApp.entity.User;
import com.example.journalApp.entity.journalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Userrepository extends MongoRepository<User, ObjectId>{
    User findByUserName(String username);
}
