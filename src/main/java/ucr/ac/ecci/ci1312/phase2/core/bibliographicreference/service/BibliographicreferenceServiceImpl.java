package ucr.ac.ecci.ci1312.phase2.core.bibliographicreference.service;

import ucr.ac.ecci.ci1312.phase2.core.bibliographicreference.dao.BibliographicreferenceDao;
import ucr.ac.ecci.ci1312.phase2.core.bibliographicreference.dao.JdbcBibliographicreferenceDao;
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

public class BibliographicreferenceServiceImpl implements BibliographicreferenceService {

    private BibliographicreferenceDao brd;

    public BibliographicreferenceServiceImpl(){
        this.brd = new JdbcBibliographicreferenceDao();
    }

    @Override
    public BibliographicReference findById(String id) {
        return this.brd.findById(id);
    }

    @Override
    public String create(BibliographicReference entity) {
        return this.brd.create(entity);
    }

    @Override
    public void update(BibliographicReference entity) {
        this.brd.update(entity);
    }

    @Override
    public void remove(BibliographicReference entity) {
        this.brd.remove(entity);
    }
}
