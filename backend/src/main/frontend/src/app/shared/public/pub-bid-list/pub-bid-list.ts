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
  // Set des ids des annonces actuellement ouvertes (plusieurs en meme temps possible)
  expandedIds = new Set<number>();

  // Au chargement du composant, ça va chercher les annonces
  ngOnInit(): void {
    this.bidService.findAll().subscribe({
      next: (data) => this.bids = data,
      error: (err) => console.error('Erreur chargement annonces', err),
    });
  }

  // Ouvre l'annonce cliquee si elle etait fermee, la referme si elle etait ouverte
  toggle(id: number): void {
    if (this.expandedIds.has(id)) {
      this.expandedIds.delete(id);
    } else {
      this.expandedIds.add(id);
    }
  }

  // Verifie si une annonce est ouverte (utilise dans le template)
  isOpen(id: number): boolean {
    return this.expandedIds.has(id);
  }
}
