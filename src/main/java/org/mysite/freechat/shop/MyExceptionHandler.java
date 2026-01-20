/*--------------------------------------------------------------
* 작성자명 : 홍현기
* 수정일시 및 추가 내용
* 2026-01-14
- 모든 Controller 파일의 에러 확인을 위해 MyExceptionHandler.java 파일 생성
  특정 오류 상황에서의 ResponseEntity 내용 추가 (MethodArgumentNotValidException)
*


--------------------------------------------------------------*/
package org.mysite.freechat.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> apiHandler() {
        return ResponseEntity.status(400).body("오류발생22");
    }
//    특정 오류 상황
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> handler1() {
//        return ResponseEntity.status(400).body("오류발생33");
//    }


//
    @ExceptionHandler(Exception.class)
    public String viewHandler(Model model) {
        model.addAttribute("message", "시스템 오류");
        return "error";
    }


}

