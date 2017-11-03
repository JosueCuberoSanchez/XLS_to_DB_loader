package ucr.ac.ecci.ci1312.phase2.core.exercise.dao;

import ucr.ac.ecci.ci1312.phase2.core.enums.ExerciseDifficulty;
import ucr.ac.ecci.ci1312.phase2.model.Exercise;

import java.sql.*;
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

public class JdbcExerciseDao implements ExerciseDao {
    private Connection connection;

    public JdbcExerciseDao(){
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
    public Exercise findById(String id) {
        Exercise result = null;
        try{
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM exercise WHERE artificial_key = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs != null){
                rs.first();
                result = new Exercise(rs.getString("artificial_key"), rs.getString("problem"),
                        ExerciseDifficulty.valueOf(rs.getString("difficulty")), rs.getBoolean("is_published"),
                        rs.getBoolean("is_visible"), rs.getBoolean("is_deleted"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String create(Exercise entity) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO exercise " +
                                                                                "VALUES  (?, ?, ?, ?, ?, ?)");

            statement.setString(1, entity.getArtificialId());
            statement.setString(2, entity.getProblem());
            statement.setString(3, entity.getDifficulty().name());
            statement.setBoolean(4, entity.isPublished());
            statement.setBoolean(5, entity.isVisible());
            statement.setBoolean(6, entity.isDeleted());

            statement.executeUpdate();


        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Exercise entity) {
        try{
            PreparedStatement statement =
                    this.connection.prepareStatement("UPDATE exercise SET " +
                                                        "artificial_key = ?, " +
                                                        "problem = ?, " +
                                                        "difficulty = ?, " +
                                                        "is_published = ?, " +
                                                        "is_visible = ?, " +
                                                        "is_deleted = ?" +
                                                        "WHERE artificial_key = ?");

            statement.setString(1, entity.getProblem());
            statement.setString(2, entity.getDifficulty().name());
            statement.setBoolean(3, entity.isPublished());
            statement.setBoolean(4, entity.isVisible());
            statement.setBoolean(5, entity.isDeleted());
            statement.setString(6, String.valueOf(entity.getArtificialId()));
        }catch (SQLException e){
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Exercise entity) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM exercise WHERE artificial_key = ?");
            statement.setString(1, String.valueOf(entity.getArtificialId()));
            statement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
