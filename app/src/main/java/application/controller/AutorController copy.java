package application.controller;

import org.springframekwork.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.GeneroRepository;

@Controller
@RequestMapping("/Autor")
public class AutorController {
    @Autowired
    private AutorRepository autorRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("autores", autorRepo.findAll());
        return "/autor/list";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "/autor/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome) {
        Autor autor = new Autor();
        autor.setNome(nome);

        autorRepo.save(autor);

        return "redirect:/autor/list";
    }
    
}