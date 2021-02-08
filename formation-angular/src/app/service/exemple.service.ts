import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ExempleService {
  constructor() {
    console.log('construction du service');
  }

  public methodeDuService() {
    console.log('methode du service');
  }
}
