import { Injectable } from '@angular/core';

// utilisateur retourne par le backend (UserDto)
export interface AuthUser {
  idUser: number;
  lastName: string;
  firstName: string;
  email: string;
  phoneMobile: string;
  phoneLandline: string;
  registrationDate: string;
  isActive: boolean;
}

@Injectable({ providedIn: 'root' })
export class AuthService {

  // utilisateur connecte (null si personne)
  currentUser: AuthUser | null = null;

  // verifie qu'on est cote navigateur (sinon localStorage existe pas en SSR)
  private hasStorage() {
    return typeof window !== 'undefined' && typeof localStorage !== 'undefined';
  }

  setUser(user: AuthUser) {
    this.currentUser = user;
    if (this.hasStorage()) {
      localStorage.setItem('user', JSON.stringify(user));
    }
  }

  logout() {
    this.currentUser = null;
    if (this.hasStorage()) {
      localStorage.removeItem('user');
    }
  }

  // recharge l'utilisateur depuis le localStorage (utilise au demarrage)
  loadFromStorage() {
    if (!this.hasStorage()) return;
    const data = localStorage.getItem('user');
    if (data) {
      this.currentUser = JSON.parse(data);
    }
  }

  isLoggedIn() {
    return this.currentUser !== null;
  }
}
