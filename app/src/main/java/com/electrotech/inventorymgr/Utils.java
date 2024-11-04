package com.electrotech.inventorymgr;
import java.util.ArrayList;

public class Utils {

    public static String stringBuild(ArrayList<String> str){
        if (str.isEmpty()){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(str.get(0));
        for(int i = 1; i < str.size(); i++){
            stringBuilder.append("\n").append(str.get(i));
        }
        return stringBuilder.toString();
    }
}
