package com.company;

public enum Owner {

     Object;
    public static final java.lang.Object COMPUTER =1 ;

    public static final Object NONE =new Object();
    public static final Owner USER = (Owner) new Object();



    public static void setOwner(Object owner) {
        Board.owner = owner;
    }

    public static Object getOwner() {

        Object owner ="";
        return owner;
    }

    public void setOwner() {
    }
}
