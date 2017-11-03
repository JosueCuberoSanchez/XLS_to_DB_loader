package ucr.ac.ecci.ci1312.phase2.core.reference_has_author.service;

import ucr.ac.ecci.ci1312.phase2.core.reference_has_author.dao.JdbcReferenceHasAuthorDao;
import ucr.ac.ecci.ci1312.phase2.core.reference_has_author.dao.ReferenceHasAuthorDao;
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

public class ReferenceHasAuthorServiceImpl implements ReferenceHasAuthorService {

    private ReferenceHasAuthorDao rhad;

    public ReferenceHasAuthorServiceImpl(){
        this.rhad = new JdbcReferenceHasAuthorDao();
    }

    @Override
    public ReferenceHasAuthor findById(String id) {
        return this.rhad.findById(id);
    }

    @Override
    public String create(ReferenceHasAuthor entity) {
        return this.rhad.create(entity);
    }

    @Override
    public void update(ReferenceHasAuthor entity) {
        this.rhad.update(entity);
    }

    @Override
    public void remove(ReferenceHasAuthor entity) {
        this.rhad.remove(entity);
    }
}
