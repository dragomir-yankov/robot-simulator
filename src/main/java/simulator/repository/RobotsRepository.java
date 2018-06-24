package simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simulator.model.Robot;

@Repository
public interface RobotsRepository extends JpaRepository<Robot, Integer> {
	
}
