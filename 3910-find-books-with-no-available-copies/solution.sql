WITH temp AS(SELECT l.book_id,l.title,l.author,l.genre,l.publication_year,l.total_copies,b.return_date FROM library_books l JOIN borrowing_records b ON l.book_id=b.book_id)
SELECT book_id,title,author,genre,publication_year,total_copies AS current_borrowers FROM temp WHERE return_date IS NULL GROUP BY book_id HAVING COUNT(book_id)=total_copies ORDER BY current_borrowers DESC,title;

