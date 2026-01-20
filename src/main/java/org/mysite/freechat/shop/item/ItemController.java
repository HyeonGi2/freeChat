/*--------------------------------------------------------------
* 작성자명 : 홍현기
* 수정일시 및 추가 내용
- 2026-01-14
1. 타임리프 error.html 파일 추가
2. REST API는 try/catch 또는 @ExceptionHandler 사용
3. ResponseEntity로 에러코드 전송하기
4. @PostMapping("/add") 비즈니스 로직을 서비스 레이어로 분리
* 오류발생1번(해결) - 오류 발생 이유
* @RequiredArgsConstructor가 생성자를 만들었으나 같은 생성자를 반복 생성하여 오류 발생
--------------------------------------------------------------*/

package org.mysite.freechat.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;
// 오류발생1번
//    @Autowired
//    public ItemController(ItemRepository itemRepository, ItemService itemService) {
//        this.itemRepository = itemRepository;
//        this.itemService = itemService;
//    }

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
    String addPost(@RequestParam String title, @RequestParam Integer price) {
//        Item item = new Item();
//        item.setTitle(title);
//        item.setPrice(price);
//        itemRepository.save(item);

        itemService.saveItem(title, price);
        return "redirect:/list";
    }
// 위에 내용 간략히 적용하기
//    @PostMapping("/add")
//    String addPost(@ModelAttribute Item item) {
//        System.out.println(item);
//        itemRepository.save(item);
//        return "redirect:/list";
//    }

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


    // 상품 상세페이지 api

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
//    String detail(@PathVariable Long id, Model model) throws  Exception {
//        throw new Exception();
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "detail.html";
        } else {
            return "redirect:/list";
        }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//            return ResponseEntity.status(400).body("오류");
// 서버오류는 500 유저오류는 400 정상 200 HTTP status code 가이드 참고
    }


    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable Long id) {

        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "edit.html";
        } else {
            return "redirect:/list";
        }

    }

    @PostMapping("/edit")
    String editItem(@RequestParam String title, @RequestParam Integer price, @RequestParam Long id) {

        Item item = new Item();
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect:/list";
    }



}


