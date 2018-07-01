package com.gildedrose;

public class Item {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SELLIN = 0;
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BRIE = "Aged Brie";

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void updateQuality() {
        if (!name.equals(BRIE)
                && !name.equals(BACKSTAGE)) {
            if (!name.equals(SULFURAS)) {
                decrementQuality();
            }
        } else {
            incrementQuality();

            if (name.equals(BACKSTAGE)) {
                if (sellIn < 11 && sellIn >= 6) {
                    incrementQuality();
                } else if (sellIn < 6) {
                    incrementQuality(2);
                }
            }
        }

        if (!name.equals(SULFURAS)) {
            sellIn = sellIn - 1;
        }

        if (sellIn < MIN_SELLIN) {
            if (name.equals(SULFURAS)) {
                return;
            }
            if (name.equals(BRIE)) {
                incrementQuality();
            } else if (name.equals(BACKSTAGE)) {
                resetQuality();
            } else {
                decrementQuality();
            }
        }
    }

    private void resetQuality() {
        quality = 0;
    }

    private void decrementQuality() {
        if (quality > MIN_QUALITY) {
            quality--;
        }
    }

    private void incrementQuality() {
        incrementQuality(1);
    }

    private void incrementQuality(int increment) {
        quality += increment;
        if (quality > MAX_QUALITY) {
            quality = MAX_QUALITY;
        }

    }
}
