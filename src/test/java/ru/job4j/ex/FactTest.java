package ru.job4j.ex;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenNLess0() {
        Fact.calc(-1);
    }

    @Test
    public void whenNLess0second() {
        int rsl = Fact.calc(2);
        assertThat(rsl, is(2));
    }
}