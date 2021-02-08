import { EditProduitComponent } from './crud/produit/edit-produit/edit-produit.component';
import { ListProduitComponent } from './crud/produit/list-produit/list-produit.component';
import { BonjourComponent } from './bonjour/bonjour.component';
import { Page1PublicComponent } from './page1-public/page1-public.component';
import { TestNgForComponent } from './test-ng-for/test-ng-for.component';
import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produit', component: ListProduitComponent },
  { path: 'produit/edit', component: EditProduitComponent },
  { path: 'produit/edit/:index', component: EditProduitComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
