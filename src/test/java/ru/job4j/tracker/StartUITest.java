package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class StartUITest {
    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StabOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "New Test Name", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void showAllActionSuccessfully() {
        Output out = new StabOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        UserAction[] actions = new UserAction[]{
                new ShowAction(out),
                new Exit(out)
        };
        Input in = new StubInput(
                new String[]{"0", "1"});
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Show all items ===" + System.lineSeparator()
                        + one + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findByNameActionSuccessfully() {
        Output out = new StabOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test"));
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(out),
                new Exit(out)
        };
        Input in = new StubInput(
                new String[]{"0", "test", "1"});
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find items by name ===" + System.lineSeparator()
                        + one + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findByIdActionSuccessfully() {
        Output out = new StabOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Just an item"));
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(out),
                new Exit(out)
        };
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"});
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find item by id ===" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StabOutput();
        Input in = new StubInput(
                new String[] {"8", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu." + ln
                                + "0. Exit" + ln
                                + "Wrong input, you can select: 0 - 0" + ln
                                + "Menu." + ln
                                + "0. Exit" + ln
                )
        );
    }

}
