package ucr.ac.ecci.ci1312.phase2.model;

/**
 * Universidad de Costa Rica.
 * Facultad de Ingeniería.
 * Escuela de Ciencias de la Computación e Informática.
 * Proyecto: Bases de Datos 1.
 * Profesor Rodrigo Bartels.
 * Autores:
 * Cubero Sánchez Josué B42190
 * Durán Gregory Ian B42322
 * Garita Centeno Alonso B42791
 * Primer Ciclo 2017
 */

public class Procedure {
    private String id;
    private String fkAnswer;
    private String text;
    private String image;
    private String type;
    private String fkExercise;

    /**
     * Constructs a procedure object.
     * @param id the id.
     * @param fkAnswer the foreign key of the answer.
     * @param text the text of the procedure, if its text type.
     * @param image the image of the procedure, if its image type.
     */
    public Procedure(String id,String text,String image,String type, String fkAnswer) {
        this.id = id;
        this.fkAnswer = fkAnswer;
        this.type = type;
        this.text = text;
        this.image = image;
    }

    /**
     * Return the type of the procedure.
     * @return the type of the procedure.
     */
    public String getType() {
        return type;
    }

    /**
     * Return the id of the procedure.
     * @return the id of the procedure.
     */
    public String getId() {
        return id;
    }

    /**
     * Return the text, if the procedure is text type.
     * @return the text, if the procedure is text type.
     */
    public String getText() {
        return text;
    }

    /**
     * Return the answer foreign key.
     * @return the answer foreign key.
     */
    public String getFkAnswer() {
        return fkAnswer;
    }

    /**
     * Return the exercise foreign key.
     * @return the exercise foreign key.
     */
    public String getFkExcercise() {
        return fkExercise;
    }

    /**
     * Return the image of the procedure, if the procedure is image type.
     * @return the image of the procedure, if the procedure is image type.
     */
    public String getImage() {
        return image;
    }

}
