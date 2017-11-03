package ucr.ac.ecci.ci1312.phase2.build;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import ucr.ac.ecci.ci1312.phase2.core.administrator.service.AdministratorService;
import ucr.ac.ecci.ci1312.phase2.core.administrator.service.AdministratorServiceImpl;
import ucr.ac.ecci.ci1312.phase2.core.answer.service.AnswerService;
import ucr.ac.ecci.ci1312.phase2.core.answer.service.AnswerServiceImpl;
import ucr.ac.ecci.ci1312.phase2.core.author.service.AuthorService;
import ucr.ac.ecci.ci1312.phase2.core.author.service.AuthorServiceImpl;
import ucr.ac.ecci.ci1312.phase2.core.bibliographicreference.service.BibliographicreferenceService;
import ucr.ac.ecci.ci1312.phase2.core.bibliographicreference.service.BibliographicreferenceServiceImpl;
import ucr.ac.ecci.ci1312.phase2.core.enums.AnswerType;
import ucr.ac.ecci.ci1312.phase2.core.enums.ExerciseDifficulty;
import ucr.ac.ecci.ci1312.phase2.core.enums.ReferenceType;
import ucr.ac.ecci.ci1312.phase2.core.exercise.service.ExerciseService;
import ucr.ac.ecci.ci1312.phase2.core.exercise.service.ExerciseServiceImpl;
import ucr.ac.ecci.ci1312.phase2.core.exercise_has_reference.service.ExerciseHasReferenceService;
import ucr.ac.ecci.ci1312.phase2.core.exercise_has_reference.service.ExerciseHasReferenceServiceImpl;
import ucr.ac.ecci.ci1312.phase2.core.exercise_has_topic.service.ExerciseHasTopicService;
import ucr.ac.ecci.ci1312.phase2.core.exercise_has_topic.service.ExerciseHasTopicServiceImpl;
import ucr.ac.ecci.ci1312.phase2.core.procedure.service.ProcedureService;
import ucr.ac.ecci.ci1312.phase2.core.procedure.service.ProcedureServiceImpl;
import ucr.ac.ecci.ci1312.phase2.core.reference_has_author.service.ReferenceHasAuthorService;
import ucr.ac.ecci.ci1312.phase2.core.reference_has_author.service.ReferenceHasAuthorServiceImpl;
import ucr.ac.ecci.ci1312.phase2.core.student.service.StudentService;
import ucr.ac.ecci.ci1312.phase2.core.student.service.StudentServiceImpl;
import ucr.ac.ecci.ci1312.phase2.core.topic.service.TopicService;
import ucr.ac.ecci.ci1312.phase2.core.topic.service.TopicServiceImpl;
import ucr.ac.ecci.ci1312.phase2.model.*;

import java.io.FileInputStream;
import java.io.IOException;

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

public class DataLoader {

    private AdministratorService adminService;
    private AnswerService ansService;
    private AuthorService authService;
    private BibliographicreferenceService bibService;
    private ExerciseService exService;
    private ExerciseHasReferenceService exHasRefService;
    private ExerciseHasTopicService exHasTopicService;
    private ProcedureService procedService;
    private ReferenceHasAuthorService refHasAuthService;
    private StudentService studentService;
    private TopicService topicService;

