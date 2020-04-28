package rc.bootsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rc.bootsecurity.entity.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

	@Query("select e from evaluation e where e.formation = ?1")
	public List<Evaluation> findByFormation(String formation);

}
