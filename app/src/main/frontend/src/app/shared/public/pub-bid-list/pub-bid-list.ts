import { Component, OnInit, inject, signal } from '@angular/core';

import { Bid } from '../../models/bid.model';
import { BidService } from '../../services/bid.service';
import { ModalService } from '../../services/modal.service';

@Component({
  selector: 'app-pub-bid-list',
  standalone: true,
  imports: [],
  templateUrl: './pub-bid-list.html',
  styleUrl: './pub-bid-list.css',
})
export class PubBidList implements OnInit {

  private bidService = inject(BidService);
  protected readonly modal = inject(ModalService);

  protected readonly bids = signal<Bid[]>([]);

  ngOnInit(): void {
    this.bidService.findAll().subscribe({
      next: (data) => this.bids.set(data),
      error: (err) => console.error('Erreur chargement annonces', err),
    });
  }
}
