package com.example.test.dto;

import com.example.test.domain.UserAccount;

import java.time.LocalDateTime;

public record UserAccountDto(
        String userId,
        String userPassword,
        String userName,
        String email,
        String phone,
        String zipCode,
        String addr,
        String addrDetail,
        String memo,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static UserAccountDto of(String userId, String userPassword, String userName, String email, String phone, String zipCode, String addr, String addrDetail, String memo) {
        return new UserAccountDto(userId, userPassword, userName, email, phone, zipCode, addr, addrDetail, memo,null, null, null, null);
    }

    public static UserAccountDto of(String userId, String userPassword, String userName, String email, String phone, String zipCode, String addr, String addrDetail, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(userId, userPassword, userName, email, phone, zipCode, addr, addrDetail, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getZipCode(),
                entity.getAddr(),
                entity.getAddrDetail(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public UserAccount toEntity() {
        return UserAccount.of(
                userId,
                userPassword,
                userName,
                email,
                phone,
                zipCode,
                addr,
                addrDetail,
                memo
        );
    }
}
