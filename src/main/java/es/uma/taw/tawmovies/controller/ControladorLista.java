package es.uma.taw.tawmovies.controller;

import es.uma.taw.tawmovies.dao.ListaRepository;
import es.uma.taw.tawmovies.dao.MovieRepository;
import es.uma.taw.tawmovies.dao.UserTypeRepository;
import es.uma.taw.tawmovies.movies.Lista;
import es.uma.taw.tawmovies.movies.Movie;
import es.uma.taw.tawmovies.movies.UserType;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class ControladorLista {

    @Autowired protected ListaRepository listaRepository;
    @Autowired protected UserTypeRepository userTypeRepository;
    @Autowired protected MovieRepository movieRepository;

    @GetMapping("/pagLista")
    public String lista(Model model, HttpSession session, @RequestParam("act")Integer userId) {
        UserType user= this.userTypeRepository.findById(userId).orElse(null);
        List<Lista> listas = user.getListas();

        model.addAttribute("user", user);
        model.addAttribute("listas", listas);

        return "/listas";
    }
    @GetMapping("/añadirLista")
    public String anyadirLista(Model model, HttpSession session, @RequestParam("userId")Integer userId) {
        UserType user= this.userTypeRepository.findById(userId).orElse(null);
        List<Movie> movies = this.movieRepository.findAll();

        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("movies", movies);

        return "crearLista";
    }

    @GetMapping("/eliminarLista")
    public String eliminarLista(Model model, HttpSession session, @RequestParam("act")Integer listaId, RedirectAttributes redirectAttributes) {
        Lista lista = listaRepository.findById(listaId).orElse(null);
        UserType user = lista.getUsuario();
        user.removeLista(lista);
        listaRepository.delete(lista);

        redirectAttributes.addAttribute("userId", user.getId());
        return "redirect:/pagLista";
    }
}
