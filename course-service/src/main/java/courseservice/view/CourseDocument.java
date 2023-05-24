package courseservice.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;

@Data
//@Document(indexName = "courses")
@AllArgsConstructor
@NoArgsConstructor
public class CourseDocument {

//    @Id
    private Long id;

    private String name;

    private String description;

    private String syllabus;

}
