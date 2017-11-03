package ucr.ac.ecci.ci1312.phase2.core.author.service;

import ucr.ac.ecci.ci1312.phase2.model.Author;

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

public interface AuthorService {
    /**
     * Find an author by the id.
     * @param id the id we are looking for.
     * @return the resulting author.
     */
    Author findById(String id);
    /**
     * Create an author with all the data sent from the load.
     * @param entity the author.
     * @return
     */
    String create(Author entity);
    /**
     * Update a given author with new data.
     * @param entity the modifying author.
     */
    void update(Author entity);
    /**
     * Remove the author from the database.
     * @param entity the removing author.
     */
    void remove(Author entity);
}
