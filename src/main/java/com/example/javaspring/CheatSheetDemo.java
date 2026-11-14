package com.example.javaspring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A tiny runnable demo of the Java Basics Cheat Sheet (sections 1-6).
 *
 * HOW TO RUN: open this file in VS Code and click "Run" above the main method.
 * Each section prints what it is showing, so read the console top to bottom.
 *
 * HOW TO DEBUG: click left of a line number to set a red dot (breakpoint),
 * then right-click "Debug" above main (or press F5) and step through.
 */
public class CheatSheetDemo {

    public static void main(String[] args) {
        section1Oop();
        section2Collections();
        section3Exceptions();
        section4LambdasAndStreams();
        section5Gotchas();
        section6SpringLayers();
    }

    // Small helpers so the output is easy to read.
    private static void title(String text) {
        System.out.println();
        System.out.println("==== " + text + " ====");
    }

    private static void show(String label, Object value) {
        System.out.println("  " + label + " -> " + value);
    }

    // =====================================================================
    // 1. OOP FUNDAMENTALS
    // =====================================================================

    // INTERFACE = a contract. Any class that "implements Testable" PROMISES
    // to have a runTest() method.
    interface Testable {
        boolean runTest();
    }

    // CLASS = a blueprint. Every Ticket made from it has a title.
    static class Ticket {

        // private = only this class can touch it. That is ENCAPSULATION:
        // outsiders must go through the methods below.
        private String title;

        // static = belongs to the CLASS itself, so ALL tickets share one count.
        private static int count = 0;

        Ticket(String title) {
            this.title = title;
            count++; // every new ticket adds 1 to the shared counter
        }

        String getTitle() {
            return title;
        }

        // Because the field is private, we get to protect it with a rule.
        void setTitle(String newTitle) {
            if (newTitle == null || newTitle.isBlank()) {
                throw new IllegalArgumentException("Title can't be empty");
            }
            this.title = newTitle;
        }

        static int getCount() {
            return count;
        }
    }

    // INHERITANCE = "extends": BugTicket gets everything Ticket has.
    // It also "implements" the Testable contract, so it MUST provide runTest().
    static class BugTicket extends Ticket implements Testable {

        BugTicket(String title) {
            super(title); // run the parent (Ticket) constructor first
        }

        @Override
        public boolean runTest() {
            return true;
        }
    }

    private static void section1Oop() {
        title("1. OOP FUNDAMENTALS");

        // OBJECT = one real thing built from the blueprint.
        Ticket plain = new Ticket("Add dark mode");
        Ticket bug = new BugTicket("Login fails");

        show("Object title (from the Ticket blueprint)", plain.getTitle());
        show("BugTicket inherited getTitle()", bug.getTitle());
        show("Static count shared by ALL tickets", Ticket.getCount());
        show("BugTicket keeps its promise: runTest()", ((BugTicket) bug).runTest());

        // Encapsulation in action: the setter refuses bad data.
        try {
            plain.setTitle("   ");
        } catch (IllegalArgumentException e) {
            show("Encapsulation blocked a blank title", e.getMessage());
        }

        // Access modifiers, quick reminder:
        //   public    = anyone can use it
        //   private   = only this class
        //   protected = this class and its subclasses
    }

    // =====================================================================
    // 2. COLLECTIONS
    // =====================================================================

    private static void section2Collections() {
        title("2. COLLECTIONS");

        // LIST = ordered, duplicates allowed. <String> (a "generic") means
        // this list can ONLY hold Strings.
        List<String> names = new ArrayList<>();
        names.add("Kevin");
        names.add("Kevin"); // duplicates are fine in a List
        names.add("Jane");
        show("List (ordered, keeps duplicates)", names);
        show("names.get(0)", names.get(0));

        // MAP = key -> value pairs (like a dictionary).
        Map<String, Integer> bugs = new HashMap<>();
        bugs.put("login", 3);
        bugs.put("checkout", 5);
        show("Map: bugs.get(\"login\")", bugs.get("login"));

        // SET = no duplicates allowed.
        Set<String> tags = new HashSet<>();
        tags.add("urgent");
        tags.add("urgent"); // second add is ignored
        show("Set (added 'urgent' twice, stored once)", tags);

        // For-each loop: "for every n in names, do this".
        System.out.println("  Looping through the list:");
        for (String n : names) {
            System.out.println("    " + n);
        }
    }

    // =====================================================================
    // 3. EXCEPTIONS
    // =====================================================================

    private static void section3Exceptions() {
        title("3. EXCEPTIONS");

        // try = "attempt this". catch = "if THIS error happens, do this instead".
        // finally = ALWAYS runs, error or not.
        try {
            Integer.parseInt("abc"); // not a number, so Java throws an error
            System.out.println("  (never printed, the line above failed)");
        } catch (NumberFormatException e) {
            show("WHAT broke (top line of a stack trace)", e.getClass().getSimpleName());
            show("Message", e.getMessage());

            // WHERE: in a real stack trace, find the first line with YOUR package name.
            for (StackTraceElement frame : e.getStackTrace()) {
                if (frame.getClassName().startsWith("com.example")) {
                    show("WHERE (first line with MY package)", frame);
                    break;
                }
            }
        } finally {
            System.out.println("  finally -> always runs");
        }

        // UNCHECKED exception: usually a bug in the code (the compiler does
        // not force you to catch it). Classic example: NullPointerException.
        String missing = null;
        try {
            missing.length(); // calling a method on "nothing"
        } catch (NullPointerException e) {
            show("Unchecked (a bug)", e.getClass().getSimpleName());
        }

        // CHECKED exception: the compiler FORCES you to handle it, because
        // things outside your code (files, network) can fail. Try removing
        // the try/catch below and watch the compiler complain.
        try {
            Files.readString(Path.of("no-such-file.txt"));
        } catch (IOException e) {
            show("Checked IOException handled (file is missing)", e.getClass().getSimpleName());
        }
    }

