import { Component, signal } from '@angular/core';
import { PubNavbar } from './shared/public';

@Component({
  selector: 'app-root',
  imports: [PubNavbar],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
