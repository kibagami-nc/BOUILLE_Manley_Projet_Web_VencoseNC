import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PubNavbar } from './pub-navbar';

describe('PubNavbar', () => {
  let component: PubNavbar;
  let fixture: ComponentFixture<PubNavbar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PubNavbar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PubNavbar);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
