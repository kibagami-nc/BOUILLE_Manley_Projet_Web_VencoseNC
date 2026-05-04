import { Component, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { ModalService } from '../../../shared/services/modal.service';
import { AuthService, AuthUser } from '../../../shared/services/auth.service';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  protected readonly modal = inject(ModalService);
  private readonly http = inject(HttpClient);
  private readonly auth = inject(AuthService);

  email = '';
  password = '';
  errorMessage = signal('');

  onSubmit() {

    this.errorMessage.set('');

    // POST vers le backend (corps JSON, rien dans l'URL)
    this.http.post<AuthUser>('http://localhost:8080/api/auth/login', {
      email: this.email,
      password: this.password,
    }).subscribe({
      next: (user) => {
        this.auth.setUser(user);
        this.modal.close();
      },
      error: () => {
        this.errorMessage.set('Email ou mot de passe incorrect');
      },
    });
  }
}
