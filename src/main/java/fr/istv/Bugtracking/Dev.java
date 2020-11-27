package fr.istv.Bugtracking;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEVID")
    private int id;
    @Column(name = "DEVNAME")
    private String name;
    @Column(name = "BUGLIST")
    private List<Bug> buglist;
}