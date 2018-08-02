package and.harim.com.cocktail;

import java.io.Serializable;

public class EpItem implements Serializable{
    private String ep_name;
    private String ep;

    @Override
    public String toString() {
        return ep_name+"     : "+ep;
    }

    public String getEp() {
        return ep;
    }

    public String getEp_name() {
        return ep_name;
    }

    public void setEp(String ep) {
        this.ep = ep;
    }

    public void setEp_name(String ep_name) {
        this.ep_name = ep_name;
    }
}
