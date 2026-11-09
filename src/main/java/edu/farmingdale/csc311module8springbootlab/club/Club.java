package edu.farmingdale.csc311module8springbootlab.club;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;
import org.hibernate.annotations.NotFound;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 60)
    @NotBlank(message= "You must have a name!")
    private String name;

    @Size(max = 30)
    @NotBlank(message= "You must have a category!")
    private String category;

    @Size(max = 20)
    @NotBlank(message= "You must have a meeting day!")
    private String meetingDay;

    @Size(max = 40)
    private String room;


    public Club(){

    }

    public Club(String name, String category, String meetingDay, String room){
        this.name=name;
        this.category=category;
        this.meetingDay=meetingDay;
        this.room=room;
    }

    public Long getId() {
        return id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMeetingDay() {
        return meetingDay;
    }

    public void setMeetingDay(String meetingDay) {
        this.meetingDay = meetingDay;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
