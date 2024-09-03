//package com.example.journalApp.controler;
//
//import java.util.*;
//
//import org.springframework.web.bind.annotation.*;
//import com.example.journalApp.entity.journalEntry;
//import java.util.HashMap;
//
//@RestController
//@RequestMapping("/_journal")
//public class journalentrycontrol {
//
//    private Map<Long, journalEntry> journalEntries=new HashMap<>();
//
//
//    @GetMapping
//    public List<journalEntry>getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public Boolean CreateEntry(@RequestBody journalEntry Myentry){
//        journalEntries.put(Myentry.getId(), Myentry);
//        return true;
//    }
//
//    @GetMapping("/id/{myid}")
//    public journalEntry getjournalEntryByid(@PathVariable Long myid){
//
//        return journalEntries.get(myid);
//    }
//
//    @DeleteMapping("/rmid/{rmid}")
//    public journalEntry deleteEntryByid(@PathVariable Long rmid){
//
//        journalEntry temp=journalEntries.get(rmid);
//        journalEntries.remove(rmid);
//        return temp;
//    }
//
//    @PutMapping("/id/{ptid}" )
//    public journalEntry addAtPosition(@PathVariable Long ptid,@RequestBody journalEntry data){
//
//        return journalEntries.put(ptid,data);
//    }
//
//}
