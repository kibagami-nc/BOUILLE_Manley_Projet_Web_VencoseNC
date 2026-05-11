import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';

import { ModalService } from '../../services/modal.service';
import { AuthService } from '../../services/auth.service';
import { Icon } from '../../icon/icon';

@Component({
  selector: 'app-pub-navbar',
  imports: [RouterLink, Icon],
  templateUrl: './pub-navbar.html',
  styleUrl: './pub-navbar.css',
})
export class PubNavbar {

  protected readonly modal = inject(ModalService);
  protected readonly auth = inject(AuthService);
}
