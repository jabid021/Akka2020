import { FormControl } from '@angular/forms';
export class ProduitValidator {
  public static modulo5(control: FormControl): any {
    if (control.value % 5 === 0) {
      return null;
    } else {
      return { modulo5: true };
    }
  }
}
