import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';

import { ModalService } from '../../services/modal.service';

@Component({
  selector: 'app-pub-navbar',
  imports: [RouterLink],
  templateUrl: './pub-navbar.html',
  styleUrl: './pub-navbar.css',
})
export class PubNavbar {

  protected readonly modal = inject(ModalService);
}
