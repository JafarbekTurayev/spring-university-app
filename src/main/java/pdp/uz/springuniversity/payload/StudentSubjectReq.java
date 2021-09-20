package pdp.uz.springuniversity.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjectReq {
    private int studentId;
    private List<Integer> subjectIds;
}
