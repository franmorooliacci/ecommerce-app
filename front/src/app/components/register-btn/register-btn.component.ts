import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-btn',
  templateUrl: './register-btn.component.html',
  styleUrl: './register-btn.component.css'
})
export class RegisterBtnComponent {

  router = inject(Router);

  goToRegister(): void {
    this.router.navigateByUrl('/register');
  }

}
