package ems.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private String sNum;
    private String sId;
    private String sPw;
    private String sName;
    private int sAge;
    private String sGender;
    private String sMajor;


    public Student(String sNum, String sId, String sPw,
                   String sName, int sAge, String sGender, String sMajor) {
        this.sNum = sNum;
        this.sId = sId;
        this.sPw = sPw;
        this.sName = sName;
        this.sAge = sAge;
        this.sGender = sGender;
        this.sMajor = sMajor;
    }

}
