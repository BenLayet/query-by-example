package com.example.restservice.repository;

import com.example.restservice.domain.CaseFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseFileRepository extends JpaRepository<CaseFile, String> {
}
