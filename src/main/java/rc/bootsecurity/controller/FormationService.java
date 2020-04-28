package rc.bootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rc.bootsecurity.entity.Formation;
import rc.bootsecurity.repository.FormationRepository;

@Service
public class FormationService {
	
@Autowired

private FormationRepository repo;

public List<Formation> listAll(){
	
	return repo.findAll();
	
}

public void save(Formation formation) {
	
	repo.save(formation);
	
}	
	
public Formation get(Long id) {
	
	return repo.findById(id).get();
	
	
}	
	/*
	 * public Formation get(String formation) {
	 * 
	 * return (Formation) repo.findByFormation(formation);
	 * 
	 * 
	 * }
	 */
	
	
public void delete(Long id) {
	
	repo.deleteById(id);
	
	
}	

}
