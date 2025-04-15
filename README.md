# Mia's Vehicle Vending Machine

This was my **very first "big" programming project** for the final assignment of my intro to programming class!

## Overview

**Mia's Vehicle Vending Machine** is a Java program that lets users select a vehicle from a list, then visually "moves" the chosen vehicle down a vending machine-style display using a 2D array and a bit of animation with delays.

- Users choose from a list of vehicles stored in a file.
- The program checks for valid input (no numbers, must match available vehicle names).
- The chosen vehicle is shown "dropping" down through a visual display.
- The process repeats for three users.

## Features

- Uses a **multidimensional array** to hold and manipulate vehicle data.
- Reads data from a text file (`ourVehicles.txt`).
- Handles user input and validates it.
- Animates vehicle movement using `TimeUnit.SECONDS.sleep(...)`.
- Has a clear, friendly, and fun user interface in the console!

## File Structure

- `Main.java` — the main Java source file containing all logic.
- `ourVehicles.txt` — a text file containing vehicle names (one per line, comma-separated).

### Example format for `ourVehicles.txt`:
```
Honda,Civic
Tesla,Model 3
Toyota,Camry
Ford,Explorer
Hyundai,Santa Fe
Subaru,Crosstrek
BMW,3 Series
Chevrolet,Hatchback
Lexus,ES Hybrid
Kia,Telluride
```

## How to Run

1. **Make sure you have Java installed** on your system.
2. Save `Main.java` and `ourVehicles.txt` in the same folder.
3. Compile and run:

```
javac Main.java
java Main
```

4. Since this was my first project, there is minimal error handling. The program may not run smoothly if it encounters unexpected user input or other issues it wasn’t designed to handle. Please be kind — it’s a beginner's project!

5. Follow the prompts and enjoy your vending machine experience!

## What I Learned

- Reading files with `Scanner`
- Using arrays (especially 2D arrays)
- Loops, conditionals, and input validation
- Basic animation with console output
- Making programming fun and interactive!

## Credits

Project by **Mia Palmer**  
Created as part of my final homework project in CS119: Intro to Programming at FRCC — thanks for checking it out!
