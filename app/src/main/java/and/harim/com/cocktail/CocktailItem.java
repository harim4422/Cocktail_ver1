package and.harim.com.cocktail;

import java.io.Serializable;

public class CocktailItem implements Serializable {

    String name;
    int wofy_id;
    int recipe_id;
    int resId;
    String video;
    String[] bar;

    public CocktailItem(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    public int getRecipe_id() {
        return recipe_id;
    }
    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public int getResId() {
        return resId;
    }
    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getWofy_id() {
        return wofy_id;
    }
    public void setWofy_id(int wofy_id) {
        this.wofy_id = wofy_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getVideo(){return video;}
    public void setVideo(String video){this.video=video;}

    public String[] getBar(){return bar;}
    public void setBar(String[] bar){this.bar=bar;}
}
