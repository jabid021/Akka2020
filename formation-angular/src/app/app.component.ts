import { Component } from '@angular/core';
import { Client } from 'src/model/client';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'formation-angular';
  client: Client = new Client();
  message: string = '';
  couleur = 'red';
  inconnu = 'je sais pas qui ';

  public bouton() {
    console.log('il fait beau aujourdhui');
    this.message = 'bravo tu as cliqué sur le bouton';
  }
}
