package br.com.trama.cataloga.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.trama.cataloga.model.Books;

/**
 * Created by trama on 22/02/16.
 */
public class Mocks {

    public static List<Books> getBooks(int size){

        String[] urlImg = {
                "http://books.google.com.br/books/content?id=PzpWAAAAcAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                "http://books.google.com.br/books/content?id=QB19ir2j2TMC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                "http://books.google.com.br/books/content?id=RhqJWjZ_6o4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                "http://books.google.com.br/books/content?id=A6EXfjHkFTEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                "http://books.google.com.br/books/content?id=tGSpuAAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api",
                "http://books.google.com.br/books/content?id=GiwCbZoRBH8C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
        };

        List<Books> list = new ArrayList<>();

        for(int i = 0; i < size; i++){
            Books books = new Books();
            int idx = new Random().nextInt(urlImg.length);
            books.imageUrl = idx > urlImg.length - 1 ? "" : urlImg[idx];
            books.text = "Proin pretium, leo ac pellentesque mollis, felis nunc ultrices eros, sed gravida augue augue mollis justo. ["+i+"]";
            books.title = "Proin faucibus arcu quis ante ["+i+"]";
            list.add(books);
        }

        return list;
    }
}
