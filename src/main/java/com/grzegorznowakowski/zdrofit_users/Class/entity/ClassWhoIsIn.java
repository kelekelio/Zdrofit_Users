package com.grzegorznowakowski.zdrofit_users.Class.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class_who_is_in")
public class ClassWhoIsIn {

    @Id
    private Long id;

    private String firstName;

    private String nickName;

    private String lastName;

    private String photoUrl;

    private boolean isStandby;

    private boolean isCanceled;

    private Long classId;

    private Long companyId;

    private Timestamp timestamp;

    private boolean isDeleted;
}
