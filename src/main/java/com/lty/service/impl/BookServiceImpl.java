package com.lty.service.impl;

import com.lty.dao.BookDao;
import com.lty.domain.Books;
import com.lty.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*@Service*/
public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    /*@Autowired*/
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public int addBook(Books books) {
        return bookDao.addBook(books);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBookById(Books books) {
        return bookDao.updateBookById(books);
    }

    @Override
    public Books queryBook(Integer id) {
        return bookDao.queryBook(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return bookDao.queryAllBooks();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookDao.queryBookByName(bookName);
    }
}
