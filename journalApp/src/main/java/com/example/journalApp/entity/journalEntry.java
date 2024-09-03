package com.example.journalApp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journalEntry")
//@Document
//@Getter   //also instace of 2 diff annotation we can use a single @data annotation which is a commbination of 4 to 5 diff annotation
//@Setter  //both getter and setter are the annotation of lombok due to this we do not ,needs any manual getters and setters
@Data
public class journalEntry {

    @Id //annotation use for unic key
    private ObjectId id;

   // @NonNull
    private String tital;

    private String contain;

    private LocalDateTime date;



    //using some lombok annotation it will genrate a auto code at a compile time
    //------we will auto genrate the getaters & seters using the Lombok due to this it will no moare needs
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//
//
//    public String getTital() {
//        return tital;
//    }
//
//    public void setTital(String tital) {
//        this.tital = tital;
//    }
//
//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public String getcontain() {
//        return contain;
//    }
//
//    public void setcontain(String contain) {
//        this.contain = contain;
//    }


}
