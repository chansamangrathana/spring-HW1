package co.cstad.homework1.mapper;


import co.cstad.homework1.domain.Course;
import co.cstad.homework1.domain.Section;
import co.cstad.homework1.domain.Video;
import co.cstad.homework1.feature.course.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course fromCourseCreateRequest(CourseCreateRequest courseCreateRequest);
    Section fromSectionCreateRequest(SectionCreateRequest sectionCreateRequest);
    Video fromVideoCreateRequest(VideoCreateRequest videoCreateRequest);
    CourseResponse toCourseResponse(Course course);
    CourseResponseDetail toCourseResponseDetail(Course courses);
    List<CourseResponse> toCourseResponseList(List<Course> courses);
    List<CourseResponseDetail> toCourseResponseDetailList(List<Course> courses);
    List<SectionResponse> toSectionResponseList(List<Section> sections);
    @Mapping(target = "videos", source = "videos")
    SectionResponse toSectionResponse(Section section);
    void fromCourseUpdateRequest(CourseUpdateRequest courseUpdateRequest, @MappingTarget Course course);
    void fromVideoUpdateRequest(VideoUpdateRequest videoUpdateRequest, @MappingTarget Course course);
    @Mapping(target = "sectionOrderNo", source = "sectionOrderNo")
    VideoCreateRequest toVideoCreateRequest(VideoCreateRequest videoCreateRequest);
    SectionCreateRequest toSectionCreateRequest(SectionCreateRequest sectionCreateRequest);

}
