import {Component, OnInit} from '@angular/core';
import { faBook } from '@fortawesome/free-solid-svg-icons';
import {Book} from "../../models/book.model";
import {AuthenticationService} from "../../services/authentication.service";
import {BookService} from "../../services/book.service";
import {PurchaseService} from "../../services/purchase.service";
import {Purchase} from "../../models/purchase.model";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  bookList: Array<Book> = [];
  faBook = faBook;
  error: string = '';
  info: string = '';

  constructor(private auth: AuthenticationService, private bookService: BookService, private purchaseService: PurchaseService) {
  }

  ngOnInit(): void {
    this.bookService.getAllBooks().subscribe(data => {
      this.bookList = data;
    })
  }

  purchase(book: Book) {
    if(!this.auth.currentUserValue?.id) {
      this.error = "Musisz się zalogować, by kupić książkę";
      return
    }

    const purchase = new Purchase(this.auth.currentUserValue.id, book.id, book.price)
    this.purchaseService.savePurchase(purchase).subscribe(data => {
      this.info = "Właśnie kupiłeś książkę, miłego czytania!"
    }, () => {
      this.error = "Wystąpił błąd. Spróbuj ponownie";
    })
  }


}
