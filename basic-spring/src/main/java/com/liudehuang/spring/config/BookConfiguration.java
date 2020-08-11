package com.liudehuang.spring.config;

import com.liudehuang.spring.entity.Book;
import com.liudehuang.spring.entity.SubBook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 19:51
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 19:51
 * @UpdateRemark:
 * @Version:
 */
@Configuration
public class BookConfiguration {

    @Bean
    public Book book(){
        Book book = new Book();
        book.setBookName("java");
        return book;
    }

    @Bean
    public SubBook subBook(){
        SubBook book = new SubBook();
        book.setBookSystem("c++");
        return book;
    }
}
