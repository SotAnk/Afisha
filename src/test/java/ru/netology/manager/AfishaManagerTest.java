package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {

    @Test
    void getLastFilmsUpperLimit() {
        AfishaManager manager = new AfishaManager();
        Film one = new Film(1, "one", "action");
        Film two = new Film(2, "two", "cartoon");
        Film three = new Film(3, "three", "comedy");
        Film four = new Film(4, "four", "action");
        Film five = new Film(5, "five", "horror");
        Film six = new Film(6, "six", "comedy");
        Film seven = new Film(7, "seven", "western");
        Film eight = new Film(8, "eight", "drama");
        Film nine = new Film(9, "nine", "action");
        Film ten = new Film(10, "ten", "thriller");
        Film eleven = new Film(11, "eleven", "comedy");

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);

        Film[] actual = manager.getLastFilms();
        Film[] expected = new Film[]{eleven, ten, nine, eight, seven,six, five, four, three, two};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastFilmsIsLimit() {
        AfishaManager manager = new AfishaManager();
        Film one = new Film(1, "one", "action");
        Film two = new Film(2, "two", "cartoon");
        Film three = new Film(3, "three", "comedy");
        Film four = new Film(4, "four", "action");
        Film five = new Film(5, "five", "horror");
        Film six = new Film(6, "six", "comedy");
        Film seven = new Film(7, "seven", "western");
        Film eight = new Film(8, "eight", "drama");
        Film nine = new Film(9, "nine", "action");
        Film ten = new Film(10, "ten", "thriller");

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);

        Film[] actual = manager.getLastFilms();
        Film[] expected = new Film[]{ten, nine, eight, seven,six, five, four, three, two, one};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastFilmsUnderLimit() {
        AfishaManager manager = new AfishaManager();
        Film one = new Film(1, "one", "action");
        Film two = new Film(2, "two", "cartoon");
        Film three = new Film(3, "three", "comedy");
        Film four = new Film(4, "four", "action");
        Film five = new Film(5, "five", "horror");

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);


        Film[] actual = manager.getLastFilms();
        Film[] expected = new Film[]{five, four, three, two, one};
        assertArrayEquals(expected, actual);
    }

    @Test
    void addFilm() {
        AfishaManager manager = new AfishaManager();
        Film one = new Film(1, "one", "action");
        Film two = new Film(2, "two", "cartoon");

        manager.add(one);
        manager.add(two);

        Film[] expected = new Film[]{two,one};
        Film[] actual = manager.getLastFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastFilmChangeCountMovies() {
        AfishaManager manager = new AfishaManager(4);

        Film one = new Film(1, "one", "action");
        Film two = new Film(2, "two", "cartoon");
        Film three = new Film(3, "three", "comedy");
        Film four = new Film(4, "four", "action");
        Film five = new Film(5, "five", "horror");

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        Film[] actual = manager.getLastFilms();
        Film[] expected = new Film[]{five, four, three, two};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void NoArg() {
        AfishaManager manager = new AfishaManager();
        Film one = new Film();
        Film[] actual = manager.getLastFilms();
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, actual);
    }
}