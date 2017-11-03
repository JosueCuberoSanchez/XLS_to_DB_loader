package ucr.ac.ecci.ci1312.phase2.core.author.service;

import ucr.ac.ecci.ci1312.phase2.core.author.dao.AuthorDao;
import ucr.ac.ecci.ci1312.phase2.core.author.dao.JdbcAuthorDao;
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

public class AuthorServiceImpl implements AuthorService {

    private AuthorDao ad;

    public AuthorServiceImpl(){
        this.ad = new JdbcAuthorDao();
    }

    @Override
    public Author findById(String id) {
        return this.ad.findById(id);
    }

    @Override
    public String create(Author entity) {
        return this.ad.create(entity);
    }

    @Override
    public void update(Author entity) {
        this.ad.update(entity);
    }

    @Override
    public void remove(Author entity) {
        this.ad.remove(entity);
    }
}
