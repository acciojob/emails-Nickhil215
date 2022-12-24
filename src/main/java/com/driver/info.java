package com.driver;

import java.util.Date;

public class info {
       public Date data;
       public String sender;
       public String message;

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


