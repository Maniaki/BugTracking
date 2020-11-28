package fr.istv.Bugtracking.model;

import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Entity
@Table(name = "Dev")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Dev implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "AVATAR")
    private Image avatar;
}