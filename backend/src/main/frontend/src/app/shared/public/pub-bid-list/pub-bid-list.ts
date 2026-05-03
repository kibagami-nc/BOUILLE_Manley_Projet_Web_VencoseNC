import { CommonModule } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';

import { Bid } from '../../models/bid.model';
import { BidService } from '../../services/bid.service';

@Component({
  selector: 'app-pub-bid-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pub-bid-list.html',
  styleUrl: './pub-bid-list.css',
})
export class PubBidList implements OnInit {

  private bidService = inject(BidService);
  bids: Bid[] = [];

  // Au chargement du composant, ça va chercher les annonces
  ngOnInit(): void {
    this.bidService.findAll().subscribe({
      next: (data) => this.bids = data,
      error: (err) => console.error('Erreur chargement annonces', err),
    });
  }
}
