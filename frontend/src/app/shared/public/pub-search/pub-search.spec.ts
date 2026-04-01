import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PubSearch } from './pub-search';

describe('PubSearch', () => {
  let component: PubSearch;
  let fixture: ComponentFixture<PubSearch>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PubSearch]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PubSearch);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
