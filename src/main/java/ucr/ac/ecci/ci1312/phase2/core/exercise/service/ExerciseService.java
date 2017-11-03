package ucr.ac.ecci.ci1312.phase2.core.exercise.service;

import ucr.ac.ecci.ci1312.phase2.model.Exercise;

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

public interface ExerciseService {
    /**
     * Find an exercise by the id.
     * @param id the id we are looking for.
     * @return the resulting exercise.
     */
    Exercise findById(String id);
    /**
     * Create an exercise with all the data sent from the load.
     * @param entity the exercise.
     * @return
     */
    String create(Exercise entity);
    /**
     * Update a given exercise with new data.
     * @param entity the modifying exercise.
     */
    void update(Exercise entity);
    /**
     * Remove the exercise from the database.
     * @param entity the removing exercise.
     */
    void remove(Exercise entity);
}
