package com.gildedrose;

import org.junit.Test;
import org.lambda.functions.Function3;

import java.util.stream.IntStream;

import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

public class GildedRoseRegressionTest {
    @Test
    public void regression_cover() throws Exception {
        String[] names = new String[]{
                "Foo",
                "Aged Brie",
                "Backstage passes to a TAFKAL80ETC concert",
                "Sulfuras, Hand of Ragnaros"
        };

        Integer[] qualities = IntStream.range(-1, 80)
                                       .boxed()
                                       .toArray(Integer[]::new);

        Integer[] sellIns = IntStream.range(-1, 80)
                                     .boxed()
                                     .toArray(Integer[]::new);

        verifyAllCombinations(call, names, sellIns, qualities);
    }

    private static final Function3<String, Integer, Integer, String> call = (name, sellIn, quality) -> {
        Item item = new Item(name, sellIn, quality);
        new GildedRose(new Item[]{item}).updateQuality();
        return item.toString();
    };
}
