package rc.bootsecurity.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import rc.bootsecurity.entity.Formation; 

public interface FormationRepository extends JpaRepository <Formation, Long> {

	/* Formation findByFormation(String formation); */
	

}
