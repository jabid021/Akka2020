import { Observable } from 'rxjs';
import { InscriptionService } from './../service/inscription.service';
import { Router } from '@angular/router';
import { Login } from './../model/login';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { debounceTime, map } from 'rxjs/operators';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  usernameCtrl: FormControl;
  passwordCtrl: FormControl;
  confirmCtrl: FormControl;
  passwordGroup: FormGroup;
  form: FormGroup;
  private login: Login;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private inscriptionService: InscriptionService
  ) {
    this.usernameCtrl = this.fb.control(
      '',
      [Validators.required, Validators.minLength(3)],
      this.checkLogin()
    );
    this.passwordCtrl = this.fb.control('', [
      Validators.minLength(3),
      Validators.pattern(/^(?=.*\d)(?=.*[a-zA-Z])([a-zA-Z0-9]{3,})$/),
    ]);
    this.confirmCtrl = this.fb.control('', Validators.required);
    this.passwordGroup = this.fb.group(
      {
        password: this.passwordCtrl,
        confirm: this.confirmCtrl,
      },
      { validator: this.checkPassword }
    );
    this.form = this.fb.group({
      username: this.usernameCtrl,
      passGroup: this.passwordGroup,
    });
  }

  ngOnInit(): void {}

  private checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionService.checkLogin(control.value).pipe(
        debounceTime(500),
        map((result: boolean) => {
          return result ? { loginExist: true } : null;
        })
      );
    };
  }

  private checkPassword(group: FormGroup) {
    const password = group.controls.password;
    const confirm = group.controls['confirm'];
    if (password.errors) {
      return null;
    }
    return password.value !== confirm.value ? { notEquals: true } : null;
  }

  public send() {
    this.login = new Login(this.usernameCtrl.value, this.passwordCtrl.value);
    this.inscriptionService.insciption(this.login).subscribe((result) => {
      this.router.navigate(['/login']);
    });
  }

  public usernameIsInvalid(): boolean {
    return this.usernameCtrl.dirty && this.usernameCtrl.invalid;
  }
  public passwordIsInvalid(): boolean {
    return this.passwordCtrl.dirty && this.passwordCtrl.invalid;
  }

  public confirmNotEquals(): boolean {
    return this.confirmCtrl.dirty && this.passwordGroup.invalid;
  }
}
