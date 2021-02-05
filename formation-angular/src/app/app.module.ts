import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { MonComponentComponent } from './mon-component/mon-component.component';
import { TitreComponent } from './titre/titre.component';
import { BoldElementComponent } from './bold-element/bold-element.component';
import { TooltipComponent } from './tooltip/tooltip.component';
import { DisplayProduitComponent } from './display-produit/display-produit.component';
import { Produit } from 'src/model/produit';
import { SaisieProduitComponent } from './saisie-produit/saisie-produit.component';
import { TestNgForComponent } from './test-ng-for/test-ng-for.component';
import { SurlignerDirective } from './surligner.directive';

@NgModule({
  declarations: [
    AppComponent,
    MonComponentComponent,
    TitreComponent,
    BoldElementComponent,
    TooltipComponent,
    DisplayProduitComponent,
    SaisieProduitComponent,
    TestNgForComponent,
    SurlignerDirective,
  ],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
