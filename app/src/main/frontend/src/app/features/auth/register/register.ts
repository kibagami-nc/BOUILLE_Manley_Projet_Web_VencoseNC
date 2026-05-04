import { Component, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { ModalService } from '../../../shared/services/modal.service';
import { AuthService, AuthUser } from '../../../shared/services/auth.service';
import { Icon } from '../../../shared/icon/icon';

@Component({
  selector: 'app-register',
  imports: [FormsModule, Icon],
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
  showPassword = signal(false);

  toggleShowPassword() {
    this.showPassword.set(!this.showPassword());
  }

  onSubmit() {

    this.errorMessage.set('');

    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.email)) {
      this.errorMessage.set('L\'email n\'est pas valide');
      return;
    }

    if (!/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/.test(this.password)) {
      this.errorMessage.set('Le mot de passe doit contenir au moins 8 caractères, une majuscule, une minuscule et un chiffre');
      return;
    }

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
