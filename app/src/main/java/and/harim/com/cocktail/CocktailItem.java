package and.harim.com.cocktail;

public class CocktailItem {

    String name;
    String wofy;
    String method;
    int resId;

    public CocktailItem(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }
    public CocktailItem(String name,String wofy,String method, int resId) {
        this.name = name;
        this.wofy=wofy;
        this.method=method;
        this.resId = resId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getWofy() {
        return wofy;
    }

    public void setWofy(String wofy) {
        this.wofy = wofy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
