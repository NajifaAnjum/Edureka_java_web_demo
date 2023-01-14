package com.example.SubmissionForms_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @Autowired
    CustomersRepo repo;                      //CustomerRepo is the interface that we have created and repo(variable) is for action.
    //show the form

    @RequestMapping("/")                                     //after RequestMapping can give only slash and after GetMapping need a text after slash
    public String details(){
        return "edureka";
    }
    //saving the data to the database
    @RequestMapping("/details")
    public String details(Customers customers){              //when the details are fetched and entered thats why we need Customers object customers
        repo.save(customers);                                //saving the data
        return "edureka";
    }
    //search by id(id input form)
    @RequestMapping("/getdetails")
    public String getdetails(){
        return "ViewCustomers";
    }
    //retrieve the data from db by id
    @PostMapping("/getdetails")
    public ModelAndView getdetails(@RequestParam int cid)                //requesting the id
    {
        ModelAndView mv = new ModelAndView("Retrieve");
        Customers customers = repo.findById(cid).orElse(null);
        mv.addObject(customers);
        return mv;
    }
}
