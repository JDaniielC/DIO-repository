import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from './model/books.model';

export const books: Book[] = [
  {
    id: '1',
    name: 'Sherlock Holmes Obra completa',
    price: 150,
    quantity: 1,
    category: 'Drama',
    img: 'img1',
  },
  {
    id: '2',
    name: 'O mundo de sofia',
    price: 40,
    quantity: 1,
    category: 'Infantil',
    img: 'img2',
  },
  {
    id: '3',
    name: 'Arsene Lupin',
    price: 10,
    quantity: 1,
    category: '?',
    img: 'img3',
  },
];

@Injectable()
export class BooksService {
  private url = 'https://localhost:44382/api/bookstore'; // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  constructor(private http: HttpClient) {}

  getBooks() {
    return books;
  }

  // getBooks() {
  //   return this.http.get(this.url)
  // }
}
