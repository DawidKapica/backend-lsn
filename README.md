# LSN Recruitment
Solution to recruitment tasks for LSN. 

## General information

This repository contains solutions to the recruitment tasks for LSN. Each task is implemented within a single application, and Maven has been chosen as the build automation tool. Specific logic for each task resides in a folder named after the task, and utility classes that can be reused across multiple tasks are placed in the util folder.
For all tasks, comprehensive tests have been prepared to ensure the correctness of the code.
The application allows execution with data from files or data provided via standard input.

### Compilation
To compile the application, use Maven with the following command:

```
mvn clean install
```

## Task1
### Description
Given a list of integers, the application identifies distinct elements, sorts them, and generates information about the number of elements, the number of distinct elements, the minimum value, and the maximum value.
For example, given the input data:
```
1 10 20 20 2 5
```
The expected output is:
```
1 2 5 10 20
count: 6
distinct: 5
min: 1
max: 20
```

#### Execution with data from a file

```
java -jar backend-lsn-1.0.0.jar task1 <path_to_file>
```

#### Execution with data from standard input
```
java -jar backend-lsn-1.0.0.jar task1
```

## Task2
### Description

Input is a list of integers. App should find all pairs which sum to 13.
Output data should be sorted, each pair in the output should have first number not greater than the second one and lines should be sorted in an ascending order.

For example, given the input data:

```
1 2 10 7 5 3 6 6 13 0
```

The expected output is:

```
0 13
3 10
6 7
6 7
```

#### Execution with data from a file

```
java -jar backend-lsn-1.0.0.jar task2 <path_to_file>
```

#### Execution with data from standard input

```
java -jar backend-lsn-1.0.0.jar task2
```

## Task3
### Description
Given a list of connections between vertices in an undirected graph (with the number of connections specified as the first line). 
The application determines the number of distinct connection groups in the graph.

For example, given the input data:
```
3
4 3
1 4
5 6
```

The expected output is:

```
2
```

#### Execution with data from a file

```
java -jar backend-lsn-1.0.0.jar task3 <path_to_file>
```

#### Execution with data from standard input

```
java -jar backend-lsn-1.0.0.jar task3
```
