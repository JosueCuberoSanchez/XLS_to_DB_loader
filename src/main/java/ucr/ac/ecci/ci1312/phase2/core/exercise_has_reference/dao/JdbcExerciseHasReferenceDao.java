package ucr.ac.ecci.ci1312.phase2.core.exercise_has_reference.dao;

import ucr.ac.ecci.ci1312.phase2.model.ExerciseHasReference;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

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

public class JdbcExerciseHasReferenceDao implements ExerciseHasReferenceDao{
    private Connection connection;

    public JdbcExerciseHasReferenceDao(){
        try{
            this.connection = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "Blackfolgore666");
            this.connection = DriverManager.getConnection(
                    "jdbc:" + "mysql" + "://" +
                            "localhost" +
                            ":" + "3306" + "/xBase?autoReconnect=true&useSSL=false",
                    connectionProps);
            System.out.println("Connected to database");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ExerciseHasReference findById(String id) {
        /*ExerciseHasReference result = null;
        try {

            ResultSet rs = this.statement.executeQuery("SELECT * FROM referenced_exercise  WHERE = '" +  id + "';");
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        */
        /*Returns null given that this relation does not have a proper*/
        return null;
    }

    @Override
    public String create(ExerciseHasReference entity) {
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO referenced_exercise VALUES (?, ?);");
            ps.setString(1, entity.getFkExercise());
            ps.setString(2, entity.getFkReference());
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void update(ExerciseHasReference entity) {

    }

    @Override
    public void remove(ExerciseHasReference entity) {
        try{
            PreparedStatement ps = connection.prepareStatement("DELETE FROM referenced_exercise WHERE fk_exercise = ? AND fk_reference = ?");
            ps.setString(1, entity.getFkExercise());
            ps.setString(2, entity.getFkReference());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
