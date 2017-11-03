package ucr.ac.ecci.ci1312.phase2.core.bibliographicreference.dao;

import ucr.ac.ecci.ci1312.phase2.model.BibliographicReference;

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

public interface BibliographicreferenceDao {
    /**
     * Find bibliographic reference by the id.
     * @param id the id we are looking for.
     * @return the resulting bibliographic reference.
     */
    BibliographicReference findById(String id);
    /**
     * Create a bibliographic reference with all the data sent from the load.
     * @param entity the bibliographic reference.
     * @return
     */
    String create(BibliographicReference entity);
    /**
     * Update a given bibliographic reference with new data.
     * @param entity the modifying bibliographic reference.
     */
    void update(BibliographicReference entity);
    /**
     * Remove the bibliographic reference from the database.
     * @param entity the removing bibliographic reference.
     */
    void remove(BibliographicReference entity);
}
