package com.raj.FinalSalesken.Model;

import org.springframework.stereotype.Component;

@Component
public class Semester {

    private int semId; // can be 1 or 2
    private int English = -1;
    private int Maths = -1;
    private int Science = -1;

    public Semester(int semId, int english, int maths, int science) {
        this.semId = semId;
        this.English = english;
        this.Maths = maths;
        this.Science = science;
    }

    public Semester() {
    }

    public Semester(int semId)
    {
        this.semId = semId;
    }


    public int getSemId() {
        return semId;
    }

    public void setSemId(int semId) {
        this.semId = semId;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getMaths() {
        return Maths;
    }

    public void setMaths(int maths) {
        Maths = maths;
    }

    public int getScience() {
        return Science;
    }

    public void setScience(int science) {
        Science = science;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semId=" + semId +
                ", English=" + English +
                ", Maths=" + Maths +
                ", Science=" + Science +
                '}';
    }
}
