# bogosort
biggerfile.csv: has raw statistics of element sizes 11 and 13

file.csv: has raw statistics of element sizes 3,4,5,6 and 10

time is in nanoseconds

# 🃏 BogoSort in Java

This project implements the **BogoSort** algorithm — a highly inefficient sorting method that randomly shuffles an array until it becomes sorted. It demonstrates algorithm performance by measuring time and loop count, and logs the results to a CSV file.

---

## 📦 Requirements

- Java 8 or newer
- [OpenCSV](http://opencsv.sourceforge.net/) library

To download OpenCSV:
https://repo1.maven.org/maven2/com/opencsv/opencsv/5.7.1/opencsv-5.7.1.jar

## ⚙️ Configuration

You can customize the program by editing two key parts of the `bogosort.java` file:


### 🔁 1. `samplesize` — Number of Test Runs Per Array Size

This value determines how many times **each array size** will be tested.  
Default is `1`. You can increase it for more accurate benchmarks.

**Location in code:**

```java
final int samplesize = 1;
```

📏 2. arr[][] — Array Sizes to Sort

This 2D array defines the sizes of the integer arrays that will be tested with BogoSort.
Each new int[n] creates an array of size n.

Default code:
```java
int[][] arr = { new int[13] };
```
To test multiple sizes:
Replace with something like this:

```java
int[][] arr = {
    new int[10],
    new int[11],
    new int[12],
    new int[13]
};
```
This configuration will test BogoSort on arrays of sizes 10, 11, 12, and 13 — each samplesize times.

✅ Example Configuration

final int samplesize = 3;

int[][] arr = {
    new int[10],
    new int[11],
    new int[12]
};

This setup runs BogoSort 3 times for each of the array sizes 10, 11, and 12.

## 📤 Output

After running the program, a CSV file named `filetest.csv` is created (or updated) in the project directory. This file logs the performance of BogoSort for each test run.

### 🧾 CSV Format

The file has the following columns:

| array length | loops       | real time (ns)     |
|--------------|-------------|--------------------|
| 10           | 3,011,501   | 1,150,000,000      |
| 11           | 14,112,591  | 5,058,000,000      |
| 13           | 1,432,657,472 | 1,289,400,000,000 |

- **array length**: The size of the array that was sorted.
- **loops**: The number of times the array was shuffled before it became sorted.
- **real time (ns)**: The total time taken for sorting in nanoseconds.

> 📁 If the file already exists, new data will be appended to the end.

---

### 🕓 Console Output

In addition to the CSV file, the program also prints the real system start and end times to the console:

