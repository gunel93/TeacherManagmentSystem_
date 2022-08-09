package teacherManagementSystem;

import java.security.PublicKey;

public enum  Menu_Choice {

    REGISTER(1), DELETE(2), SHOW_ALL(3), FIND(4),
    UPDATE(5), PUBLISH(6), REGISTER_TEACHER(7),
    DELETE_TEACHER(8),SHOW_ALL_TEACHERS(9),FIND_TEACHERS(10),
    UPDATE_TEACHERS(11),
    UNKNOWN(-1);

    int number;


    Menu_Choice(int value){
        this.number = value;
    }


    public static Menu_Choice getByValue(int value){
        for(int i = 0; i < Menu_Choice.values().length; i++){
            if(Menu_Choice.values()[i].number == value){
                return Menu_Choice.values()[i];

            }
        }
        return UNKNOWN;
    }
}
