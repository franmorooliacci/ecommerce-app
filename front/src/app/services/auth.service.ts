import { inject, Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiResponse } from '../common/api-response';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  currentUserSignal = signal<ApiResponse | undefined | null>(undefined);
  baseUrl = 'http://localhost:8080/api/auth';
  http = inject(HttpClient);
  router = inject(Router);

  login(credentials: {username: string, password: string}): void {
    
    this.http.post(`${this.baseUrl}/login`, credentials)
    .subscribe({
      next: (response: ApiResponse) => {     
        console.log('response:', response);
        sessionStorage.setItem('token', response.token);
        this.currentUserSignal.set(response);
        alert('Successfully logged in!');
        this.router.navigateByUrl('/products');
      },
      error: () => {
        this.currentUserSignal.set(null);
        alert('Failed to log in.');
      }
    });
  }
  
  register(credentials: {username: string, password: string}): void {
    
    this.http.post(`${this.baseUrl}/register`, credentials, { responseType: 'text' as 'json' })
    .subscribe({
      next: (response) => {
        console.log('response:', response);
        alert('User successfully registered!');
        this.router.navigateByUrl('/login');
      },
      error: () => {
        alert('Failed to register.');
      }
    });
  }

  logout(): void {
    console.log('logout()');
    sessionStorage.setItem('token', '');
    this.currentUserSignal.set(null);
    this.router.navigateByUrl('/register');
  }
}