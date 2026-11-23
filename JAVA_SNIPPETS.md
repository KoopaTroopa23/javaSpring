# Java Snippets Reference (VS Code)

Snippets live in this repo at `.vscode/java.code-snippets` (workspace snippets,
scoped to this project). Tab-completion is enabled via `.vscode/settings.json`
(`"editor.tabCompletion": "on"`), so typing the prefix and pressing `Tab`
expands it directly — no need to pick from the suggestion popup first.

Use `Tab` to jump between placeholder fields (`$1`, `$2`, ...) after expansion.

## Output

| Prefix  | Expands to                     | Description        |
|---------|---------------------------------|---------------------|
| `sout`  | `System.out.println();`         | Print to console    |
| `soutp` | `System.out.print();`           | Print, no newline   |
| `soutf` | `System.out.printf("%n");`      | Formatted print     |
| `serr`  | `System.err.println();`         | Print to error stream |

## Methods / Entry Points

| Prefix | Expands to                                    | Description |
|--------|-------------------------------------------------|--------------|
| `psvm` | `public static void main(String[] args) { }`    | Main method  |
| `psf`  | `private static final type NAME = value;`       | Constant field |

## Control Flow

| Prefix | Expands to                                  | Description     |
|--------|-----------------------------------------------|-------------------|
| `fori` | `for (int i = 0; i < length; i++) { }`        | Indexed for loop   |
| `iter` | `for (Type item : collection) { }`            | For-each loop       |
| `whil` | `while (condition) { }`                       | While loop           |
| `ifn`  | `if (condition) { }`                          | If block               |
| `ife`  | `if (condition) { } else { }`                 | If/else block            |
| `tryc` | `try { } catch (Exception e) { }`             | Try/catch                  |

## Collections

| Prefix | Expands to                                      | Description         |
|--------|---------------------------------------------------|----------------------|
| `nal`  | `List<Type> name = new ArrayList<>();`            | New ArrayList         |
| `nhm`  | `Map<Key, Value> name = new HashMap<>();`         | New HashMap            |

## OOP / Boilerplate

| Prefix  | Expands to                                  | Description     |
|---------|------------------------------------------------|-------------------|
| `clas`  | `public class FileName { }`                    | Class declaration  |
| `cons`  | `public FileName(...) { }`                      | Constructor          |
| `todo`  | `// TODO: `                                     | TODO comment           |

## Managing Snippets

- Edit directly: `.vscode/java.code-snippets` in this repo.
- Or via Command Palette: `Ctrl+Shift+P` → "Snippets: Configure User Snippets" → pick this workspace's snippet file.
- These are workspace-scoped (this project only). For snippets available in every project, add them instead to the global user snippets file via the same Command Palette path, choosing "New Global Snippets file".
- Built-in Java extension snippets may also exist with overlapping prefixes; these workspace snippets take precedence.
