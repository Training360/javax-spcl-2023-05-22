package courseservice.view;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseDocumentController {

    private CourseDocumentService courseDocumentService;

    @GetMapping("/api/course-documents")
    public List<CourseDocument> findByWord(@RequestParam String word) {
        return courseDocumentService.findByWord(word);
    }
}
