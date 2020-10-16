package com.dmstjd1024.boardrestfulapi.account;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private LocalDateTime emailTokenGeneratedAt;

    private String emailCheckToken;

    private boolean emailVerified;

    @Embedded
    private Address address;

}
