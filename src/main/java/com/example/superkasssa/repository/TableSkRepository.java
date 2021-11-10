package com.example.superkasssa.repository;

import com.example.superkasssa.entity.TableSk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableSkRepository extends JpaRepository<TableSk, Long> {

    Optional<TableSk> findById(Long id);
}
