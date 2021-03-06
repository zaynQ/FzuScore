package com.example.fzuscore.DataBeans;

import android.os.Parcel;
import android.os.Parcelable;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

@SmartTable(name = "成绩排名")
public class ScoreRankStudent implements Comparable<ScoreRankStudent>, Parcelable {
    @SmartColumn(id = 1, name = "姓名")
    String name;
    int number;
    @SmartColumn(id = 2, name = "学号")
    String number_str;
    @SmartColumn(id = 3, name = "成绩")
    double score;
    @SmartColumn(id = 4, name = "排名")
    int rank;

    public ScoreRankStudent(String name, double score, int number, int rank) {
        this.name = name;
        this.score = score;
        this.number = number;
        this.number_str = "0" + number;
        this.rank = rank;
    }

    protected ScoreRankStudent(Parcel in) {
        name = in.readString();
        score = in.readDouble();
        number = in.readInt();
        rank = in.readInt();
    }

    public static final Creator<ScoreRankStudent> CREATOR = new Creator<ScoreRankStudent>() {
        @Override
        public ScoreRankStudent createFromParcel(Parcel in) {
            return new ScoreRankStudent(in);
        }

        @Override
        public ScoreRankStudent[] newArray(int size) {
            return new ScoreRankStudent[size];
        }
    };

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(ScoreRankStudent o) {
        return (int)(o.score - this.score);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(score);
        dest.writeInt(number);
        dest.writeInt(rank);
    }
}
