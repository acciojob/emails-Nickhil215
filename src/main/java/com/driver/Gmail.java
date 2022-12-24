package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

class info{
    Date data;
    String sender;
    String message;

    public info(Date data, String sender, String message) {
        this.data = data;
        this.sender = sender;
        this.message = message;
    }

    public Date getData() {
        return data;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }
}

public class Gmail extends Email {

    int inboxCapacity;

    //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

//    for inbox  use ArrayList data structure
   ArrayList<info> inbox=new ArrayList<>();
//    for trush use ArrayList
    ArrayList<info> trush=new ArrayList<>();


    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
    }

//    public Gmail(String emailId) {
//        super(emailId);
//    }


    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
    if(inbox.size()<inboxCapacity){
        inbox.add(new info(date,sender,message));
    }else{
        trush.add(inbox.remove(0));
    }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(info s:inbox){
            if(s.message.equals(message)){
               trush.add(new info(s.data,s.sender,s.message));
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
       info letest=inbox.get(inbox.size()-1);
       String let=letest.message;
       return let;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        info oldest=inbox.get(0);
        String old=oldest.message;
        return old;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count=0;
        int starting =inbox.indexOf(start);
        int ending=inbox.indexOf(end);

        return ending-starting;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
return  inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash

        return trush.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
      trush.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
