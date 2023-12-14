package com.example.dataanalysergrpcmicroservice.repository;

import com.example.dataanalysergrpcmicroservice.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
