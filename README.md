# Bookstore API

This project is a Bookstore API developed using Spring Boot. It provides endpoints to manage books and book categories.

## Endpoints

### Get Book Categories

- **URL:** `/api/books/categories`
- **Method:** `GET`
- **Description:** Retrieves a list of book categories.
- **Parameters:**
    - `limit`: Optional query parameter to specify the maximum number of categories to retrieve (default is 10).
- **Response:** Returns a list of book categories along with their details.

### Get Book Category By ID

- **URL:** `/api/books/categories/{categoryId}`
- **Method:** `GET`
- **Description:** Retrieves a specific book category by its ID.
- **Parameters:**
    - `categoryId`: Path parameter specifying the ID of the book category to retrieve.
- **Response:** Returns the details of the specified book category.

### Get Books By Category

- **URL:** `/api/books/categories/{categoryId}/books`
- **Method:** `GET`
- **Description:** Retrieves books belonging to a specific category.
- **Parameters:**
    - `categoryId`: Path parameter specifying the ID of the category for which books are to be retrieved.
- **Response:** Returns a list of books belonging to the specified category.

### Get All Books

- **URL:** `/api/books`
- **Method:** `GET`
- **Description:** Retrieves all books.
- **Response:** Returns a list of all books along with their details.

### Get Books By Availability Status

- **URL:** `/api/books/status`
- **Method:** `GET`
- **Description:** Retrieves books based on their availability status.
- **Parameters:**
    - `availability`: Required query parameter specifying the availability status of books.
- **Response:** Returns a list of books with the specified availability status.

### Create Book

- **URL:** `/api/books`
- **Method:** `POST`
- **Description:** Creates a new book.
- **Request Body:** Contains details of the book to be created.
- **Response:** Returns the details of the newly created book.

### Update Book

- **URL:** `/api/books/{bookId}`
- **Method:** `PUT`
- **Description:** Updates an existing book.
- **Parameters:**
    - `bookId`: Path parameter specifying the ID of the book to be updated.
- **Request Body:** Contains updated details of the book.
- **Response:** Returns the updated details of the book.

### Get Book By ID

- **URL:** `/api/books/{bookId}`
- **Method:** `GET`
- **Description:** Retrieves a specific book by its ID.
- **Parameters:**
    - `bookId`: Path parameter specifying the ID of the book to retrieve.
- **Response:** Returns the details of the specified book.

## Technologies Used

- Java
- Spring Boot
- Spring WebFlux
- Project Lombok

## How to Run

1. Clone the repository.
2. Navigate to the project directory.
3. Run docker compose up -d
4. The api will start running on port 8091, and you can access the endpoints using a tool like Postman or cURL.

## Contributors

- [Your Name or Organization](https://github.com/yourusername)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
