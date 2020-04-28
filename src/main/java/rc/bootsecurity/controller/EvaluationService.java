package rc.bootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import rc.bootsecurity.entity.Evaluation;

import rc.bootsecurity.repository.EvaluationRepository;

@Service
public class EvaluationService {

	@Autowired
	private EvaluationRepository repo;

	public List<Evaluation> listAll() {
		return repo.findAll();
	}

	public List<Evaluation> listAll(String formation) {
		return repo.findByFormation(formation);
	}

	public void save(Evaluation evaluation) {
		repo.save(evaluation);
	}

	public Evaluation get(Long id) {
		return repo.findById(id).get();
	}

}
