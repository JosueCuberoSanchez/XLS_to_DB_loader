package ucr.ac.ecci.ci1312.phase2.core.answer.service;

import ucr.ac.ecci.ci1312.phase2.model.Answer;

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

public interface AnswerService {
    /**
     * Find an answer by the id.
     * @param id the id we are looking for.
     * @return the resulting answer.
     */
    Answer findById(String id);
    /**
     * Create an answer with all the data sent from the load.
     * @param entity the answer.
     * @return
     */
    String create(Answer entity);
    /**
     * Update a given answer with new data.
     * @param entity the modifying answer.
     */
    void update(Answer entity);
    /**
     * Remove the answer from the database.
     * @param entity the removing answer.
     */
    void remove(Answer entity);
}
