package com.firstjobapp.repository;

import com.firstjobapp.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("select j from Job j where j.location=:location")
    List<Job> findJobByLocation(@Param("location")String jobTitle);

}

