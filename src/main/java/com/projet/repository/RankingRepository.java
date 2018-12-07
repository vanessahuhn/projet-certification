/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.repository;

import com.projet.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vanessa
 */
public interface RankingRepository extends JpaRepository<Ranking, Long> {

}
