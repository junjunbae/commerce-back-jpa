package com.ex.commercetestbackjpa.domain.dto.comment;

import com.ex.commercetestbackjpa.domain.entity.comment.Comment;
import com.ex.commercetestbackjpa.domain.entity.product.Product;
import com.ex.commercetestbackjpa.domain.entity.product.ProductDT;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

public class CommentDTO {

    @Getter
    @Setter
    public static class Request {

        private Long commnetNo;

        private String title;

        private String content;

        private Integer grade;

        private Boolean deleteYn;

        private Long custNo;

        private Long orderNo;

        private Long likes;

        private Long productNo;

        public Comment toEntity() {
            return Comment.builder()
                    .title(this.title)
                    .content(this.content)
                    .grade(this.grade)
                    .deleteYn(this.deleteYn)
                    .likes(this.likes)
                    .build();
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class Response {

        private Long commnetNo;

        private String title;

        private String content;

        private Integer grade;

        private Boolean deleteYn;

        private Long custNo;

        private Long orderNo;

        private Long likes;

        private Long productNo;

        public Response(Comment comment) {
            this.commnetNo = comment.getCommnetNo();
            this.title = comment.getTitle();
            this.content = comment.getContent();
            this.grade = comment.getGrade();
            this.likes = comment.getLikes();
        }

    }

}