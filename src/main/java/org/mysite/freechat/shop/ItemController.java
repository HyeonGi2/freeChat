package org.mysite.freechat.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        return "main.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@RequestParam String title, String  price) {
        System.out.println(title);
        System.out.println(price);
        return "redirect:/list";
    }

//    맵자료형
//    @PostMapping("/add")
//    String addPost(@RequestParam Map formData) {
//        System.out.println(formData);
//        return "redirect:/list";
//    }

//    @PostMapping("/add")
//    String addPost(@RequestParam Map formData) {
//        var test = new HashMap<>();
//        test.put("name", "kim");
//        test.put("age", 20);
//
//        System.out.println(test.get("name"));
//
//        return "redirect:/list";
//    }

}
