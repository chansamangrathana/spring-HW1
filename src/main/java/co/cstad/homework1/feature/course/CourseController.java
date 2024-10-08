package co.cstad.homework1.feature.course;


import co.cstad.homework1.domain.Course;
import co.cstad.homework1.feature.course.dto.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    //Create course
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createCourse(@RequestBody CourseCreateRequest courseCreateRequest) {
        courseService.createCourse(courseCreateRequest);
    }

    //Find all section
    @GetMapping
    public PaginatedResponse<?> getAllCourses(
            @Parameter(
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "string", allowableValues = {"snippet", "content_details"})
            )
            @RequestParam(defaultValue = "snippet") String responseType,

            @Parameter(description = "Page number")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "Page size")
            @RequestParam(defaultValue = "20") int size) {

        return courseService.findAllCourse(responseType, page, size);
    }

    //Get course by instructor's name
    @GetMapping("/instructor/{instructorName}")
    CourseResponse findCourseByInstructorName(@Valid @PathVariable String instructorName) {
        return courseService.findCourseByInstructorName(instructorName);
    }
    //Find course
    @GetMapping("/{id}")
    CourseResponse findCourseById(@Valid @PathVariable String id) {
        return courseService.findCourseById(id);
    }

    //Find course detail
    @GetMapping("/detail/{id}")
    CourseResponseDetail findCourseDetailById(@Valid @PathVariable String id) {

        return courseService.findCourseDetail(id);
    }

    //Find course By slug
    @GetMapping("/slug/{slug}")
    CourseResponse findCourseBySlug(@Valid @PathVariable String slug) {
        return courseService.findCourseBySlug(slug);
    }


    @GetMapping("/private")
    public List<Course> getPrivateCourse() {
        return courseService.getPrivateCourse();
    }

    //Get public courses
    @GetMapping("/public")
    public List<Course> getPublicCourse() {
        return courseService.getPublicCourse();
    }

    //Get free courses
    @GetMapping("/free")
    public List<Course> getFreeCourse() {
        return courseService.getFreeCourse();
    }

    //Update course by id
    @PutMapping("/{id}")
    CourseResponse updateCourse(@Valid @PathVariable String id, @RequestBody CourseUpdateRequest courseUpdateRequest) {
        return courseService.updateCourse(id, courseUpdateRequest);
    }

    //Update video
    @PutMapping("/{courseId}/videos")
    void updateVideo(@Valid @PathVariable String courseId, @RequestBody VideoUpdateRequest videoUpdateRequest) {
        courseService.updateVideo(courseId, videoUpdateRequest);
    }

    //Delete course
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteCourse(@Valid @PathVariable String id) {
        courseService.deleteCourse(id);
    }

    //Enable course
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/enable")
    void enableCourse(@Valid @PathVariable("id") String id) {
        courseService.enableCourse(id);
    }

    //Disable course
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/disable")
    void disableCourse(@Valid @PathVariable("id") String id) {
        courseService.disableCourse(id);
    }

    //Update thumbnail
    @PutMapping("/{id}/thumbnail")
    void updateThumbnail(@Valid @PathVariable String id, @RequestBody ThumbnailUpdateRequest updateThumbnail) {
        courseService.updateThumbnail(id, updateThumbnail);
    }

    //Update Payment
    @PutMapping("/{id}/is-paid")
    void updatePayment(@Valid @PathVariable String id, @RequestBody PaymentUpdateRequest updatePaymentRequest) {
        courseService.updatePayment(id, updatePaymentRequest);
    }

    //Update visibility
    @PutMapping("/{id}/visibilities")
    void updateVisibility(@Valid @PathVariable String id, @RequestBody VisibilityUpdateRequest visibilityUpdateRequest) {
        courseService.updateVisibility(id, visibilityUpdateRequest);
    }

    //Create Video
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{courseId}/videos")
    VideoCreateRequest createVideo(@Valid @PathVariable String courseId, @RequestBody VideoCreateRequest videoCreateRequest) {
        return courseService.createVideo(courseId, videoCreateRequest);
    }
    //Create section
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{courseId}/sections")
    SectionCreateRequest createSection(@Valid @PathVariable String courseId, @RequestBody SectionCreateRequest sectionCreateRequest) {
        return courseService.createSection(courseId, sectionCreateRequest);
    }

    //Create filter
    @PostMapping("/filters")
    @ResponseStatus(HttpStatus.CREATED)
    public Page<?> createFilter(
            @RequestBody FilterDto filterDto,
            @RequestParam(defaultValue = "SNIPPET") FilterResponse response,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return courseService.createFilter(filterDto, response, page, size);
    }

    //Get filter
    @GetMapping("/filters")
    public Page<?> getFilter(
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "SNIPPET") FilterResponse response,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return courseService.getFilter(title, response, page, size);
    }

}
