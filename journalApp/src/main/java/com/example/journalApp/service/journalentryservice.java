package com.example.journalApp.service;
import com.example.journalApp.entity.journalEntry;
import org.apache.juli.logging.Log;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.journalApp.repository.journalentryrepository;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class journalentryservice {

    private static final Logger log = LoggerFactory.getLogger(journalentryservice.class);
    @Autowired
    private journalentryrepository JournalEntryRepository;

    public void saveEntry(journalEntry JournalEn){
         try {
              JournalEn.setDate(LocalDateTime.now());
              JournalEntryRepository.save(JournalEn);
          }catch (Exception e){
              log.error("Exception" , e);
          }
    }

    public List<journalEntry> getAll(){

        return JournalEntryRepository.findAll();
    }

    public Optional<journalEntry> getByindex(ObjectId Myid){
        return JournalEntryRepository.findById(Myid);
    }

    public void DeletetheIntry(ObjectId deleId){

        JournalEntryRepository.deleteById(deleId);
    }


}
