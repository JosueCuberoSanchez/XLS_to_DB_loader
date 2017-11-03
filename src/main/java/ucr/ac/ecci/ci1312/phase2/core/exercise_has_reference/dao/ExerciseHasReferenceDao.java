package ucr.ac.ecci.ci1312.phase2.core.exercise_has_reference.dao;

import ucr.ac.ecci.ci1312.phase2.model.ExerciseHasReference;

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

public interface ExerciseHasReferenceDao {
    ExerciseHasReference findById(String id);
    /**
     * Create an ExerciseHasReference with all the data sent from the load.
     * @param entity the ExerciseHasReference.
     * @return
     */
    String create(ExerciseHasReference entity);
    void update(ExerciseHasReference entity);
    /**
     * Remove the exerciseHasReference from the database.
     * @param entity the removing exerciseHasReference.
     */
    void remove(ExerciseHasReference entity);
}
