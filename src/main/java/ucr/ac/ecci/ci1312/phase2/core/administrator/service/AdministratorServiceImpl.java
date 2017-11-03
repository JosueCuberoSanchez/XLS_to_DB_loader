package ucr.ac.ecci.ci1312.phase2.core.administrator.service;

import ucr.ac.ecci.ci1312.phase2.build.Encryptor;
import ucr.ac.ecci.ci1312.phase2.core.administrator.dao.AdministratorDao;
import ucr.ac.ecci.ci1312.phase2.core.administrator.dao.JdbcAdministratorDao;
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

public class AdministratorServiceImpl implements AdministratorService {

    private AdministratorDao ad; //falta new JDBC

    public AdministratorServiceImpl(){
        this.ad = new JdbcAdministratorDao();
    }
    @Override
    public Administrator findById(String id) {
        return this.ad.findById(id);
    }

    @Override
    public String create(Administrator entity) {
        entity.setPassword(Encryptor.encryptPassword(entity.getPassword()));
        return this.ad.create(entity);
    }

    @Override
    public void update(Administrator entity) {
        this.ad.update(entity);
    }

    @Override
    public void remove(Administrator entity) {
        this.ad.remove(entity);
    }
}
