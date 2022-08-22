package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        String test = persons.get(0).getSurname();
        assertThat(test, is(("Arsentev")));
    }

    @Test
    public void whenNotFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Dmitriy", "Lukin", "829032", "Moscow")
        );
        ArrayList<Person> persons = phones.find("213");
        for (Person phone1 : persons) {
            assertThat(persons, is(phone1));
        }
    }
}