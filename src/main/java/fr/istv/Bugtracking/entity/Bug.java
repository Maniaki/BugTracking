package fr.istv.Bugtracking.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Bug")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Bug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column (name = "CREATIONDATE")
    private Date creationDate;
    //TODO fix the dev reference not working (may use dev ID)
    @Column (name="DEVID")
    private int devId;
    //
    @Column (name = "PRIORITY")
    private String priority;
    @Column (name = "STATE")
    private String state = "TODO";
}