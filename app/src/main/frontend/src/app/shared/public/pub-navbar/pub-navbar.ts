import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';

import { ModalService } from '../../services/modal.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-pub-navbar',
  imports: [RouterLink],
  templateUrl: './pub-navbar.html',
  styleUrl: './pub-navbar.css',
})
export class PubNavbar {

  protected readonly modal = inject(ModalService);
  protected readonly auth = inject(AuthService);
}
