package es.uma.taw.tawmovies.controller;

import es.uma.taw.tawmovies.dao.*;
import es.uma.taw.tawmovies.movies.*;

import es.uma.taw.tawmovies.ui.Filtro;
import es.uma.taw.tawmovies.ui.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlador {

    @Autowired private MovieRepository movieRepository;

    @Autowired private GenderRepository genderRepository;
    @Autowired private SpokenLanguageRepository spokenLanguageRepository;
    @Autowired private UserTypeRepository userTypeRepository;
    @Autowired private PersonRepository personRepository;

    protected boolean estaAutenticado(HttpSession session) {
        return session.getAttribute("user") != null;
    }


    @GetMapping("/")
    public String doListar(HttpSession session, Model model) {
        model.addAttribute("trending",  movieRepository.findTop10ByOrderByPopularityDesc());
        model.addAttribute("topRated",  movieRepository.findTop10ByOrderByVoteAverageDesc());
        model.addAttribute("upcoming",  movieRepository.findTop10ByReleaseDateAfterOrderByReleaseDateAsc(LocalDate.now()));

        model.addAttribute("genders",  genderRepository.findAll());
        model.addAttribute("spokenLanguages",  spokenLanguageRepository.findAll());

        model.addAttribute("filtro", new Filtro());
        if (!estaAutenticado(session)) {
            model.addAttribute("usuario", new Usuario()); // Para el form:form de login
        }else{
            model.addAttribute("usuario", session.getAttribute("user"));
        }
        return "index";
    }

    @PostMapping("/autentica")
    public String doLogin (@ModelAttribute("usuario") Usuario usuario,
                           Model model,
                           HttpSession session, RedirectAttributes redirectAttributes) {

        UserType user = this.userTypeRepository.autenticaUsuario(usuario.getUsername(), usuario.getPassword());
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
        } else {
            session.setAttribute("user", user);
        }
        return "redirect:/";
    }

    @GetMapping("/movie/{id}")
    public String verDetalles(@PathVariable("id") Integer id, Model model, HttpSession session) {
        Movie movie = movieRepository.findById(id).orElse(null);
        List<SpokenLanguage> languages = spokenLanguageRepository.findAll();
        List<Gender> generos = genderRepository.findAll();

        if (movie == null) {
            return "redirect:/"; // si no existe, vuelve a inicio
        }

        model.addAttribute("movie", movie);
        model.addAttribute("languages", languages);
        model.addAttribute("generos", generos);

        return "movieDetails"; // JSP de detalles
    }

    @PostMapping("/filtrarPeliculas")
    public String filtrarPeliculas(HttpSession session,
            @ModelAttribute("filtro") Filtro filtro,
            Model model) {

        List<Movie> movies = movieRepository.findWithFilters(
                filtro.getOriginalLanguage(),
                filtro.getPopMin(), filtro.getPopMax(),
                filtro.getStartDate(), filtro.getEndDate(),
                filtro.getDurMin(), filtro.getDurMax(),
                filtro.getVoteMin(), filtro.getVoteMax(),
                filtro.getGenreId(), filtro.getLanguageId(), filtro.getTitle()
        );

        model.addAttribute("resultados", movies);
        model.addAttribute("genders",  genderRepository.findAll());
        model.addAttribute("spokenLanguages",  spokenLanguageRepository.findAll());
        model.addAttribute("usuario", session.getAttribute("user"));

        return "resultadoBusqueda";  // tu JSP: /WEB-INF/views/filtros.jsp
    }

    @PostMapping("/editar")
    public String editarPelicula(HttpSession session,
                                 @RequestParam("id")Integer id,
                                 @RequestParam("titulo")String tit,
                                 @RequestParam("fecha") Date fecha,
                                 @RequestParam("duracion")Long duracion,
                                 @RequestParam("idioma")String idioma,
                                 @RequestParam("resumen")String resumen,
                                 @RequestParam("character")List<String> character,
                                 @RequestParam("actor") List<String> actor,
                                 @RequestParam("languages")List<Integer>langId,
                                 @RequestParam("generos")List<Integer>genreId,
                                 @RequestParam("order") List<Integer>order,
                                 RedirectAttributes redirectAttributes){
        Movie movie = movieRepository.findById(id).orElse(null);

        List<Cast> castList = new ArrayList<>();
        List<SpokenLanguage> languages = new ArrayList<>();
        List<Gender> generos = new ArrayList<>();

        for(int i=0;i<actor.size();i++){
            Cast cast = new Cast();
            cast.setIdPerson(this.personRepository.findByNombre(actor.get(i)));
            cast.setIdMovie(movie);
            cast.setCharacters(character.get(i));
            cast.setOrder(order.get(i));
            castList.add(cast);
        }
        for(Integer i : langId){
            languages.add(this.spokenLanguageRepository.findById(i).orElse(null));
        }
        for(Integer i : genreId){
            generos.add(this.genderRepository.findById(i).orElse(null));
        }
        if(movie != null){
            movie.setTitle(tit);
            movie.setReleaseDate(fecha.toLocalDate());
            movie.setRuntime(duracion);
            movie.setOriginalLanguage(idioma);
            movie.setOverview(resumen);

            movie.getCastList().clear();
            this.movieRepository.save(movie);

            movie.getCastList().addAll(castList);
            movie.setLanguages(languages);
            movie.setGenres(generos);
            this.movieRepository.save(movie);
        }
        redirectAttributes.addAttribute("id", id);

        return "redirect:/movie/{id}";
    }
    @PostMapping("/añadir")
    public String anyadirMovie(Model model, HttpSession session){
        List<Gender> genders = this.genderRepository.findAll();
        List<SpokenLanguage> languages = this.spokenLanguageRepository.findAll();

        model.addAttribute("generos",  genders);
        model.addAttribute("languages", languages);

        return"crearMovie";
    }
    @PostMapping("/crear")
    public String crearPelicula(HttpSession session,
                                @RequestParam("budget")Integer budget,
                                @RequestParam("homepage")String homepage,
                                @RequestParam("orlan")String orlan,
                                @RequestParam("ortit")String ortit,
                                @RequestParam("overview")String overview,
                                @RequestParam("pop")Integer popular,
                                @RequestParam("reldate")Date reldate,
                                @RequestParam("runtime")Long runtime,
                                @RequestParam("revenue")Long revenue,
                                @RequestParam("status")String status,
                                @RequestParam("title")String title,
                                @RequestParam("tagline")String tagline,
                                @RequestParam("voteavg")Double voteavg,
                                @RequestParam("votecount")Integer votecount,
                                @RequestParam("generos")List<Integer> generosid,
                                @RequestParam("languages")List<Integer> languagesid,
                                @RequestParam("castChar")List<String> characters,
                                @RequestParam("castPer")List<String> persons,
                                @RequestParam("castGen")List<Integer> genPer,
                                @RequestParam("ord")List<Integer> order) {
        Movie movie = new Movie();
        List<Gender> generos = new ArrayList<>();
        List<SpokenLanguage> languages = new ArrayList<>();
        List<Cast> castList = new ArrayList<>();

        for(Integer i : languagesid){
            languages.add(this.spokenLanguageRepository.findById(i).orElse(null));
        }
        for(Integer i : generosid){
            generos.add(this.genderRepository.findById(i).orElse(null));
        }
        for(int i=0;i<persons.size();i++){
            Cast cast = new Cast();
            Person person = new Person();
            person.setName(persons.get(i));
            person.setGender(genPer.get(i));
            this.personRepository.save(person);

            cast.setIdPerson(person);
            cast.setIdMovie(movie);
            cast.setCharacters(characters.get(i));
            cast.setOrder(order.get(i));
            castList.add(cast);
        }

        movie.setBudget(budget);
        movie.setHomepage(homepage);
        movie.setOriginalLanguage(orlan);
        movie.setOriginalTitle(ortit);
        movie.setOverview(overview);
        movie.setPopularity(popular);
        movie.setReleaseDate(reldate.toLocalDate());
        movie.setRuntime(runtime);
        movie.setRevenue(revenue);
        movie.setStatus(status);
        movie.setTitle(title);
        movie.setTagline(tagline);
        movie.setVoteAverage(voteavg);
        movie.setVoteCount(votecount);
        movie.setGenres(generos);
        movie.setLanguages(languages);
        movie.setCastList(castList);

        this.movieRepository.save(movie);

        return "redirect:/";
    }
    @GetMapping("/eliminar")
    public String eliminarPelicula(HttpSession session,@RequestParam("act") Integer movieId){
        this.movieRepository.deleteById(movieId);
        return "redirect:/";
    }
    @GetMapping("/salir")
    public String doLogout (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }



}