package com.example.journalApp.entity;
//package com.example.journalApp.entity;
//
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;



//@Getter   //also instace of 2 diff annotation we can use a single @data annotation which is a commbination of 4 to 5 diff annotation
//@Setter  //both getter and setter are the annotation of lombok due to this we do not ,needs any manual getters and setters
@Document(collection = "users")

@Data
public class User {

    @Id //annotation use for unic key
    private ObjectId id;

    @Indexed(unique = true) //value of UserId must be unic
  //  @NonNull
    private String userName;

    //@NonNull
    private String password;

          @DBRef
          private List<journalEntry> JournalEntry=new ArrayList<>();

}
