export class Produit {
  private _nom: string;
  private _prix: number;

  constructor(nom: string = '', prix: number = 0) {
    this._nom = nom;
    this._prix = prix;
  }

  /**
   * Getter nom
   * @return {string}
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Getter prix
   * @return {number}
   */
  public get prix(): number {
    return this._prix;
  }

  /**
   * Setter nom
   * @param {string} value
   */
  public set nom(value: string) {
    this._nom = value;
  }

  /**
   * Setter prix
   * @param {number} value
   */
  public set prix(value: number) {
    this._prix = value;
  }
}
