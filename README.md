# String Calculator - TDD Assessment

This project is a solution to the **Incubyte TDD Assessment**. It implements a **String Calculator** using **Java**, following the principles of **Test-Driven Development (TDD)** and clean code.

---

## Problem Statement

Implement a `StringCalculator` with a method:

```java
int add(String numbers)
```

---

##  Features

- Returns 0 for an empty string
- Returns the number itself if only one number is passed
- Supports comma `,` and newline `\n` delimiters
- Supports **custom delimiters** of any length (e.g. `//[***]\n1***2`)
- Supports **multiple custom delimiters** (e.g. `//[*][%]\n1*2%3`)
- Throws a `NumberFormatException` for inputs ending with a delimiter (e.g. `"1,2,"`)
- Throws an `IllegalArgumentException` listing all **negative numbers** and also for **malformed custom delimiters**

---

## Test Cases

All features are covered with unit tests using JUnit 5 and AssertJ.

You can find them in:
```src/test/java/com/diya/stringcalculator/StringCalculatorTest.java```

### Example Inputs and Outputs:
| Input                   | Output / Exception |
|------------------------|--------------------|
| `""`                   | `0`                |
| `"1"`                  | `1`                |
| `"1,2"`                | `3`                |
| `"1\n2,3"`             | `6`                |
| `"//[***]\n1***2***3"` | `6`                |
| `"//[*][%]\n1*2%3"`    | `6`                |
| `"1,2,"`               | `NumberFormatException` |
| `"1,-2\n-4"`           | `IllegalArgumentException: Negative numbers not allowed: -2,-4` |
| `"//[**\n1**2"`          | `IllegalArgumentException: Invalid custom delimiter format` |


---

## Tech Stack
- Java 21
- JUnit 5
- AssertJ (for fluent assertions)
- Maven
- IntelliJ IDEA (recommended)

## How to Run Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/diyaprajapati/string-calculator-tdd

---

## Author

**Diya Prajapati**  
- GitHub: [@diyaprajapati](https://github.com/diyaprajapati)
- Email: `diyabprajapati2005@gmail.com`
