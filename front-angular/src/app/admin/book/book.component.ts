import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Book} from "../../models/book.model";
import {BookService} from "../../services/book.service";

declare var $: any;

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent {
  @Input()
  book: Book = new Book();
  errorMessage: string = '';
  @Output()
  save = new EventEmitter<any>();

  constructor(private bookService: BookService) {
  }

  saveBook() {
    this.bookService.saveBook(this.book).pipe().subscribe((data)=> {
      this.save.emit(data);
      $('#bookModal').modal('toggle');
      }, () => {
        this.errorMessage = "Coś poszło nie tak";
      }
    );
  }

  showBookModal() {
    $('#bookModal').modal('show');
  }

}
