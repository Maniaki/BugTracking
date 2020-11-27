package fr.istv.Bugtracking;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BUGID")
    private int id;
    @Column(name = "GUBNAME")
    private String name;
    @Column(name = "BUGDESC")
    private String description;
    @Column(name = "DEVLIST")
    private List<Dev> devlist;
}