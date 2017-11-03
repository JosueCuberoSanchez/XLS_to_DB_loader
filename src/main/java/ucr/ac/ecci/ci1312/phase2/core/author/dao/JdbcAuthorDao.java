package ucr.ac.ecci.ci1312.phase2.core.author.dao;

import ucr.ac.ecci.ci1312.phase2.model.Author;

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

public class JdbcAuthorDao implements  AuthorDao {
    private Connection connection;

    public JdbcAuthorDao() {
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
    public Author findById(String id) {
        Author result = null;
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM author WHERE artificial_key = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null){
                rs.first();
                result = new Author(rs.getString("artificial_key"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("second_last_name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public String create(Author entity) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO author " +
                                                                                "VALUES (?, ?, ?, ?)");
            statement.setString(1, String.valueOf(entity.getId()));
            statement.setString(2, entity.getFirstName());
            statement.setString(3, entity.getLastName());
            if(!entity.getSecondLastName().equalsIgnoreCase("null")) {
                statement.setString(4, entity.getSecondLastName());
            }else{
                statement.setNull(4, Types.VARCHAR);
            }
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Author entity) {
        try{
            PreparedStatement statement =
                    this.connection.prepareStatement("UPDATE author SET " +
                            "artificial_key = ?, " +
                            "name = ?," +
                            "last_name = ?, " +
                            "second_last_name = ?" +
                            "WHERE artificial_key = ?");

            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getSecondLastName());
            statement.setString(4, String.valueOf(entity.getId()));

            statement.executeUpdate();

        }catch (SQLException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Author entity) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM author WHERE artificial_key = ?");
            statement.setString(1, String.valueOf(entity.getId()));
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
