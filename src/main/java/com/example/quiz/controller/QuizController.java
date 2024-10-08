package com.example.quiz.controller;

import com.example.quiz.entity.Quiz;
import com.example.quiz.form.QuizForm;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    /** DI 대상 */
    @Autowired
    QuizService service;

    /** form-backing bean의 초기화 */
    @ModelAttribute
    public QuizForm setUpForm() {
        QuizForm form = new QuizForm();
        // 라디오 버튼의 초깃값 생성
        form.setAnswer(true);
        return form;
    }

    /** Quiz 목록 표시 */
    @GetMapping
    public String showList(QuizForm form, Model model) {
        // 신규 등록 설정
        form.setNewQuiz(true);

        // 퀴즈 목록 취득
        Iterable<Quiz> list = service.selectAll();

        // 표시용 모델에 저장
        model.addAttribute("list", list);
        model.addAttribute("title", "등록 폼");

        return "crud";
    }
}
