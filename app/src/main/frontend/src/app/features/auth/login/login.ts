import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { ModalService } from '../../../shared/services/modal.service';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  protected readonly modal = inject(ModalService);
  private readonly http = inject(HttpClient);

  email = '';
  password = '';

  onSubmit() {

    // POST vers le backend (corps JSON, rien dans l'URL)
    this.http.post('/api/auth/login', {
      email: this.email,
      password: this.password,
    }).subscribe({
      next: () => this.modal.close(),
      error: (err) => console.error('Erreur de connexion', err),
    });
  }
}
