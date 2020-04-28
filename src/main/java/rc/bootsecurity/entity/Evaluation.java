package rc.bootsecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "evaluation")
public class Evaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "competence")
	private String competence;

	@Column(name = "espace")
	private String espace;

	@Column(name = "formation")
	private String formation;

	@Column(name = "formateur")
	private String formateur;

	@Column(name = "note")
	private String note;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompetence() {
		return competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
	}

	public String getEspace() {
		return espace;
	}

	public void setEspace(String espace) {
		this.espace = espace;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public String getFormateur() {
		return formateur;
	}

	public void setFormateur(String formateur) {
		this.formateur = formateur;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evaluation(String formation) {
		super();
		this.formation = formation;
	}

	public Evaluation(long id, String competence, String espace, String formation, String formateur, String note) {
		super();
		this.id = id;
		this.competence = competence;
		this.espace = espace;
		this.formation = formation;
		this.formateur = formateur;
		this.note = note;
	}

}
