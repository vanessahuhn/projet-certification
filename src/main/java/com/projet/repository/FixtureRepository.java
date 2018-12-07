/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.repository;

import com.projet.model.Fixture;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vanessa
 */
public interface FixtureRepository extends JpaRepository<Fixture, Long> {
    public List<Fixture> findTop2ByOrderByFixtureIdDesc();
}
