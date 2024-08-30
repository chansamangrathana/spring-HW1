package co.cstad.homework1.feature.course.dto;



import co.cstad.homework1.domain.Video;

import java.util.List;

public record SectionResponse(
        String title,
        Integer orderNo,
        List<Video> videos
) {
}
