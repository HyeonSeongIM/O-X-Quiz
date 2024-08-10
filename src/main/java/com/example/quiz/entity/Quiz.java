package com.example.quiz.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/** 퀴즈 테이블용 : entity */

@Data // setter getter
@NoArgsConstructor // 생성자 주입
@AllArgsConstructor // 인수 생성
public class Quiz {
    /** 식별 ID */
    @Id
    private Integer id;

     /** 퀴즈 내용 */
     private String question;

     /** 퀴즈 답 */
     private boolean answer;

     /** 작성자 */
     private String author;

    public Object getAnswer() {
        return answer;
    }
}
