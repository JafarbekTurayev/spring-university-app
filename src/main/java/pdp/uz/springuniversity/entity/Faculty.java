package pdp.uz.springuniversity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //university_id
    @ManyToOne
    private University university;

    //5330050
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    private String code;


}
