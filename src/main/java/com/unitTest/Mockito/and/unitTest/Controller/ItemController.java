package com.unitTest.Mockito.and.unitTest.Controller;

import com.unitTest.Mockito.and.unitTest.Model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    private Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
