package co.cstad.homework1.feature.course.dto;

public record VideoCreateRequest(
        Integer sectionOrderNo,
        String lectureNo,
        Integer orderNo,
        String title,
        String fileName

) {
}
