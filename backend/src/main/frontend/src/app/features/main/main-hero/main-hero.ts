import { Component } from '@angular/core';

import { PubSearch } from '../../../shared/public/pub-search/pub-search';
import { PubBidList } from '../../../shared/public/pub-bid-list/pub-bid-list';

@Component({
  selector: 'app-main-hero',
  imports: [PubSearch, PubBidList],
  templateUrl: './main-hero.html',
  styleUrl: './main-hero.css',
})
export class MainHero {

}
