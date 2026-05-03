import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { ModalService } from '../../../shared/services/modal.service';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {

  protected readonly modal = inject(ModalService);
  private readonly http = inject(HttpClient);

  lastName = '';
  firstName = '';
  email = '';
  phoneMobile = '';
  phoneLandline = '';
  password = '';
  confirmPassword = '';

  onSubmit() {

    if (this.password !== this.confirmPassword) {
      console.error('Les mots de passe ne correspondent pas');
      return;
    }

    // POST vers le backend (corps JSON, rien dans l'URL)
    this.http.post('/api/user', {
      lastName: this.lastName,
      firstName: this.firstName,
      email: this.email,
      phoneMobile: this.phoneMobile,
      phoneLandline: this.phoneLandline,
      password: this.password,
    }).subscribe({
      next: () => this.modal.close(),
      error: (err) => console.error('Erreur d\'inscription', err),
    });
  }
}
