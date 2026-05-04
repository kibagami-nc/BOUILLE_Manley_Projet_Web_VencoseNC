import { Component, inject } from '@angular/core';

import { ModalService } from '../../../shared/services/modal.service';
import { AuthService } from '../../../shared/services/auth.service';

@Component({
  selector: 'app-logout',
  imports: [],
  templateUrl: './logout.html',
  styleUrl: './logout.css',
})
export class Logout {

  protected readonly modal = inject(ModalService);
  private readonly auth = inject(AuthService);

  confirm() {
    this.auth.logout();
    this.modal.close();
  }
}
