package co.cstad.homework1.util;


import co.cstad.homework1.domain.Course;
import co.cstad.homework1.feature.course.dto.CourseResponse;
import co.cstad.homework1.feature.course.dto.CourseResponseDetail;
import co.cstad.homework1.feature.course.dto.FilterResponse;
import co.cstad.homework1.mapper.CourseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseUtil {
    public static Page<?> mapCoursesResponse(List<Course> courses, FilterResponse response, CourseMapper courseMapper) {
        if (response == FilterResponse.CONTENT_DETAILS) {
            // Map courses to CourseResponseDetail DTOs
            List<CourseResponseDetail> courseResponseDetails = courses.stream()
                    .map(courseMapper::toCourseResponseDetail)
                    .collect(Collectors.toList());
            return new PageImpl<>(courseResponseDetails);
        } else {
            // Map courses to CourseResponse DTOs
            List<CourseResponse> courseResponses = courses.stream()
                    .map(courseMapper::toCourseResponse)
                    .collect(Collectors.toList());
            return new PageImpl<>(courseResponses);
        }
    }
}
