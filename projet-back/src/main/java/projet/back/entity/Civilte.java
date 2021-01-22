package projet.back.entity;

public enum Civilte {
	M("monsieur"), MME("madame"), MLLE("mademoiselle");

	private String texte;

	private Civilte(String texte) {
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}
}
