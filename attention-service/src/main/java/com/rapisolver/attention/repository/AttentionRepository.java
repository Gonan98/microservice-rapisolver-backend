package com.rapisolver.attention.repository;

import com.rapisolver.attention.entities.Attention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttentionRepository extends JpaRepository<Attention, Long> {

}
