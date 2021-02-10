import { FormulairePiloteParLeTemplateComponent } from './formulaire/formulaire-pilote-par-le-template/formulaire-pilote-par-le-template.component';
import { LoginComponent } from './login/login.component';
import { CanActivateService } from './service/can-activate.service';
import { FormationEditComponent } from './crud/formation/formation-edit/formation-edit.component';
import { FormationListComponent } from './crud/formation/formation-list/formation-list.component';
import { PersonneListComponent } from './crud/personne/personne-list/personne-list.component';
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
  {
    path: 'personne',
    component: PersonneListComponent,
    canActivate: [CanActivateService],
  },
  { path: 'formation', component: FormationListComponent },
  { path: 'formation/edit', component: FormationEditComponent },
  { path: 'formation/edit/:id', component: FormationEditComponent },
  { path: 'login', component: LoginComponent },
  { path: 'form', component: FormulairePiloteParLeTemplateComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
