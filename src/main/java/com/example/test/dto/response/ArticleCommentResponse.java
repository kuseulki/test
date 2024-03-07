package com.example.test.dto.response;

import com.example.test.dto.ArticleCommentDto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleCommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        String email,
        String userName
) implements Serializable {

    public static ArticleCommentResponse of(Long id, String content, LocalDateTime createdAt, String email, String userName) {
        return new ArticleCommentResponse(id, content, createdAt, email, userName);
    }

    public static ArticleCommentResponse from(ArticleCommentDto dto) {
        String userName = dto.userAccountDto().userName();
        if (userName == null || userName.isBlank()) {
            userName = dto.userAccountDto().userId();
        }

        return new ArticleCommentResponse(
                dto.id(),
                dto.content(),
                dto.createdAt(),
                dto.userAccountDto().email(),
                userName
        );
    }

}
