import { Component, inject, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';
import { CartService } from './services/cart.service';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  
  title = "Football-Shop-app";
  authService = inject(AuthService);
  
  ngOnInit(): void {
    console.log("Initializing...");
    sessionStorage.setItem('token', '');
    this.authService.currentUserSignal.set(null);
  }
}
