package pdp.uz.springuniversity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //serial  sequence
    private int id;

    private String name;
    //Aggregation
    //address_id
    @OneToOne
    private Address address;
//    private String address;

    //fakultetlar ro'yxati

}
