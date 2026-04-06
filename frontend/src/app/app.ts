import { Component, signal } from '@angular/core';
import { PubNavbar } from './shared/public';
import { MainHero } from './features/main/main-hero/main-hero';

@Component({
  selector: 'app-root',
  imports: [PubNavbar, MainHero],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
