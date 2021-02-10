import { ProduitValidator } from './../../validation/produit-validator';
import { Produit } from './../../../model/produit';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-formulaire-pilote-par-le-code',
  templateUrl: './formulaire-pilote-par-le-code.component.html',
  styleUrls: ['./formulaire-pilote-par-le-code.component.css'],
})
export class FormulairePiloteParLeCodeComponent implements OnInit {
  nomCtrl: FormControl;
  prixCtrl: FormControl;
  form: FormGroup;
  produit: Produit;
  unGroup: FormGroup;

  constructor(private fb: FormBuilder) {
    this.nomCtrl = this.fb.control('', [
      Validators.required,
      Validators.minLength(3),
    ]);
    this.prixCtrl = this.fb.control(0, ProduitValidator.modulo5);

    this.unGroup = this.fb.group(
      {
        nom: this.nomCtrl,
        prix: this.prixCtrl,
      },
      { validator: this.erreurProduitTeleA1000Euros }
    );
    this.form = this.fb.group({
      group: this.unGroup,
    });
  }

  erreurProduitTeleA1000Euros(group: FormGroup) {
    const nomC = group.controls['nom'];
    const prixC = group.controls['prix'];

    if (nomC.value === 'tele' && prixC.value === '1000') {
      return { monErreur: true };
    }
    return null;
  }

  ngOnInit(): void {}

  send() {
    this.produit = new Produit(this.nomCtrl.value, this.prixCtrl.value);
    console.log(this.produit);
  }
}
