package pdp.uz.springuniversity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 3, unique = true)
    private String name;

//    @Column(nullable = false)
    @ManyToOne
    private Faculty faculty;


    //mohiyati togri kelmadi
//    @ManyToOne
//    private Teacher teacher;
}
