package ucr.ac.ecci.ci1312.phase2.model;

import ucr.ac.ecci.ci1312.phase2.core.enums.ExerciseDifficulty;

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

public class Exercise {
    private String artificialId;
    private String statement;
    private boolean isVisible;
    private boolean isDeleted;
    private ExerciseDifficulty difficulty;
    private boolean published;

    /**
     * Constructs an exercise object.
     * @param artificialId the id.
     * @param statement the statement.
     * @param difficulty the difficulty.
     * @param isPublished the published state.
     * @param isVisible the visible state.
     * @param isDeleted the deleted state.
     */
    public Exercise(String artificialId, String statement, ExerciseDifficulty difficulty, boolean isPublished,
                    boolean isVisible, boolean isDeleted){
        this.artificialId = artificialId;
        this.statement = statement;
        this.isVisible = isVisible;
        this.isDeleted = isDeleted;
        this.difficulty = difficulty;
        this.published = published;
    }

    /**
     * Return the id of the exercise.
     * @return the id of the exercise.
     */

    public String getArtificialId() {
        return artificialId;
    }

    /**
     * Return the difficulty of the exercise.
     * @return the difficulty of the exercise.
     */
    public ExerciseDifficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Return the deleted state of the exercise.
     * @return the deleted state of the exercise.
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * Return the visible state of the exercise.
     * @return the visible state of the exercise.
     */
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * Return the statement of the exercise.
     * @return the statement of the exercise.
     */
    public String getProblem() {
        return statement;
    }

    /**
     * Return the published state of the exercise.
     * @return the published state of the exercise.
     */
    public boolean isPublished() {
        return published;
    }
}