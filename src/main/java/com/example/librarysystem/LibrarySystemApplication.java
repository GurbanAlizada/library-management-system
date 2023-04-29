package com.example.librarysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrarySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarySystemApplication.class, args);
    }

}


/*


{
  "isbn": "123456788a",
  "titleId": "07f8ad18-9de4-4fd1-a715-a1c6bde46a28",
  "unitsInStock": 12,
  "publisherIDs": [
    "1125a9de-bd75-44f3-bd85-c15b5278e9f8",
    "fd87a74e-8e38-4912-ae51-2c9130c43d18"
  ],
  "aurhorIDs": [
    "521475a9-ff44-4cfa-87ee-92b5cf000dfd",
    "8084edd0-7527-485b-adaa-a9029d30291d"
  ],
  "categoryIDs": [
    "1af9c122-a114-4304-868b-46d381af024a",
    "5d7bfdb9-b7d5-4c74-96ab-98a26fdc14ff"

  ]
}


 */