package ucr.ac.ecci.ci1312.phase2.model;

/**
 * Created by Josue Cubero on 22/05/2017.
 */
public class ReferenceHasAuthor {
    private String fkReference;
    private String fkAuthor;

    public ReferenceHasAuthor(String fkReference, String fkAuthor){
        this.fkAuthor = fkAuthor;
        this.fkReference = fkReference;
    }

    public String getFkReference() {
        return fkReference;
    }

    public String getFkAuthor() {
        return fkAuthor;
    }
}
