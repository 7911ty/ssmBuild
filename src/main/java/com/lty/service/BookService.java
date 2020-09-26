package com.lty.service;

import com.lty.domain.Books;

import java.util.List;

public interface BookService {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById( Integer id);
    //更新一本书
    int updateBookById(Books books);
    //根据id查询书
    Books queryBook( Integer id);
    //查询全部书籍
    List<Books> queryAllBooks();
    //通过书籍名称查询书籍
    Books queryBookByName(String bookName);
}
