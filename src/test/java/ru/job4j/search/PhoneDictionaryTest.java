package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        var test = persons.get(0).getSurname();
        assertThat(test, is(("Arsentev")));
    }

    @Test
    public void whenNotFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Dmitriy", "Lukin", "829032", "Moscow")
        );
        ArrayList<Person> persons = phones.find("213");
        assertTrue(persons.isEmpty());
    }
}