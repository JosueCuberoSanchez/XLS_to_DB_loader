package ucr.ac.ecci.ci1312.phase2.core.bibliographicreference.dao;

import ucr.ac.ecci.ci1312.phase2.core.enums.ReferenceType;
import ucr.ac.ecci.ci1312.phase2.model.BibliographicReference;

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

public class JdbcBibliographicreferenceDao implements BibliographicreferenceDao {
    private Connection connection;

    public JdbcBibliographicreferenceDao() {
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
    public BibliographicReference findById(String id) {
        BibliographicReference result = null;
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM bibliographic_reference WHERE artificial_key = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                rs.first();
                result = new BibliographicReference(rs.getString("artificial_key"),
                        rs.getString("title"),
                        rs.getString("ISBN"),
                        rs.getInt("publication_year"),
                        ReferenceType.valueOf(rs.getString("reference_type")),
                        rs.getString("editorial"));
            }
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String create(BibliographicReference entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO bibliographic_reference " +
                    "VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, String.valueOf(entity.getId()));
            if(!entity.getTitle().equalsIgnoreCase("null")) {
                statement.setString(2, entity.getTitle());
            }else{
                statement.setNull(2, Types.VARCHAR);
            }
            if(!entity.getIsbn().equalsIgnoreCase("null")) {
                statement.setString(3, entity.getIsbn());
            }else{
                statement.setNull(3, Types.VARCHAR);
            }
            statement.setInt(4, entity.getPublicationYear());
            statement.setString(5, entity.getReferenceType().name());
            if(!entity.getEditorial().equalsIgnoreCase("null")) {
                statement.setString(6, entity.getEditorial());
            }else{
                statement.setNull(6, Types.VARCHAR);
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(BibliographicReference entity) {
        try {
            PreparedStatement statement =
                    this.connection.prepareStatement("UPDATE bibliographic_reference SET " +
                            "artificial_key = ?," +
                            "title = ?, " +
                            "ISBN = ?," +
                            "publication_year = ?," +
                            "reference_type = ?," +
                            "editorial = ?" +
                            "WHERE artificial_key = ?");

            statement.setString(1, entity.getTitle());
            statement.setString(3, entity.getIsbn());
            statement.setInt(4, entity.getPublicationYear());
            statement.setString(5, entity.getReferenceType().name());
            statement.setString(6, entity.getEditorial());
            statement.setString(7, String.valueOf(entity.getId()));

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void remove(BibliographicReference entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM bibliographic_reference WHERE id = ?");
            statement.setString(1, String.valueOf(entity.getId()));
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
