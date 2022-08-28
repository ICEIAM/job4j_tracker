package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UniqueTextTest {
    @Test
    public void isEquals() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "My cat eats a mouse";
        boolean rsl = true;
        assertThat(uniqueText.isEquals(origin, text), is(rsl));
    }

    @Test
    public void isNotEquals() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        boolean rsl = false;
        assertThat(uniqueText.isEquals(origin, text), is(rsl));
    }
}
