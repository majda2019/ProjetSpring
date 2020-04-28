package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import rc.bootsecurity.entity.Contact;

@Controller
@RequestMapping("user")
public class ContactController {
	@Autowired
	private MailService MailService;

	@GetMapping("/inscription")
	public String index(ModelMap modelMap) {
		modelMap.put("contact", new Contact());

		return "user/inscription";
	}

	@GetMapping("")
	@ResponseBody
	public String index2() {
		return "Bonjour 2";
	}

	@PostMapping(value = "/inscription/send")
	public String send(@ModelAttribute("contact") Contact contact, ModelMap modelMap) {

		try {
			String content = "Name:" + contact.getName();
			content += "<br>Phone:" + contact.getPhone();
			content += "<br>Adresse:" + contact.getAdress();
			content += "<br>Email:" + contact.getEmail();
			MailService.send(contact.getEmail(), "elgarni.majdaa@gmail.com", contact.getSubject(), content);
			modelMap.put("msg", "Bravo! votre demande est envoyé");
		}

		catch (Exception e) {
			modelMap.put("msg", e.getMessage());
		}

		// modelMap.put("contact", new Contact());

		return "user/sucess";

	}

}
