export class Formation {
  private _id: number;
  private _nom: string;
  private _duree: number;

  constructor(id?: number, nom: string = '', duree: number = 0) {
    this._id = id;
    this._nom = nom;
    this._duree = duree;
  }

  /**
   * Getter id
   * @return {number}
   */
  public get id(): number {
    return this._id;
  }

  /**
   * Getter nom
   * @return {string}
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Getter duree
   * @return {number}
   */
  public get duree(): number {
    return this._duree;
  }

  /**
   * Setter id
   * @param {number} value
   */
  public set id(value: number) {
    this._id = value;
  }

  /**
   * Setter nom
   * @param {string} value
   */
  public set nom(value: string) {
    this._nom = value;
  }

  /**
   * Setter duree
   * @param {number} value
   */
  public set duree(value: number) {
    this._duree = value;
  }
}
