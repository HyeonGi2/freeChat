//package org.mysite.freechat.question;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Controller
//public class QuestionController {
//
//    private final QuestionRepository questionRepository;
//
//
//    @GetMapping("/question/list")
//    public String list(Model model) {
//        List<Question> questionList = this.questionRepository.fineAll();
//        model.addAttribute("questionList", questionList);
//        return "question_list";
//    }
//}
