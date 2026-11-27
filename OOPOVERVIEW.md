# Java OOP Overview (using the dessert package)

## The big idea
`main` is the starting point. It does not do all the work itself. It **creates objects** and **calls their methods**.
The real work lives in separate classes, enums, and interfaces. Each piece has one job, which keeps the program
organized and easy to change.

In this package, `DessertDemo.main()` creates a `Cake` and calls `describe()`. The details of what a cake is
live in `Cake`, `Dessert`, `Bakeable`, and `Size`.

## How the files fit together

```
Bakeable (interface)     -> the rule: "you must have a bake() method"
   ^ implements
Dessert (abstract class) -> shared field: flavor; leaves bake() for subclasses to write
   ^ extends
Cake (class)             -> real cake: slices, size, its own bake() and describe()
   uses
Size (enum)              -> fixed choices: SMALL, MEDIUM, LARGE, EXTRA_LARGE

DessertDemo.main()       -> starts the program, creates a Cake, calls its methods
```

## The building blocks

| Piece | What it is | In this package |
|---|---|---|
| Class | A blueprint | `Cake` |
| Object (instance) | A real thing built from the blueprint with `new` | `Cake birthdayCake = new Cake("Chocolate", 8, Size.LARGE);` |
| Field | Data the object holds | `flavor` (in Dessert), `slices` and `size` (in Cake) |
| Constructor | Sets up a new object when it is created | `public Cake(String flavor, int slices, Size size)` |
| Method | Something the object does | `bake()`, `describe()` |
| Enum | A fixed set of choices | `Size` |
| Interface | A contract: "anything that implements me must have these methods" | `Bakeable` |
| Abstract class | A partial blueprint that can't be created with `new`; only extended | `Dessert` |

## The 4 pillars of OOP

1. **Encapsulation**: keep data protected and expose it through methods.
   `Cake`'s `slices` and `size` are `private`, so only `Cake` can change them directly.
2. **Inheritance**: a class builds on another with `extends`.
   `Cake extends Dessert`, so Cake gets `flavor` without redefining it. `super(flavor)` calls Dessert's constructor.
3. **Polymorphism**: one type, many forms.
   `Dessert d = new Cake("Vanilla", 6, Size.SMALL);` works because a Cake IS a Dessert.
   Calling `d.bake()` runs Cake's version of `bake()`. A future `Pie extends Dessert` would run Pie's version.
4. **Abstraction**: hide the details, show only what's needed.
   `Bakeable` and `Dessert` say a dessert must be able to `bake()`, without saying how.

## Program flow

```
main()  ->  new Cake(...)        ->  Cake constructor runs, calls super(flavor) to set Dessert's flavor
        ->  birthdayCake.describe()  ->  returns "Chocolate cake, 8 slices"
        ->  System.out.println(...)  ->  prints it
```

## Why this matters for Spring
Spring is OOP all the way down: a controller calls a service, a service calls a repository.
Same idea as `main` calling `Cake`, except Spring creates the objects for you (dependency injection)
instead of you writing `new`. See `Calculator` and `Greeter` in LessonOne.
