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
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { Page1PublicComponent } from './page1-public/page1-public.component';
import { BonjourComponent } from './bonjour/bonjour.component';
import { ListProduitComponent } from './crud/produit/list-produit/list-produit.component';
import { EditProduitComponent } from './crud/produit/edit-produit/edit-produit.component';

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
    HomeComponent,
    Page1PublicComponent,
    BonjourComponent,
    ListProduitComponent,
    EditProduitComponent,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
