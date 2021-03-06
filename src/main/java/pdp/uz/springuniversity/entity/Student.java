package pdp.uz.springuniversity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;

    private int age;

    @OneToOne
    private Address address;

    @ManyToOne
    private Group group;

    @ManyToMany
    private List<Subject> subjectList;
}
