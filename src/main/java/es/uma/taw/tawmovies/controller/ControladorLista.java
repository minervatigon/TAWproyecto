package es.uma.taw.tawmovies.controller;

import es.uma.taw.tawmovies.dao.ListaRepository;
import es.uma.taw.tawmovies.dao.UserTypeRepository;
import es.uma.taw.tawmovies.movies.Lista;
import es.uma.taw.tawmovies.movies.UserType;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class ControladorLista {

    @Autowired protected ListaRepository listaRepository;
    @Autowired protected UserTypeRepository userTypeRepository;

    @GetMapping("/pagLista")
    public String lista(Model model, HttpSession session, @RequestParam("act")Integer userId) {
        UserType user= this.userTypeRepository.findById(userId).orElse(null);
        List<Lista> listas = user.getListas();

        model.addAttribute("user", user);
        model.addAttribute("listas", listas);

        return "/listas";
    }
}
