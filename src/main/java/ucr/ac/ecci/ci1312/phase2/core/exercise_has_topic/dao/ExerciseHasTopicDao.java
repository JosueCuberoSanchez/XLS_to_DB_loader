package ucr.ac.ecci.ci1312.phase2.core.exercise_has_topic.dao;

import ucr.ac.ecci.ci1312.phase2.model.ExerciseHasTopic;

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

public interface ExerciseHasTopicDao {
    ExerciseHasTopic findById(String id);
    /**
     * Create an exerciseHasTopic with all the data sent from the load.
     * @param entity the ExerciseHasTopic.
     * @return
     */
    String create(ExerciseHasTopic entity);
    void update(ExerciseHasTopic entity);
    /**
     * Remove the exerciseHasTopic from the database.
     * @param entity the removing exerciseHasReference.
     */
    void remove(ExerciseHasTopic entity);
}
