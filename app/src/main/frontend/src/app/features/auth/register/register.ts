import { Component, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { ModalService } from '../../../shared/services/modal.service';
import { AuthService, AuthUser } from '../../../shared/services/auth.service';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {

  protected readonly modal = inject(ModalService);
  private readonly http = inject(HttpClient);
  private readonly auth = inject(AuthService);

  lastName = '';
  firstName = '';
  email = '';
  phoneMobile = '';
  phoneLandline = '';
  password = '';
  confirmPassword = '';
  errorMessage = signal('');

  onSubmit() {

    this.errorMessage.set('');

    if (this.password !== this.confirmPassword) {
      this.errorMessage.set('Les mots de passe ne correspondent pas');
      return;
    }

    // POST vers le backend (corps JSON, rien dans l'URL)
    this.http.post<AuthUser>('http://localhost:8080/api/user', {
      lastName: this.lastName,
      firstName: this.firstName,
      email: this.email,
      phoneMobile: this.phoneMobile,
      phoneLandline: this.phoneLandline,
      password: this.password,
    }).subscribe({
      next: (user) => {
        this.auth.setUser(user);
        this.modal.close();
      },
      error: () => {
        this.errorMessage.set('Erreur lors de l\'inscription');
      },
    });
  }
}
