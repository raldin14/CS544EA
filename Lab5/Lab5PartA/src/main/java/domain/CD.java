package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cd")
public class CD extends Product{
    private String artis;

    public CD() {
    }

    public CD(String name, String description, double price, String artis) {
        super(name, description, price);
        this.artis = artis;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }
}
