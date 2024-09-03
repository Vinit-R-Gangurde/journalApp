package com.example.journalApp.controler;

import com.example.journalApp.entity.journalEntry;
import jdk.jshell.Snippet;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.journalApp.service.journalentryservice;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class journalentrycontrolv2 {


    @Autowired
    private journalentryservice JournalEntryServices;


    @GetMapping
    public ResponseEntity<?> GetAll(){
        List<journalEntry> all = JournalEntryServices.getAll();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> CreateEntry(@RequestBody journalEntry Myentry){

        try {
          //  Myentry.setDate(LocalDateTime.now());
            JournalEntryServices.saveEntry(Myentry);
            return new ResponseEntity<>(Myentry,HttpStatus.CREATED);

        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<journalEntry> getjournalEntryByid(@PathVariable ObjectId myid){ //here return type is Optional ,but we will manage this using the orElse mehtod

        //return JournalEntryService.getByindex(myid).orElse(null);

        Optional<journalEntry> journalentry = JournalEntryServices.getByindex(myid);

        if(journalentry.isPresent()){
            return new ResponseEntity<>(journalentry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/rmid/{rmid}")
    public ResponseEntity<?> deleteEntryByid(@PathVariable ObjectId rmid){ //<?> this symbol is wild card pattern (it is do not compalsary to give the class name)

        JournalEntryServices.DeletetheIntry(rmid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{ptid}" )
    public ResponseEntity<?> addAtPosition(@PathVariable ObjectId ptid,@RequestBody journalEntry newEntry){

        journalEntry old=JournalEntryServices.getByindex(ptid).orElse(null);
        if(old!=null){
            old.setTital(newEntry.getTital() != null && !newEntry.getTital().equals("") ? newEntry.getTital() : old.getTital());
            old.setContain(newEntry.getContain() !=null && !newEntry.getContain().equals("") ? newEntry.getContain() : old.getContain());

            JournalEntryServices.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);

        }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
