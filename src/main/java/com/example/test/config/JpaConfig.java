package com.example.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware(){
        return () -> Optional.of("test_user"); // TODO: 임시데이터, 시큐리티로 인증 기능 구현 시 수정.
    }
}

// 시큐리티 설정 전, 임시로 작성자 test_user 로 입력.