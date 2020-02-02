package com.toleenalward.rasayel.model;

import io.realm.RealmObject;

public class messageRealm extends RealmObject {
    private String ID;
    private String messagename;
    private int imagefav;

    public messageRealm() {
    }

    public messageRealm(String ID, String messagename, int imagefav) {
        this.ID = ID;
        this.messagename = messagename;
        this.imagefav = imagefav;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMessagename() {
        return messagename;
    }

    public void setMessagename(String messagename) {
        this.messagename = messagename;
    }

    public int getImagefav() {
        return imagefav;
    }

    public void setImagefav(int imagefav) {
        this.imagefav = imagefav;
    }
}
