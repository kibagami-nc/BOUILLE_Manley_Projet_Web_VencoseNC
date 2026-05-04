import { Component, input } from '@angular/core';

export type IconName = 'eye' | 'eye-off';

@Component({
  selector: 'app-icon',
  imports: [],
  templateUrl: './icon.html',
})
export class Icon {
  name = input.required<IconName>();
  size = input<number>(20);
}
