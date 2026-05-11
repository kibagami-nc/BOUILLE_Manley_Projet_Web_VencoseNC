import { Component, inject } from '@angular/core';
import { DatePipe } from '@angular/common';

import { ModalService } from '../../services/modal.service';

@Component({
  selector: 'app-pub-bid-details',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './pub-bid-details.html',
  styleUrl: './pub-bid-details.css',
})
export class PubBidDetails {

  protected readonly modal = inject(ModalService);
}
