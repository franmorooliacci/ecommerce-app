import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-btn',
  templateUrl: './login-btn.component.html',
  styleUrl: './login-btn.component.css'
})
export class LoginBtnComponent {

  router = inject(Router);

  goToLogin(): void {
    this.router.navigateByUrl('/login');
  }

}
