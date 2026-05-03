import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';

import { Bid } from '../models/bid.model';

// Service qui parle au backend Spring (endpoint /api/bid)
@Injectable({ providedIn: 'root' })
export class BidService {

  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/bid';

  // Recupere toutes les annonces
  findAll(): Observable<Bid[]> {
    return this.http.get<Bid[]>(this.apiUrl);
  }

  // Recupere une annonce par son id
  findById(id: number): Observable<Bid> {
    return this.http.get<Bid>(`${this.apiUrl}/${id}`);
  }
}
