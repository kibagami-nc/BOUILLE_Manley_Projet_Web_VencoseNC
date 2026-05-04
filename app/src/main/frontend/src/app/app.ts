import { Component, inject, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { PubNavbar, PubFooter } from './shared/public';
import { Login } from './features/auth/login/login';
import { Register } from './features/auth/register/register';
import { ModalService } from './shared/services/modal.service';
import { AuthService } from './shared/services/auth.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, PubNavbar, PubFooter, Login, Register],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  protected readonly title = signal('frontend');
  protected readonly modal = inject(ModalService);
  private readonly auth = inject(AuthService);

  ngOnInit() {
    // recharge l'utilisateur connecte si dispo
    this.auth.loadFromStorage();
  }
}
