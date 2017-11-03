package ucr.ac.ecci.ci1312.phase2.model;

import ucr.ac.ecci.ci1312.phase2.core.enums.ReferenceType;

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

public class BibliographicReference {
    private String id;
    private int publicationYear;
    private String title;
    private String isbn;
    private String editorial;
    private ReferenceType referenceType;

    /**
     * Constructs a biblioraphic reference object.
     * @param id the id.
     * @param title the title, if its not own.
     * @param isbn the isbn.
     * @param publicationYear the publication year.
     * @param referenceType the reference type.
     * @param editorial the editorial
     */
    public BibliographicReference(String id, String title, String isbn, int publicationYear,
                                  ReferenceType referenceType, String editorial){
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.editorial = editorial;
        this.referenceType = referenceType;
        this.publicationYear = publicationYear;
    }
    /**
     * Return the id of the reference.
     * @return the id of the reference.
     */
    public String getId() {
        return id;
    }


    /**
     * Return the title of the reference, if its not own elaboration.
     * @return the title of the reference, if its not own elaboration.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return the isbn of the reference, if it applies to its type.
     * @return the isbn of the reference, if it applies to its type.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Return the editorial of the reference, if it applies to its type.
     * @return the editorial of the reference, if it applies to its type.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Return the reference type.
     * @return the reference type.
     */
    public ReferenceType getReferenceType() {
        return referenceType;
    }

    /**
     * Return the publication year of the reference.
     * @return the publication year of the reference.
     */
    public int getPublicationYear() {
        return publicationYear;
    }
}
