import { Injectable, signal } from '@angular/core';

export type ModalName = 'login' | 'register' | null;

@Injectable({ providedIn: 'root' })
export class ModalService {

  // Signal qui dit quelle modale est ouverte (ou null si aucune)
  readonly current = signal<ModalName>(null);

  open(name: 'login' | 'register') {
    this.current.set(name);
  }

  close() {
    this.current.set(null);
  }
}
