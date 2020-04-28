package rc.bootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rc.bootsecurity.entity.Evaluation;
import rc.bootsecurity.entity.Formation;

@Controller
@RequestMapping("user/evaluations/{formationId}")
public class EvaluationController {
	@Autowired
	private EvaluationService service;
	@Autowired
	private FormationService formationService;

	@GetMapping("")
	public String index(@PathVariable(name = "formationId") long id, Model model) {

		List<Evaluation> listEvaluations = service.listAll(Long.toString(id));
		model.addAttribute("listEvaluations", listEvaluations);
		model.addAttribute("formationId", Long.toString(id));
		model.addAttribute("formation", formationService.get(id));
		return "user/evaluationList";
	}

	@GetMapping("/new")
	public String add(@PathVariable(name = "formationId") long id, ModelMap modelMap) {
		modelMap.put("evaluation", new Evaluation(Long.toString(id)));
		modelMap.put("formationId", Long.toString(id));

		return "user/evaluation";
	}

	@PostMapping(value = "/save")
	public String saveFormation(@PathVariable(name = "formationId") long id, @ModelAttribute("evaluation") Evaluation evaluation) {

		evaluation.setFormation(Long.toString(id));
		
		service.save(evaluation);

		return "redirect:/user/index";
	}

}
