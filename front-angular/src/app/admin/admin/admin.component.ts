import {Component, OnInit, ViewChild} from '@angular/core';
import {Book} from "../../models/book.model";
import {BookService} from "../../services/book.service";
import {BookComponent} from "../book/book.component";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  bookList: Array<Book> = [];
  selectedBook: Book = new Book();
  @ViewChild(BookComponent) child: BookComponent | undefined;

  constructor(private bookService: BookService) {
  }

  ngOnInit(): void {
    this.bookService.getAllBooks().subscribe(books => {
      this.bookList = books;
    })
  }

  createBook() {
    this.selectedBook = new Book();
    this.child?.showBookModal();
  }

  editBook(item: Book) {
    this.selectedBook = Object.assign({}, item)
    this.child?.showBookModal();
  }

  deleteBook(bookToDelete: Book, index: number) {
    this.bookService.deleteBook(bookToDelete).pipe().subscribe(data => {
      this.bookList.splice(index, 1);
    })
  }

  saveBookWatcher($event: any) {
    let itemIndex = this.bookList.findIndex(item => item.id === $event.id);
    if (itemIndex !== -1) {
      this.bookList[itemIndex] = $event;
    } else {

      this.bookList.push($event);
    }
  }
}
