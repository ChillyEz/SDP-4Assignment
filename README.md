# Home Theater Facade (Java)

Small Java project showing the **Facade** pattern for a home theater system.

## Structure
- `facade/HomeTheaterFacade.java` — simplified API: `watchMovie(...)`, `endMovie()`
- `subsystem/*` — independent subsystem classes (`Amplifier`, `DvdPlayer`, `Projector`, `Screen`, `TheaterLights`, `PopcornPopper`)
- `Main.java` — client that uses only the facade

- ![Схема проекта](UML.svg)

## Clean Code (6 strongest examples)
1. **Meaningful names**
   - Before: `dimmingLight()`, `changeSurroundSound()`
   - After: `dimLights()`, `toggleSurroundSound()`

2. **Single Responsibility Principle**
   - `HomeTheaterFacade` coordinates startup/shutdown order.
   - Subsystems keep their own logic (volume, disc control, lighting, etc.).

3. **No duplication (DRY)**
   - Repeated power checks were extracted to helper methods like `ensurePoweredOn(...)` in subsystem classes.

4. **Small focused methods**
   - Complex flow is split into `watchMovie(...)`, `endMovie()`, `safeShutdown()`, `executeSafely(...)` in facade.

5. **Defensive programming / error handling**
   - Facade validates input movie name and performs safe rollback (`safeShutdown`) if startup flow fails.

6. **Encapsulation and low coupling**
   - Client code uses only `HomeTheaterFacade`.
   - Subsystem classes do not depend on or know about the facade.

## Run
Compile and run from repository root:

```bash
javac Main.java facade/*.java subsystem/*.java
java Main
```
