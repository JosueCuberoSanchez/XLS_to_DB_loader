package ucr.ac.ecci.ci1312.phase2.core.administrator.dao;

import ucr.ac.ecci.ci1312.phase2.model.Administrator;

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

public interface AdministratorDao {
    /**
     * Find an administrator by the id.
     * @param id the id we are looking for.
     * @return the resulting admnistrator.
     */
    Administrator findById(String id);
    /**
     * Create an administrator with all the data sent from the load.
     * @param entity the entity.
     * @return
     */
    String create(Administrator entity);
    /**
     * Update a given administrator with new data.
     * @param entity the modifying entity.
     */
    void update(Administrator entity);
    /**
     * Remove the administrator from the database.
     * @param entity the removing administrator.
     */
    void remove(Administrator entity);
}
