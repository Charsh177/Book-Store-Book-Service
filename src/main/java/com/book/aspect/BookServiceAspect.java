package com.book.aspect;

import com.book.dto.BookDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookServiceAspect {

    @Before(value = "execution(* com.book.services.BookService.*(..)) && args(bookDTO)")
    public void beforeAdvice(JoinPoint joinPoint, BookDTO bookDTO) {
        System.out.println("Before Method : " + joinPoint.getSignature());

        System.out.println("Creating Book with name -> " + bookDTO.getBookName());
    }

    @After(value = "execution(* com.book.services.BookService.*(..)) && args(bookDTO)")
    public void afterAdvice(JoinPoint joinPoint, BookDTO bookDTO) {
        System.out.println("After Method : " + joinPoint.getSignature());

        System.out.println("Successful... Created Book with name -> " + bookDTO.getBookName()
                + "\nBook Author -> " + bookDTO.getAuthor()
                + "\nBook Cover Image -> " + bookDTO.getCoverImage()
                + "\nBook Quantity Available -> " + bookDTO.getQuantity()
                + "\nPrice per Book -> " + bookDTO.getPrice()
        );
    }
}