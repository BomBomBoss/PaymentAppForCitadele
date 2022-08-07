package com.paymentapp.paymentappforcitadele.repository;

import com.paymentapp.paymentappforcitadele.models.Book;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookRepository {
   private Set<Book> classicBooks = new HashSet<>();
   private Set<Book> autobiographyBooks = new HashSet<>();
   private Set<Book> romanceBooks = new HashSet<>();
   private Set<Book> adventureBooks = new HashSet<>();

   private Map<String,Set<Book>> booksDB = new HashMap<>();

    {
        classicBooks.addAll(Arrays.asList(new Book("War and Peace", "Leo Tolstoy", 1869,"The novel chronicles the French invasion of Russia and the impact of the Napoleonic era on Tsarist society through the stories of five Russian aristocratic families"),
                new Book("Crime and Punishment","Fyodor Dostoevsky",1866,"Crime and Punishment follows the mental anguish and moral dilemmas of Rodion Raskolnikov, an impoverished ex-student in Saint Petersburg who plans to kill an unscrupulous pawnbroker, an old woman who stores money and valuable objects in her flat"),
                new Book("Les Misérables","Victor Hugo",1862,"Set in the Parisian underworld and plotted like a detective story, the work follows the fortunes of the convict Jean Valjean, a victim of society who has been imprisoned for 19 years for stealing a loaf of bread")));

        autobiographyBooks.addAll(Arrays.asList(new Book("Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future", "Ashlee Vance", 2017,"In the spirit of Steve Jobs and Moneyball, Elon Musk is both an illuminating and authorized look at the extraordinary life of one of Silicon Valley's most exciting, unpredictable, and ambitious entrepreneurs--a real-life Tony Stark--and a fascinating exploration of the renewal of American invention and its new makers"),
                new Book("Losing My Virginity: How I Survived, Had Fun, and Made a Fortune Doing Business My Way", "Richard Branson",2011, "The unusual, frequently outrageous autobiography of one of the great business geniuses of our time, Richard Branson"),
                new Book("I Forgot to Die", "Khalil Rafati",2015,"Khalil Rafati went to Los Angeles in the 1990s and had it all. He was working with Hollywood movie stars and legendary rock musicians, but it wasn t long before he found his way into the dark underbelly of the City of Angel")));

        romanceBooks.addAll(Arrays.asList(new Book("Pride and Prejudice", "Jane Austen", 1813, "Austen's most popular novel, the unforgettable story of Elizabeth Bennet and Mr. Darcy. Nominated as one of America's best-loved novels by PBS's The Great American Read"),
                new Book("The Notebook", "Nicholas Sparks", 1996, "Experience the unforgettable, heartbreaking love story set in post-World War II North Carolina about a young socialite and the boy who once stole her heart"),
                new Book("Jane Eyre", "Charlotte Bronte", 1847, "A beloved classic and undisputed masterpiece, Charlotte Brontë's Jane Eyre explores class, society, love and religion through the eyes of one of fiction's most unique and memorable female protagonist")));

        adventureBooks.addAll(Arrays.asList(new Book("Don Quixote", "Miguel de Cervantes", 1605, "The plot revolves around the adventures of a member of the lowest nobility, an hidalgo from La Mancha named Alonso Quijano"),
                new Book("The Three Musketeers", "Alexandre Dumas", 1844,"Set between 1625 and 1628, it recounts the adventures of a young man named d'Artagnan (a character based on Charles de Batz-Castelmore d'Artagnan) after he leaves home to travel to Paris, hoping to join the Musketeers of the Guard"),
                new Book("Journey to the Center of the Earth", "Jules Verne", 1864, "Professor Otto Lidenbrock is the tale's central figure, an eccentric German scientist who believes there are volcanic tubes that reach to the very center of the earth")));

        booksDB.put("classic", classicBooks);
        booksDB.put("autobiography", autobiographyBooks);
        booksDB.put("romance", romanceBooks);
        booksDB.put("adventure", adventureBooks);
    }


    public BookRepository() {
    }

    public Set<Book> getClassicBooks() {
        return classicBooks;
    }

    public Set<Book> getAutobiographyBooks() {
        return autobiographyBooks;
    }

    public Set<Book> getRomanceBooks() {
        return romanceBooks;
    }

    public Set<Book> getAdventureBooks() {
        return adventureBooks;
    }

    public Map<String, Set<Book>> getBooksDB() {
        return booksDB;
    }
}
