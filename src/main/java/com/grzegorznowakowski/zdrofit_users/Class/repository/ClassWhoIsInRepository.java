package com.grzegorznowakowski.zdrofit_users.Class.repository;

import com.grzegorznowakowski.zdrofit_users.Class.entity.ClassWhoIsIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassWhoIsInRepository extends JpaRepository<ClassWhoIsIn, Long> {
}
