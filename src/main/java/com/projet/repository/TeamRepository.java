/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.repository;

import com.projet.model.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    /**
     * recherche toutes les équipes et les ordonne selon leur nombre de points, dans l'ordre décroissant
     * @author vanessa
     * @return une collection d'équipes
     */
    public List<Team> findByOrderByPointsDesc();
}