    public DataLoader(){
        this.adminService = new AdministratorServiceImpl();
        this.ansService = new AnswerServiceImpl();
        this.authService = new AuthorServiceImpl();
        this.bibService = new BibliographicreferenceServiceImpl();
        this.exService = new ExerciseServiceImpl();
        this.exHasRefService = new ExerciseHasReferenceServiceImpl();
        this.exHasTopicService = new ExerciseHasTopicServiceImpl();
        this.procedService = new ProcedureServiceImpl();
        this.refHasAuthService = new ReferenceHasAuthorServiceImpl();
        this.studentService = new StudentServiceImpl();
        this.topicService = new TopicServiceImpl();
    }
    /**
     * Loads the administrator from the spreadsheet.
     *
     * @param sheet the admnistrator sheet from the spreadsheet.
     */
    public void loadAdmin(HSSFSheet sheet) {
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        Administrator admin;
        while (row != null) {
            if(!row.getCell(0).getStringCellValue().equals("")) {
                admin = new Administrator(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),
                        row.getCell(3).getStringCellValue(),
                        row.getCell(4).getStringCellValue(),
                        row.getCell(5).getDateCellValue(),
                        row.getCell(6).getStringCellValue(),
                        row.getCell(7).getNumericCellValue() != 0);
                this.adminService.create(admin);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Load the answers from the spreadsheet.
     *
     * @param sheet the answers sheet from the spreadsheet.
     */
    public void loadAnswer(HSSFSheet sheet) {
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        Answer answer;
        Double number;
        while (row != null) {
            if(row.getCell(4).getCellTypeEnum().equals(CellType.STRING)){
                number = 0.0;
            } else {
                number = row.getCell(4).getNumericCellValue();
            }
            if(!row.getCell(0).getStringCellValue().equals("")) {
                answer = new Answer(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getNumericCellValue() != 0,
                        row.getCell(2).getNumericCellValue() != 0,
                        row.getCell(3).getNumericCellValue() != 0,
                        number,
                        row.getCell(5).getStringCellValue(),
                        row.getCell(6).getStringCellValue(),
                        row.getCell(7).getStringCellValue(),
                        row.getCell(8).getStringCellValue(),
                        row.getCell(9).getStringCellValue(),
                        row.getCell(10).getStringCellValue(),
                        row.getCell(11).getNumericCellValue() != 0,
                        Enum.valueOf(AnswerType.class, row.getCell(12).getStringCellValue().toUpperCase()));
                this.ansService.create(answer);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Loads the authors from the spreadsheet.
     *
     * @param sheet the authors sheet from the spreadsheet.
     */
    public void loadAuthor(HSSFSheet sheet) {
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        Author author;
        while (row != null) {
            if(!row.getCell(0).getStringCellValue().equals("")) {
                author = new Author(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),
                        row.getCell(3).getStringCellValue());
                this.authService.create(author);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Loads the bibliographic references from the spreadsheet.
     *
     * @param sheet the bibliographic reference sheet from the spreadsheet.
     */
    public void loadBibReference(HSSFSheet sheet) {
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        BibliographicReference bibref;
        while (row != null) {
            if(!row.getCell(0).getStringCellValue().equals("")) {
                bibref = new BibliographicReference(
                        row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),
                        (int) row.getCell(3).getNumericCellValue(),
                        ReferenceType.valueOf(row.getCell(4).getStringCellValue().toUpperCase()),
                        row.getCell(5).getStringCellValue() //(ReferenceType)row.getCell(5).getStringCellValue(),
                );
                this.bibService.create(bibref);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Loads the exercises from the spreadsheet.
     *
     * @param sheet The exercise sheet from the spreadsheet.
     */
    public void loadExercise(HSSFSheet sheet) {
        //int artificial_Id, String statement, Difficulty difficulty,boolean published,boolean visible, boolean deleted
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        Exercise exercise;
        while (row != null) {
            if(!row.getCell(0).getStringCellValue().equals("")) {
                exercise = new Exercise(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        Enum.valueOf(ExerciseDifficulty.class, row.getCell(2).getStringCellValue().toUpperCase()),
                        row.getCell(3).getNumericCellValue() != 0,
                        row.getCell(4).getNumericCellValue() != 0,
                        row.getCell(5).getNumericCellValue() != 0);
                this.exService.create(exercise);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Loads the exerciseHasReference from he spreadsheet.
     *
     * @param sheet the exerciseHasReference sheet.
     */
    public void loadExerciseHasRef(HSSFSheet sheet) {
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        ExerciseHasReference ehr;
        while (row != null) {
            if(!row.getCell(0).getStringCellValue().equals("")) {
                ehr = new ExerciseHasReference(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue());
                this.exHasRefService.create(ehr);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Loads the exerciseHasTopic from the spreadsheet.
     *
     * @param sheet The exerciseHasTopic sheet.
     */
    public void loadExerciseHasTopic(HSSFSheet sheet) {
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        ExerciseHasTopic eht;
        while (row != null) {
            if(!row.getCell(0).getStringCellValue().equals("")) {
                eht = new ExerciseHasTopic(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue());
                this.exHasTopicService.create(eht);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Loads the procedures from the spreadsheet.
     *
     * @param sheet the procedure sheet.
     */
    public void loadProcedure(HSSFSheet sheet) {
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        Procedure procedure;
        while (row != null) {
            if(!row.getCell(0).getStringCellValue().equals("")) {
                procedure = new Procedure(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),
                        row.getCell(3).getStringCellValue(),
                        row.getCell(4).getStringCellValue());
                this.procedService.create(procedure);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Loads the referenceHasAuthor from the spreadsheet.
     *
     * @param sheet the referenceHasAuthor sheet.
     */
    public void loadReferenceHasAuthor(HSSFSheet sheet) {
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        ReferenceHasAuthor rha;
        while (row != null) {
            if(!row.getCell(0).getStringCellValue().equals("")) {
                rha = new ReferenceHasAuthor(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue());
                this.refHasAuthService.create(rha);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Loads the students from the spreadsheet.
     *
     * @param sheet the student sheet.
     */
    public void loadStudent(HSSFSheet sheet) {
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        Student student;
        while (row != null) {
            if(!row.getCell(0).getStringCellValue().equals("")) {
                student = new Student(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),
                        row.getCell(3).getStringCellValue(),
                        row.getCell(4).getStringCellValue(),
                        row.getCell(5).getDateCellValue(),
                        row.getCell(6).getStringCellValue(),
                        row.getCell(7).getNumericCellValue() != 0);
                this.studentService.create(student);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Loads the topics from the spreadsheet.
     *
     * @param sheet the topic sheet.
     */
    public void loadTopic(HSSFSheet sheet) {
        int index1 = 1;
        HSSFRow row = sheet.getRow(index1);
        Topic topic;
        if(!row.getCell(0).getStringCellValue().equals("")) {
            topic = new Topic(row.getCell(0).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    null);
            this.topicService.create(topic);
        }
        index1++;
        row = sheet.getRow(index1);
        while (row != null) {
            if(!row.getCell(0).getStringCellValue().equals("")) {
                topic = new Topic(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue());
                this.topicService.create(topic);
            }
            index1++;
            row = sheet.getRow(index1);
            if(row != null && row.getCell(0).getStringCellValue().equals(""))
                row = null;
        }
    }

    /**
     * Loads all data from the excel file (.xls) to the database.
     */
    public void loadWorkbook() {
        FileInputStream fileIn;
        try {
            //String projectPath = new File("").getAbsolutePath();
            //fileIn = new FileInputStream(this.getClass().getClassLoader().getResourceAsStream("excel.xlsx")); //Sirve para todos
            //POIFSFileSystem fs = new POIFSFileSystem(this.getClass().getClassLoader().getResourceAsStream("excel.xlsx"));
            HSSFWorkbook wb = new HSSFWorkbook(this.getClass().getClassLoader().getResourceAsStream("g2.xls"));
            HSSFSheet sheet = wb.getSheetAt(0);
            this.loadAdmin(sheet);
            sheet = wb.getSheetAt(1);
            this.loadStudent(sheet);
            sheet = wb.getSheetAt(2);
            this.loadAuthor(sheet);
            sheet = wb.getSheetAt(3);
            this.loadBibReference(sheet);
            sheet = wb.getSheetAt(4);
            this.loadReferenceHasAuthor(sheet);
            sheet = wb.getSheetAt(5);
            this.loadTopic(sheet);
            sheet = wb.getSheetAt(6);
            this.loadExercise(sheet);
            sheet = wb.getSheetAt(7);
            this.loadExerciseHasRef(sheet);
            sheet = wb.getSheetAt(8);
            this.loadExerciseHasTopic(sheet);
            sheet = wb.getSheetAt(9);
            this.loadAnswer(sheet);
            sheet = wb.getSheetAt(10);
            this.loadProcedure(sheet);
            //fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}