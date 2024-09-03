package com.example.journalApp.controler;

import com.example.journalApp.entity.User;
import com.example.journalApp.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Usercontrol {


    @Autowired
    private Userservice userservice;

    @GetMapping
    public List<User> getAll(){
        return userservice.getAll();
    }

    @PostMapping
    public void CreateNewEntry(@RequestBody User myentry){

        userservice.saveEntry(myentry);

    }

    @PutMapping("/username/{username}")
    public ResponseEntity<?> updateuser(@RequestBody User user,@PathVariable String username){
        User Userindb = userservice.findByUserName(username);
        if(Userindb != null){
            Userindb.setUserName(user.getUserName());
            Userindb.setPassword(user.getPassword());
            userservice.saveEntry(Userindb); //save entry in same id
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/Sid/{id}")
//    public User getEntryByid(@PathVariable ObjectId id){
//
//        return userservice.getByindex(id).orElse(null);
//    }

//    @DeleteMapping("/reid/{id}")
//    public ResponseEntity<?> DeleteEntry(@PathVariable ObjectId id){
//        userservice.DeletetheIntry(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }



}
