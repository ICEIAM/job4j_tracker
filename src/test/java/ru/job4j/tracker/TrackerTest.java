package ru.job4j.tracker;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
@Disabled
    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Disabled
    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Disabled
    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(first.getName()).toArray(new Item[0]);
        assertThat(result.length, is(3));
    }

    @Disabled
    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(second.getName()).toArray(new Item[0]);
        assertThat(result[1].getName(), is(second.getName()));
    }

    @Disabled
    @Test
    public void whenReplace() {
        ArrayList<Item> items = new ArrayList<>();
        Tracker tracker = new Tracker();
        Item bug = new Item();
        int id = bug.getId();
        bug.setName("Bug");
        items.add(bug);
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Disabled
    @Test
    public void whenDelete() {
    ArrayList<Item> items = new ArrayList<>();
    Item test1 = new Item();
    int id = test1.getId();
    items.add(test1);
    Tracker tracker = new Tracker();
    tracker.delete(id);
    assertThat(tracker.findById(id), is(nullValue()));
    }
}