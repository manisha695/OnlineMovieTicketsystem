package com.capgemini.omts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.omts.entity.ShowBean;

@Repository
public interface ShowRepository extends JpaRepository<ShowBean, Integer> {

}
