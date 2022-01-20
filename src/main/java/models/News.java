package models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class News {
    private int id;
    private String title;
    private String description;
    private String author;
    private int categoryId;
}
