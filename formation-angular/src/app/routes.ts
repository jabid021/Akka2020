import { BonjourComponent } from './bonjour/bonjour.component';
import { Page1PublicComponent } from './page1-public/page1-public.component';
import { TestNgForComponent } from './test-ng-for/test-ng-for.component';
import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'for', component: TestNgForComponent },
  { path: 'public/home', component: Page1PublicComponent },
  { path: 'bonjour/:prenom', component: BonjourComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
