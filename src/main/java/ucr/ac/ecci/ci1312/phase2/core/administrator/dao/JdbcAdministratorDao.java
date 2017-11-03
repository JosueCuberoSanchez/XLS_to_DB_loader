package ucr.ac.ecci.ci1312.phase2.core.administrator.dao;

import ucr.ac.ecci.ci1312.phase2.model.Administrator;

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

public class JdbcAdministratorDao implements AdministratorDao {
    private Connection connection;

    /**
     * Constructs a new JdbcAdministratorDao object.
     */
    public JdbcAdministratorDao() {
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
    public Administrator findById(String id) {
        Administrator result = null;
        try{

            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM administrator WHERE id = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs != null){
                rs.first();
                result = new Administrator(rs.getString("email"), rs.getString("id"),
                        rs.getString("name"), rs.getString("last_name"),
                        rs.getString("second_last_name"), rs.getDate("birth_date"),
                        rs.getString("password"), rs.getBoolean("enabled"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public String create(Administrator entity) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO administrator " +
                                                                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, entity.getEmail());
            statement.setString(2, entity.getIdCard());
            statement.setString(3, entity.getFirstName());
            statement.setString(4, entity.getFirstLastName());
            statement.setString(5, entity.getSecondLastName());
            statement.setDate(6, new Date(entity.getBirthDate().getTime()));
            statement.setString(7, entity.getPassword());
            statement.setBoolean(8, entity.isEnabled());
            statement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Administrator entity) {
        try{
            PreparedStatement statement =
                    this.connection.prepareStatement("UPDATE administrator SET " +                                                                     "email = ?, " +
                                                                    "name = ?," +
                                                                    "last_name = ?," +
                                                                    "second_last_name =?," +
                                                                    "birth_date = ?," +
                                                                    "password = ?," +
                                                                    "enabled = ?" +
                                                                    "WHERE id = ?");
            statement.setString(1, entity.getEmail());
            statement.setString(2, entity.getFirstName());
            statement.setString(3, entity.getFirstLastName());
            statement.setString(4, entity.getSecondLastName());
            statement.setDate(5, new Date(entity.getBirthDate().getTime()));
            statement.setString(6, entity.getPassword());
            statement.setBoolean(7, entity.isEnabled());
            statement.executeUpdate();
        }catch(Exception e){
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Administrator entity) {
        try{
           PreparedStatement statement = this.connection.prepareStatement("DELETE FROM administrator WHERE id = ?");
           statement.setString(1, entity.getIdCard());
           statement.executeUpdate();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
