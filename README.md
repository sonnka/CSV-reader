# CsvReader
REST application, that extracts data from csv file.

## Endpoints
Endpoint for extracting data from file and saving it to h2 database. Request parameter is multipart file (csv file).

    POST /csv/upload 

Endpoint for getting data from h2 database. It returns list of data with pagination and sorting.

     GET /csv

## Technologies
- Java 17
- Spring Boot (3.0.6)
- H2 database
- Lombook (1.18.26)
- OpenCSV (5.7.1)
