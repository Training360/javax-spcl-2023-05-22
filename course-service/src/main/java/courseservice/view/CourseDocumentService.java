package courseservice.view;

import courseservice.course.service.CourseHasBeenCreated;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseDocumentService {

//    private CourseDocumentRepository courseDocumentRepository;

    @EventListener
    public void handleEvent(CourseHasBeenCreated event) {
        var document = new CourseDocument(event.getId(), event.getName(), event.getDescription(), event.getSyllabus());
//        courseDocumentRepository.save(document);
    }

    public List<CourseDocument> findByWord(String word) {
//        return courseDocumentRepository.findByWordsUsingCustomQuery(word);
        return null;
    }
}
