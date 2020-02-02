package com.toleenalward.rasayel.object;

public class message {
    String messageID;
    String messagetext;

    public message(String messageID, String messagetext) {
        this.messageID = messageID;
        this.messagetext = messagetext;
    }

    public message() {
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }
}
