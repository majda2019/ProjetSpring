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

import rc.bootsecurity.entity.Formation;

@Controller
@RequestMapping("admin/formations")
public class FormationController {
	@Autowired
	private FormationService service;

	

	@GetMapping("")
	public String show(Model model) {

		List<Formation> listFormations = service.listAll();
		model.addAttribute("listFormations", listFormations);

		return "admin/formationList";

	}

	@GetMapping("/new")
	public String showFormation(Model model) {

		Formation formation = new Formation();
		model.addAttribute("formation", formation);

		return "admin/new_formation";

	}

	@PostMapping(value = "/save")
	public String saveFormation(@ModelAttribute("formation") Formation formation) {

		service.save(formation);

		return "redirect:/admin/index";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView showeditFormation(@PathVariable(name = "id") long id) {

		ModelAndView mav = new ModelAndView("admin/edit_formation");
		Formation formation = service.get(id);
		mav.addObject("formation", formation);
		return mav;

	}
	/*
	 * @GetMapping("/formations") public ModelAndView
	 * showeditFormation(@PathVariable(name = "formation") String formation) {
	 * 
	 * ModelAndView mav = new ModelAndView("admin/formations"); Formation formation1
	 * = service.get(formation); mav.addObject("formation" , formation1); return
	 * mav;
	 * 
	 * }
	 */

	@GetMapping("/delete/{id}")
	public String deleteformation(@PathVariable(name = "id") long id) {

		service.delete(id);

		return "redirect:/admin/index";

	}

}
