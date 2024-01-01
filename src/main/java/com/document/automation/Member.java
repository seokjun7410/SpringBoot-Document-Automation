package com.document.automation;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Access(value = AccessType.FIELD)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String pw;
    private String name;


    public Member(String email, String pw, String name) {
        this.email = email;
        this.pw = pw;
        this.name = name;
    }

    public ID getId() {
        return new ID(id);
    }

    public static Member create(String email, String pw, String name) {
        return new Member(email, pw, name);
    }

}
