package guru.springframework.spring5recipeapp.controllers;

import guru.springframework.spring5recipeapp.domain.Category;
import guru.springframework.spring5recipeapp.domain.UnitOfMeasure;
import guru.springframework.spring5recipeapp.repositories.CategoryRepository;
import guru.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import guru.springframework.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String getIndexPage(Model model){
        log.debug("Getting Index Page");
        System.out.println("inside 'getIndexPage'");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

    @RequestMapping("/testRepos")
    public String testRepos(){
//        Optional<Category> americanOptional = categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> teaSpoonOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
//        Optional<Category> hamadaOptional = categoryRepository.findByDescription("hamada");
//
//        System.out.println(americanOptional.get().getId() + ": " + americanOptional.get().getDescription());
//        System.out.println(teaSpoonOptional.get().getId() + ": " + teaSpoonOptional.get().getDescription());
//
//        System.out.println(hamadaOptional.orElse(null));

        return "index";
    }
}
