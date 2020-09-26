package com.lty.dao;

import com.lty.domain.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(@Param("bookId") Integer id);
    //更新一本书
    int updateBookById(Books books);
    //根据id查询书
    Books queryBook(@Param("bookId") Integer id);
    //查询全部书籍
    List<Books> queryAllBooks();
    //通过书籍名称查询书籍
    Books queryBookByName(@Param("bookName") String bookName);
}
