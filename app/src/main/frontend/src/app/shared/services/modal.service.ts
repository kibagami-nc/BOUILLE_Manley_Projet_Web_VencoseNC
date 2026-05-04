import { Injectable, signal } from '@angular/core';

export type ModalName = 'login' | 'register' | 'logout' | null;

@Injectable({ providedIn: 'root' })
export class ModalService {

  // Signal qui dit quelle modale est ouverte (ou null si aucune)
  readonly current = signal<ModalName>(null);

  open(name: 'login' | 'register' | 'logout') {
    this.current.set(name);
  }

  close() {
    this.current.set(null);
  }
}
