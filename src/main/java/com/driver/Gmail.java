package com.driver;

import java.util.*;

public class Gmail extends Email {

    int inboxCapacity;

    //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

//    for inbox  use ArrayList data structure
   ArrayList<info> Inbox=new ArrayList<>();

//    for trush use ArrayList
    ArrayList<info>  Trush=new ArrayList<>();


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
    if(Inbox.size()==getInboxCapacity()){
        Trush.add(Inbox.remove(Inbox.size()-1));

    }else{
        Inbox.add(0,new info(date,sender,message));
    }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
//       Iterator<info> list=inbox.listIterator();
//       while (list.hasNext()){
//           info dlt=list.next();
//           if(dlt.message.equals(message)){
//               trush.add(dlt);
//               list.remove();
//               break;
//           }
//       }
        for(int i=0;i<Inbox.size();i++ ){
            info obj=Inbox.get(i);
            if(obj.message.equals(message)){
                Trush.add(new info(obj.data,obj.sender,obj.message));
                Inbox.remove(obj);
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
       info letest=Inbox.get(Inbox.size()-1);
       String let=letest.message;
       return let;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        info oldest=Inbox.get(0);
        String old=oldest.message;
        return old;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count=0;

        Iterator<info> list=Inbox.listIterator();
       while(list.hasNext()){
           info between=list.next();
           if(between.data.getTime()>=start.getTime() && between.data.getTime()<=end.getTime()){
               count++;
           }

       }
      return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
return  Inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash

        return Trush.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
      Trush.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
