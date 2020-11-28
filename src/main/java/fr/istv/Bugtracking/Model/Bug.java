package fr.istv.Bugtracking.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    @Column(name = "DESC")
    private String description;
    @Column (name = "CREATIONDATE")
    private Date creationDate;
    @Column(name = "DEV")
    private Dev dev;
    @Column (name = "PRIORITY")
    private String priority;
    @Column (name = "STATE")
    private String state = "TODO";
}