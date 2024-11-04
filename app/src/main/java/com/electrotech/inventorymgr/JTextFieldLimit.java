package com.electrotech.inventorymgr;

import javax.swing.text.*;

public class JTextFieldLimit extends PlainDocument{
    private int limit;
    private boolean isOnlyNumber;

    JTextFieldLimit(int limit){
        super();
        this.limit = limit;
    }

    JTextFieldLimit(int limit, boolean isOnlyNumber){
        super();
        this.limit = limit;
        this.isOnlyNumber = isOnlyNumber;
    }

    public boolean isInteger(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if(isOnlyNumber){
            if (isInteger(str) && (getLength() + str.length()) <= limit){
                super.insertString(offset, str, attr);
            }
        }
        else if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
