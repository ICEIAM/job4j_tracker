package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemDescByNameTest  {
    @Test
    public void itemAskByName() {
        Item one = new Item(1, "1");
        Item two = new Item(2, "2");
        Item three = new Item(3, "3");
        Item four = new Item(4, "4");
        List<Item> items = new ArrayList<Item>();
        items.add(one);
        items.add(three);
        items.add(four);
        items.add(two);
        List<Item> expect = new ArrayList<>();
        expect.add(one);
        expect.add(two);
        expect.add(three);
        expect.add(four);
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expect));
    }

    @Test
    public void itemDescByName() {
        Item one = new Item(1, "1");
        Item two = new Item(2, "2");
        Item three = new Item(3, "3");
        Item four = new Item(4, "4");
        List<Item> items = new ArrayList<Item>();
        items.add(one);
        items.add(three);
        items.add(four);
        items.add(two);
        List<Item> expect = new ArrayList<>();
        expect.add(four);
        expect.add(three);
        expect.add(two);
        expect.add(one);
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expect));
    }
}
