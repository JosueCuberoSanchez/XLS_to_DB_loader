package ucr.ac.ecci.ci1312.phase2.core.procedure.dao;

import ucr.ac.ecci.ci1312.phase2.model.Procedure;

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

public interface ProcedureDao {
    /**
     * Find a procedure by the id.
     * @param id the id we are looking for.
     * @return the resulting procedure.
     */
    Procedure findById(String id);
    /**
     * Create a procedure with all the data sent from the load.
     * @param entity the procedure.
     * @return
     */
    String create(Procedure entity);
    /**
     * Update a given procedure with new data.
     * @param entity the modifying procedure.
     */
    void update(Procedure entity);
    /**
     * Remove the procedure from the database.
     * @param entity the removing procedure.
     */
    void remove(Procedure entity);
}
