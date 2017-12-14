package com.metrotraining.excuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PontajController {
	
	@Autowired
	private PontajService repoService;
	
	@RequestMapping( value = "/", method =  RequestMethod.GET )
	public String login(Model model) {
		String header = repoService.getMonthName();
		model.addAttribute("header", header);
		model.addAttribute("pontajList",repoService.getPontaj());
		model.addAttribute("sum_difference",repoService.getSumDifference());
		return "main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String back(Model model,
			           @RequestParam (value="start_date") String startDate,
			           @RequestParam (value="end_date") String endDate,
			           RedirectAttributes redirectAttributes) {
		repoService.savePontaj(startDate, endDate);
		return "redirect:/";
	}
	
}
