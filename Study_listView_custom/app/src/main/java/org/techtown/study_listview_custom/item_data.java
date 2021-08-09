package org.techtown.study_listview_custom;

import android.graphics.drawable.Drawable;

public class item_data {

    private int face;
    private String name;
    private String number;

    public void set_face(int icon){
        face = icon;
    };

    public void set_name(String nm){
        name = nm;
    };

    public void set_number(String num){
        number = num;
    };

    public int get_face(){
        return this.face;
    }

    public String get_name(){
        return this.name;
    };

    public String get_number(){
        return this.number;
    };
}
