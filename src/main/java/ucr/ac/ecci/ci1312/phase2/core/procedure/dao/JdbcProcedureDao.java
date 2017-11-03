package ucr.ac.ecci.ci1312.phase2.core.procedure.dao;

import ucr.ac.ecci.ci1312.phase2.model.Procedure;

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

public class JdbcProcedureDao implements ProcedureDao {
    private Connection connection;

    public JdbcProcedureDao() {
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
    public Procedure findById(String id) {
        Procedure result = null;
        try{
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM exercise_procedure WHERE id = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                rs.first();
                result = new Procedure(rs.getString("id"),
                                       rs.getString("text_content"),
                                       rs.getString("image_content"),
                                       rs.getString("p_type"),
                                       rs.getString("fk_answer"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String create(Procedure entity) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO exercise_procedure " +
                                                                                "VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, entity.getId());
            if(!entity.getText().equalsIgnoreCase("null")) {
                statement.setString(2, entity.getText());
            }else{
                statement.setNull(2, Types.LONGNVARCHAR);
            }
            statement.setString(3, entity.getImage());
            statement.setString(4, entity.getType());
            statement.setString(5, entity.getFkAnswer());
            statement.setString(6,entity.getFkExcercise());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Procedure entity) {
        try {
            PreparedStatement statement =
                this.connection.prepareStatement("UPDATE exercise_procedure SET " +
                                                    "artificial_key = ?" +
                                                    "text_content = ?," +
                                                    "image_path = ?," +
                                                    "p_type = ?," +
                                                    "fk_answer = ?"+
                                                    "WHERE id = ?");

            statement.setString(1, entity.getId());
            statement.setString(2, entity.getText());
            statement.setString(3, entity.getImage());
            statement.setString(4, entity.getType());
            statement.setString(5, entity.getFkAnswer());
            //statement.setString(5, entity.getId());

            //TODO: revisar el excel

            statement.executeUpdate();

        }catch(Exception e){
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void remove(Procedure entity) {
            try{
                PreparedStatement statement = this.connection.prepareStatement("DELETE FROM exercise_procedure WHERE id= ?");
                statement.setString(1, entity.getId());
                statement.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
    }
}