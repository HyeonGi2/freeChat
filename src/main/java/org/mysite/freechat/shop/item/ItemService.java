/*--------------------------------------------------------------
* 작성자명 : 홍현기
* 수정일시 및 추가 내용
- 2026-01-14
1. ItemController의 @PostMapping("/add") 비즈니스 로직을 서비스 레이어로 분리
--------------------------------------------------------------*/
package org.mysite.freechat.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }
//    saveItem("이름", 321321);
}
