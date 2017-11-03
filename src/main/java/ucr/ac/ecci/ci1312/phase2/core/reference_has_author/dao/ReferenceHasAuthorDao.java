package ucr.ac.ecci.ci1312.phase2.core.reference_has_author.dao;


import ucr.ac.ecci.ci1312.phase2.model.ReferenceHasAuthor;

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

public interface ReferenceHasAuthorDao {
    ReferenceHasAuthor findById(String id);
    /**
     * Create a referenceHasAuthor with all the data sent from the load.
     * @param entity the ReferenceHasAuthor.
     * @return
     */
    String create(ReferenceHasAuthor entity);
    void update(ReferenceHasAuthor entity);
    /**
     * Remove the referenceHasAuthor from the database.
     * @param entity the removing referenceHasAuthor.
     */
    void remove(ReferenceHasAuthor entity);
}
