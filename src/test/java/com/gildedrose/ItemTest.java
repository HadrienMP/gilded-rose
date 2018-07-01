package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {


    @Test
    public void backstage() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert",2,48);
        item.updateQuality();
        assertEquals(50,item.quality);
    }
}