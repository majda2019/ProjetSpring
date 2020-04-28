package rc.bootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rc.bootsecurity.entity.Evaluation;
import rc.bootsecurity.entity.Formation;

@Controller
@RequestMapping("user/formations")
public class FormationControllerUser {
	@Autowired
	private FormationService service;
	
	@Autowired
	private EvaluationService evaluationService;

	@GetMapping("")
	public String show(Model model) {

		List<Formation> listFormations = service.listAll();
		model.addAttribute("listFormations", listFormations);

		return "user/formationListUser";

	}

}
