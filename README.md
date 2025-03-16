# Analyzer Project

This project analyzes sorting algorithms (Bubble Sort, Quick Sort, Comb Sort) with different input sizes and classifies them based on their swap count.

## Prerequisites

Ensure that you have the following software installed:
- JDK 21 (or higher)
- Maven

## Clone the repository

To get started, clone the project:

```bash
git clone https://github.com/Mbsqd/analyzer
cd analyzer
```

# Build the project

To compile the project, run the following Maven command:

```bash
mvn clean package
```
# Execute the program

To run the program, execute the following command with the required parameters:

```bash
java -jar ./target/analyzer-1.0-SNAPSHOT.jar <min> <max> <start> <end> <step> <sampling>
```

## Parameters:
- **`<min>`**: Minimum input data for the sorting algorithms.
- **`<max>`**: Maximum input data for the sorting algorithms.
- **`<start>`**: Start of the range for sorting algorithm execution.
- **`<end>`**: End of the range for sorting algorithm execution.
- **`<step>`**: Step size for the range.
- **`<sampling>`**: Number of times the sorting algorithm will be sampled.

## Example:
```bash
java -jar ./target/analyzer-1.0-SNAPSHOT.jar 0 1000 0 1000 100 5
```
This command will analyze sorting algorithms on input sizes from 0 to 1000 with specified parameters.
