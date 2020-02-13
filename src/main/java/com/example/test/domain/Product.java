package com.example.test.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String maker;

    @Setter
    @Getter
    private Integer price;

    @Setter
    @Getter
    private String imageUrl;


    public String getImageUrl() {
        return this.imageUrl == null ? "" : imageUrl;
    }

    public void changeImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
