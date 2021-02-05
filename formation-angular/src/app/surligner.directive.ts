import {
  Directive,
  ElementRef,
  HostListener,
  Input,
  Renderer2,
} from '@angular/core';

@Directive({
  selector: '[surligner]',
})
export class SurlignerDirective {
  @Input('couleur')
  color: string = 'yellow';

  constructor(private el: ElementRef, private renderer: Renderer2) {}

  @HostListener('mouseover')
  onMouseOver() {
    this.renderer.setStyle(this.el.nativeElement, 'color', this.color);
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.renderer.setStyle(this.el.nativeElement, 'color', 'black');
  }
}
