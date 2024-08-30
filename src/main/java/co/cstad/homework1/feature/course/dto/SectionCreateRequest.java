package co.cstad.homework1.feature.course.dto;


import co.cstad.homework1.domain.Video;

import java.util.List;

public record SectionCreateRequest(
        String title,
        Integer orderNo,
        List<Video> videos
) {
}
