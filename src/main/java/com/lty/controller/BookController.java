package com.lty.controller;

import com.lty.domain.Books;
import com.lty.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allbook")
    public ModelAndView list(){
        List<Books> lists = bookService.queryAllBooks();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",lists);
        mv.setViewName("allbook");
        return mv;
    }
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allbook";
    }
    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatepaper(Integer id, Model model){
        Books books = bookService.queryBook(id);
        model.addAttribute("books",books);
        return "updateBook";
    }
    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBookById(book);
        Books books = bookService.queryBook(book.getBookID());
        model.addAttribute("books2", books);
        return "redirect:/book/allbook";
    }
    //删除操作
    @RequestMapping("/deleteBook")
    public String deleteBook(Integer id){
        bookService.deleteBookById(id);
        return "redirect:/book/allbook";
    }
    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName ,Model Model){
        Books books = bookService.queryBookByName(queryBookName);

        List<Books> lists = new ArrayList<>();
        lists.add(books);
        if (books == null){
            lists = bookService.queryAllBooks();
            Model.addAttribute("error","未查到");
        }
        System.out.println(books);
        Model.addAttribute("list",lists);
        return "allbook";
    }
}
