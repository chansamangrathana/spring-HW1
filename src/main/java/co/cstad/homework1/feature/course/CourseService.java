package co.cstad.homework1.feature.course;

import co.cstad.homework1.domain.Course;
import co.cstad.homework1.feature.course.dto.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    // Create a new course
    void createCourse(CourseCreateRequest courseCreateRequest);

    // Retrieve all courses with pagination and response type
    PaginatedResponse<?> findAllCourse(String responseType, int page, int size);

    // Retrieve all private courses
    List<Course> getPrivateCourse();

    // Retrieve all public courses
    List<Course> getPublicCourse();

    // Retrieve all free courses
    List<Course> getFreeCourse();

    // Find a course by the instructor's username
    CourseResponse findCourseByInstructorName(String instructorUsername);

    // Retrieve detailed information about a course by its ID
    CourseResponseDetail findCourseDetail(String id);

    // Find a course by its ID
    CourseResponse findCourseById(String id);

    // Retrieve all sections of a course
    List<SectionResponse> findSection();

    // Find a course by its slug
    CourseResponse findCourseBySlug(String slug);

    // Update an existing course by its ID
    CourseResponse updateCourse(String id, CourseUpdateRequest courseUpdateRequest);

    // Delete a course by its ID
    void deleteCourse(String id);

    // Enable a course by its ID
    void enableCourse(String id);

    // Disable a course by its ID
    void disableCourse(String id);

    // Update a course's thumbnail by its ID
    void updateThumbnail(String id, ThumbnailUpdateRequest updateThumbnail);

    // Update a course's payment status by its ID
    void updatePayment(String id, PaymentUpdateRequest updatePaymentRequest);

    // Update a course's visibility status by its ID
    void updateVisibility(String id, VisibilityUpdateRequest visibilityUpdateRequest);

    // Update a course's video by its ID
    void updateVideo(String id, VideoUpdateRequest videoUpdateRequest);

    // Create a new video for a course by its ID
    VideoCreateRequest createVideo(String id, VideoCreateRequest videoCreateRequest);

    // Create a new section for a course by its ID
    SectionCreateRequest createSection(String id, SectionCreateRequest sectionCreateRequest);

    // Apply filters to the courses with pagination
    Page<?> createFilter(FilterDto filterDto, FilterResponse filterResponse, int page, int size);

    // Retrieve filtered courses by title with pagination
    Page<?> getFilter(String title, FilterResponse filterResponse, int page, int size);
}
