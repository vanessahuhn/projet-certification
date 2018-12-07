/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.repository;

import com.projet.model.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vanessa
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
    public List<Team> findByOrderByPointsDesc();
}
