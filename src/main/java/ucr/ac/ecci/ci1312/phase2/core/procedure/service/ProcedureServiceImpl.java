package ucr.ac.ecci.ci1312.phase2.core.procedure.service;

import ucr.ac.ecci.ci1312.phase2.core.procedure.dao.JdbcProcedureDao;
import ucr.ac.ecci.ci1312.phase2.core.procedure.dao.ProcedureDao;
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

public class ProcedureServiceImpl implements ProcedureService {

    private ProcedureDao pd;

    public ProcedureServiceImpl(){
        this.pd = new JdbcProcedureDao();
    }

    @Override
    public Procedure findById(String id) {
        return this.pd.findById(id);
    }

    @Override
    public String create(Procedure entity) {
        return this.pd.create(entity);
    }

    @Override
    public void update(Procedure entity) {
        this.pd.update(entity);
    }

    @Override
    public void remove(Procedure entity) {
        this.pd.remove(entity);
    }
}
