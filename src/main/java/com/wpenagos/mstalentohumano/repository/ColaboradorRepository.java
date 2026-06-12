package com.wpenagos.mstalentohumano.repository;

import com.wpenagos.mstalentohumano.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {


}