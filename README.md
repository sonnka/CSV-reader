# CsvReader
REST application, that extracts data from csv file.

## Endpoints

    POST /csv/upload 

Request parameter multipart file (csv file).

    GET /csv

Returned list of data with pagination and sorting.

## Technologies
- Java 17
- Spring Boot (3.0.6)
- H2 database
- Lombook (1.18.26)
- OpenCSV (5.7.1)
