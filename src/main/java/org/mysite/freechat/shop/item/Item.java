package org.mysite.freechat.shop.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String title;
    private Integer price;
    @Column(nullable = false)
    private Integer stock = 0; // 기본값

//    public String toString() {
//        return this.title + this.price;
//    }
}
