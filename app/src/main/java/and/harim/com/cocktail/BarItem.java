package and.harim.com.cocktail;


public class BarItem {

    String name;
    String address;
    double score;
    int resId;

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

    public double getScore() {
        return score;
    }

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
}