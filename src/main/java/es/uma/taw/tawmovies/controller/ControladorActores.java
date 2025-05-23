package es.uma.taw.tawmovies.controller;

import es.uma.taw.tawmovies.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControladorActores {

    @Autowired protected PersonRepository personRepository;


}
