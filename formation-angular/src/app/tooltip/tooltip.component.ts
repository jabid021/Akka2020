import { Component, HostListener, Input, OnInit } from '@angular/core';

@Component({
  selector: 'asc-tooltip,[asc-tooltip]',
  templateUrl: './tooltip.component.html',
  styleUrls: ['./tooltip.component.css'],
})
export class TooltipComponent implements OnInit {
  @Input('asc-tooltip-titre')
  tooltip: string = '';
  visible = false;

  constructor() {}

  ngOnInit(): void {}

  @HostListener('mouseover')
  public afficher() {
    this.visible = true;
  }

  @HostListener('mouseleave')
  public cacher() {
    this.visible = false;
  }
}
