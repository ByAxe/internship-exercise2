package by.novacom.exercise.controllers;

import by.novacom.exercise.entities.CompaniesEntity;
import by.novacom.exercise.entities.EmployeesEntity;
import by.novacom.exercise.service.implementation.CompaniesServiceImpl;
import by.novacom.exercise.service.implementation.EmployeesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application index page.
 */
@Controller
public class AppController {

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    CompaniesServiceImpl companiesService;

    @Autowired
    EmployeesServiceImpl employeesService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employeesList(Model model, @ModelAttribute("company") CompaniesEntity company) {

        model.addAttribute("employees", new EmployeesEntity());
        model.addAttribute("employeesList", this.employeesService.getEmployeesByCompany(company));

        return "employees";
    }

    @RequestMapping(value = "/structures", method = RequestMethod.GET)
    public String structuresList(Model model) {

        model.addAttribute("structures", new CompaniesEntity());
        model.addAttribute("structuresList", this.companiesService.getCompaniesList());

        return "structures";
    }

}