    // =====================================================================
    // 4. LAMBDAS + STREAMS
    // =====================================================================

    private static void section4LambdasAndStreams() {
        title("4. LAMBDAS + STREAMS");

        // LAMBDA = a short function with no name. "x -> x * 2" means
        // "given x, give back x times 2".
        List<Integer> scores = List.of(90, 55, 72, 40);

        // STREAM = a pipeline for processing a list, one step at a time:
        //   filter  = keep only some items
        //   map     = change each item
        //   collect = gather the results back into a list
        List<Integer> passing = scores.stream()
                .filter(s -> s >= 60)   // keep 90 and 72
                .map(s -> s + 5)        // add 5 curve points: 95 and 77
                .collect(Collectors.toList());
        show("Scores 60+, plus 5 points", passing);

        // OPTIONAL = a box that may or may not hold a value. It avoids
        // the dreaded NullPointerException.
        List<String> names = List.of("Kevin", "Jane", "Sam");

        Optional<String> startsWithJ = names.stream()
                .filter(n -> n.startsWith("J"))
                .findFirst();
        show("First name starting with J", startsWithJ.orElse("none"));

        Optional<String> startsWithZ = names.stream()
                .filter(n -> n.startsWith("Z"))
                .findFirst();
        show("First name starting with Z (nobody)", startsWithZ.orElse("none"));
    }

    // =====================================================================
    // 5. COMMON GOTCHAS
    // =====================================================================

    // A key that overrides BOTH equals() and hashCode(): works correctly.
    static class GoodKey {
        private final String id;

        GoodKey(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GoodKey)) {
                return false;
            }
            return id.equals(((GoodKey) other).id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    // Same thing but "forgot" hashCode(): HashSet and HashMap get confused.
    static class BadKey {
        private final String id;

        BadKey(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BadKey)) {
                return false;
            }
            return id.equals(((BadKey) other).id);
        }
        // hashCode() missing on purpose!
    }

    private static void section5Gotchas() {
        title("5. COMMON GOTCHAS");

        // == asks "are these the SAME object in memory?"
        // .equals() asks "do these have the SAME content?"
        String a = new String("hi");
        String b = new String("hi");
        show("a == b      (same object?)", a == b);
        show("a.equals(b) (same content?)", a.equals(b));

        // hashCode: if you override equals(), override hashCode() too.
        Set<GoodKey> good = new HashSet<>();
        good.add(new GoodKey("A"));
        good.add(new GoodKey("A"));
        show("equals + hashCode -> set size (correct: 1)", good.size());

        Set<BadKey> bad = new HashSet<>();
        bad.add(new BadKey("A"));
        bad.add(new BadKey("A"));
        show("equals only -> set size (wrong, usually 2)", bad.size());

        // Strings are IMMUTABLE: they never change. Methods give back a NEW one.
        String s = "test";
        s.toUpperCase(); // result thrown away, s is untouched
        show("After s.toUpperCase() alone, s is still", s);
        s = s.toUpperCase(); // catch the new String
        show("After s = s.toUpperCase(), s is", s);
    }

    // =====================================================================
    // 6. SPRING BOOT LAYERS + DEPENDENCY INJECTION
    // =====================================================================
    // In a real Spring Boot app each class below gets an annotation and
    // Spring builds them for you. Here we do it by hand (plain Java, no
    // Spring running) so you can SEE what Spring does behind the scenes.

    // REPOSITORY layer: talks to the database.
    // Real app: @Repository, usually "extends JpaRepository<Ticket, Long>".
    // Here the "database" is just a list in memory.
    static class TicketRepository {
        private final List<Ticket> database = new ArrayList<>();

        void save(Ticket ticket) {
            database.add(ticket);
        }

        List<Ticket> findAll() {
            return database;
        }
    }

    // SERVICE layer: the business logic.
    // Real app: @Service.
    static class TicketService {
        private final TicketRepository repo;

        // DEPENDENCY INJECTION: the Service does not build its own
        // repository with "new". It is HANDED one through the constructor.
        TicketService(TicketRepository repo) {
            this.repo = repo;
        }

        void create(String title) {
            repo.save(new Ticket(title));
        }

        List<Ticket> getAll() {
            return repo.findAll();
        }
    }

    // CONTROLLER layer: the front door that receives HTTP requests.
    // Real app: @RestController + @RequestMapping("/tickets").
    static class TicketController {
        private final TicketService service;

        TicketController(TicketService service) {
            this.service = service;
        }

        // Real app: @GetMapping, so GET /tickets runs this method.
        List<String> all() {
            return service.getAll().stream()
                    .map(t -> t.getTitle())
                    .collect(Collectors.toList());
        }
    }

    private static void section6SpringLayers() {
        title("6. SPRING BOOT LAYERS + DEPENDENCY INJECTION");

        // These three lines are the part Spring does FOR you. It creates each
        // object and passes it into the next one's constructor.
        TicketRepository repo = new TicketRepository();
        TicketService service = new TicketService(repo);
        TicketController controller = new TicketController(service);

        service.create("Fix login");
        service.create("Add search");

        // Pretend browser request: GET /tickets
        show("GET /tickets -> Controller -> Service -> Repository -> database", controller.all());
        // In the real app the list would come back to the browser as JSON.
    }
}
