package org.mysite.freechat.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/main/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/list")
    @ResponseBody
    public List<Article> showList() {
        return articleRepository.findAll();
    }

    // 게시물 단건 조회
    @RequestMapping("/detail")
    @ResponseBody
    public Article showOneArticle(@RequestParam long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null);
    }

    // 게시물 수정
    @RequestMapping("/edit")
    @ResponseBody
    public Article editArticle(long id, String title, String body) {
        Article article = articleRepository.findById(id).get();
        if (title != null) {
            article.setTitle(title);
        }

        if (body != null) {
            article.setBody(body);
        }

            articleRepository.save(article);

            return article;
        }

        // 게시물 삭제
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteArticle(long id) {

        if (articleRepository.existsById(id) == false) {
            return "%d번 게시물은 이미 삭제되었거나 존재하지 않습니다.".formatted(id);
        }

        articleRepository.deleteById(id); //삭제
        return "%d번 게시물이 삭제되었습니다.".formatted(id);
    }
}


