package com.example.test.dto.response;

import com.example.test.dto.ArticleDto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleResponse(
        Long id,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String email,
        String userName

) implements Serializable {

    public static ArticleResponse of(Long id, String title, String content, String hashtag, LocalDateTime createdAt, String email, String userName) {
        return new ArticleResponse(id, title, content, hashtag, createdAt, email, userName);
    }

    public static ArticleResponse from(ArticleDto dto) {
        String userName = dto.userAccountDto().userName();
        if (userName == null || userName.isBlank()) {
            userName = dto.userAccountDto().userId();
        }

        return new ArticleResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtag(),
                dto.createdAt(),
                dto.userAccountDto().email(),
                userName
        );
    }

}
