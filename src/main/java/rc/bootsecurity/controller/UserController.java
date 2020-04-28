
package rc.bootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rc.bootsecurity.entity.Evaluation;
import rc.bootsecurity.entity.Formation;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private FormationService service;
	
	@Autowired
	private EvaluationService evaluationService;

	@GetMapping("index")
	public String admin(Model model) {

		List<Formation> listFormations = service.listAll();
		model.addAttribute("listFormations", listFormations);

		List<Evaluation> listEvaluations = evaluationService.listAll();
		model.addAttribute("listEvaluations", listEvaluations);

		return "user/formationListUser";
	}

}