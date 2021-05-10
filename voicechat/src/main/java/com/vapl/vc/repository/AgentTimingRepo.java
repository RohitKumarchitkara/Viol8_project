package com.vapl.vc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.oneToMany.entity.Agents_Timings;
import com.vapl.vc.model.*;
@Repository
public interface AgentTimingRepo extends JpaRepository<Agents_Timings, Long> {

}
