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

public class ExerciseHasTopic {
    private String fkExercise;
    private String fkTopic;

    /**
     * Constructs an exerciseHasTopic object.
     * @param fkExercise the exercise foreign key.
     * @param fkTopic the topic foreign key.
     */
    public ExerciseHasTopic(String fkExercise, String fkTopic){
        this.fkExercise = fkExercise;
        this.fkTopic = fkTopic;
    }

    /**
     * Return the exercise foreign key.
     * @return the exercise foreign key.
     */
    public String getFkExercise() {
        return fkExercise;
    }

    /**
     * Return the topic foreign key.
     * @return the topic foreign key.
     */
    public String getFkTopic() {
        return fkTopic;
    }
}
