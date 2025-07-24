package com.Joyce.bookstore.service;

import com.Joyce.bookstore.domain.Book;
import com.Joyce.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BooksUpdateService {

    @Value("${nyt.api.key}")
    private String nytApiKey;

    @Value("${goog.api.key}")
    private String googApiKey;
    @Autowired
    private BookRepository bookRepository;

    private final RestTemplate restTemplate = new RestTemplate();


    // every Thursday 22 PM
    @Scheduled(cron = "0 0 22 ? 1-12 4")
    public Boolean updateBooks() {

        System.out.println("Updating book list...");

        String url = "https://api.nytimes.com/svc/books/v3/lists/overview.json?api-key=" + nytApiKey;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> body = response.getBody();

        if (body == null || !body.containsKey("results")) return false;

        Map<String, Object> results = (Map<String, Object>) body.get("results");
        List<Map<String, Object>> lists = (List<Map<String, Object>>) results.get("lists");
        LocalDate localDate = LocalDate.parse(results.get("published_date").toString());
        Date publishDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        if (lists == null || lists.isEmpty()) return false;

        for (Map<String, Object> list : lists) {
            List<Map<String, Object>> books = (List<Map<String, Object>>) list.get("books");

            if (books == null || books.isEmpty()) continue;

            for (Map<String, Object> bookData : books) {
                List<Map<String, String>> isbns = (List<Map<String, String>>) bookData.get("isbns");
                if (isbns == null || isbns.isEmpty()) continue;
                String isbn = isbns.get(0).get("isbn13");

                if (isbn == null || bookRepository.existsByIsbn(isbn)) continue;

                Book book = new Book();
//                book.setId(new ObjectId());
                book.setTitle((String) bookData.get("title"));
                book.setAuthor((String) bookData.get("author"));
                book.setIsbn(isbn);
                book.setPublishDate(publishDate);
                book.setDescription((String) bookData.get("description"));
                book.setCoverImage((String) bookData.get("book_image"));
                book.setCategory(fetchCategoryFromGoogleBooks(isbn));
                book.setTrending(false);

                BigDecimal oldPrice = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(10.0, 50.0)).setScale(2, RoundingMode.HALF_UP);
                BigDecimal discount = oldPrice.multiply(BigDecimal.valueOf(0.2)).setScale(2, RoundingMode.HALF_UP);
                BigDecimal newPrice = oldPrice.subtract(discount);

                book.setOldPrice(oldPrice);
                book.setNewPrice(newPrice);
                book.setCreateAt(new Date());

                bookRepository.save(book);
            }
        }

        return true;
    }

    public List<String> fetchCategoryFromGoogleBooks(String isbn) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn + "&key=" + googApiKey;

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            Map<String, Object> body = response.getBody();

            if (body == null || !body.containsKey("items")) return null;

            List<Map<String, Object>> items = (List<Map<String, Object>>) body.get("items");
            if (items.isEmpty()) return null;

            Map<String, Object> volumeInfo = (Map<String, Object>) items.get(0).get("volumeInfo");

            if (volumeInfo.containsKey("categories")) {
                return (List<String>) volumeInfo.get("categories");
            }
        } catch (Exception e) {
            System.out.println("Error fetching category from Google Books: " + e.getMessage());
        }

        return null;
    }

}
