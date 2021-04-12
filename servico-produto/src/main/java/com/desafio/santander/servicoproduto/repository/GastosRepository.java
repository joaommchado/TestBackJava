package com.desafio.santander.servicoproduto.repository;

import com.desafio.santander.servicoproduto.model.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastosRepository extends JpaRepository<Gastos, Long> {

}
