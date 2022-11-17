package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.io.IOException;
@Controller
public class ProductController {

    @GetMapping("/products")
    public String showProduct(ModelMap modelMap){
        modelMap.addAttribute("products", ProductService.products);
        return "/showProduct";
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        return modelAndView;
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Product product) throws IOException {
       ProductService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product",ProductService.getProduct(id));
        return modelAndView;
    }

    @PostMapping ("/edit")
    public ModelAndView edit(@ModelAttribute Product product, @RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        ProductService.edit(ProductService.findIndexById(id), product);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {

        ProductService.delete(id);

        return "redirect:/products";
    }


}
