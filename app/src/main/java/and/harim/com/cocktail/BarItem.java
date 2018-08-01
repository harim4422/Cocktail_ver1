package and.harim.com.cocktail;


import java.io.Serializable;
import java.util.ArrayList;

public class BarItem implements Serializable{

    String name;
    String address;
    double score;
    int resId;
    String[] menu;
    double dnleh;
    double rudeh;

    public BarItem(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public BarItem(String name, String address, double score, int resId) {
        this.name = name;
        this.address = address;
        this.score = score;
        this.resId = resId;
    }

    public double getScore() { return score; }
    public void setScore(double score) {
        this.score = score;
    }

    public int getResId() {
        return resId;
    }
    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setMenu(String[] menu){this.menu=menu;}
    public String[] getMenu(){return menu;}

    public void setDnleh(double dnleh){this.dnleh=dnleh;}
    public double getDnleh(){return  dnleh;}

    public void setRudeh(double rudeh){this.rudeh=rudeh;}
    public double getRudeh(){return  rudeh;}
}
