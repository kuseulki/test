package com.example.test.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "userId", unique = true),
        @Index(columnList = "email", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class UserAccount extends AuditingFields {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Setter @Column(nullable = false, length = 50) private String userId;       // ID
    @Setter @Column(nullable = false) private String userPassword;              // PW
    @Setter @Column(length = 100) private String userName;                      // 이름 (닉네임)
    @Setter @Column(length = 100) private String email;                         // 이메일
    @Setter @Column private String phone;                                       // 폰
    @Setter @Column private String zipCode;                                     // 우편번호
    @Setter @Column private String addr;                                        // 주소1
    @Setter @Column private String addrDetail;                                  // 주소2
    @Setter private String memo;


    protected UserAccount() {}

    private UserAccount(String userId, String userPassword, String userName, String email, String phone, String zipCode, String addr, String addrDetail, String memo) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.zipCode = zipCode;
        this.addr = addr;
        this.addrDetail = addrDetail;
        this.memo = memo;
    }

    public static UserAccount of(String userId, String userPassword, String userName, String email, String phone, String zipCode, String addr, String addrDetail, String memo) {
        return new UserAccount(userId, userPassword, userName, email, phone, zipCode, addr, addrDetail, memo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount userAccount)) return false;
        return id != null && id.equals(userAccount.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
