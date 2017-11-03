package ucr.ac.ecci.ci1312.phase2.core.topic.service;

import ucr.ac.ecci.ci1312.phase2.model.Topic;

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

public interface TopicService {
    /**
     * Find a topic by the id.
     * @param id the id we are looking for.
     * @return the resulting topic.
     */
    Topic findById(String id);
    /**
     * Create an topic with all the data sent from the load.
     * @param entity the topic.
     * @return
     */
    String create(Topic entity);
    /**
     * Update a given topic with new data.
     * @param entity the modifying topic.
     */
    void update(Topic entity);
    /**
     * Remove the topic from the database.
     * @param entity the removing topic.
     */
    void remove(Topic entity);
}
