import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  error: string = '';
  prenom: string = '';

  constructor(private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.queryParams.subscribe((params) => {
      this.error = params.error;
    });
  }

  ngOnInit(): void {}

  envoyer() {
    if (this.prenom) {
      this.router.navigate(['/bonjour', this.prenom]);
    } else {
      this.router.navigate(['/home'], {
        queryParams: { error: 'prenom vide' },
      });
    }
  }
}
