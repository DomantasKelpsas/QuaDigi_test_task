Application Challenge for QuaDigi

Task is to sample the received measurements into a 5-minute interval based on the
following rules:
- each type of measurement shall be sampled separately
- from a 5-minute interval only the last measurement shall be taken
- if a measurement timestamp will exactly match a 5-minute interval border, it shall be used
for the current interval
- the input values are not sorted by time
- the output shall be sorted by time ascending

Hints for building the program:
- use jdk version 17 (azul-17.0.8 was used)
- in terminal run './gradlew build' and './gradlew run'
- to run tests './gradlew test'


