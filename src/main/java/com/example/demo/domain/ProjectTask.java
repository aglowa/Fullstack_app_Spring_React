package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/*
EntityClass -> Having the ability to represent objects in the database
EntityClass has to public getter and setters for every field.
Database table name is the same like a class.
Columns name is the same like fields and has possibility to have a null value
*/

@Entity
public class ProjectTask {
/* using annotations as our configure method is just a convenient method instead
   of coping the endless XML configuration file.
   The @Id annotation is inherited from javax.persistence.Id， indicating the member
   field below is the primary key of current entity.
   The @GeneratedValue annotation is to configure the way of increment of the specified column(field).
   For example when using Mysql, you may specify auto_increment in the definition of table to make it
   self-incremental, and then use.
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    NotBlank w celu obsługi pola i przechwycenia wyjątku
     */
    @NotBlank(message = "Summary cannot be blank")
    private String summary;
    private String acceptanceCriteria;
    private String status;
    public ProjectTask(){

    }
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary(){
        return summary;
    }

    public void setSummary(String summary){
        this.summary = summary;
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria){
        this.acceptanceCriteria = acceptanceCriteria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}

