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

public class ExerciseHasReference {
    private String fkExercise;
    private String fkReference;

    /**
     * Constructs an exerciseHasReference object.
     * @param fkExercise the exercise foreign key.
     * @param fkReference the reference foreign key.
     */
    public ExerciseHasReference(String fkExercise, String fkReference){
        this.fkExercise = fkExercise;
        this.fkReference = fkReference;
    }

    /**
     * Return the exercise foreing key.
     * @return the exercise foreign key.
     */
    public String getFkExercise() {
        return fkExercise;
    }

    /**
     * Return the reference foreign key.
     * @return the reference foreign key.
     */
    public String getFkReference() {
        return fkReference;
    }
}
