package api.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponseDto {

    private String userId;
    private String username;
    private List<Book> books;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Book {
        private String isbn;
        private String title;
        private String subTitle;
        private String author;
        private Date publish_date;
        private String publisher;
        private int pages;
        private String description;
        private String website;
    }
}
