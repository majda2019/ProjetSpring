package rc.bootsecurity.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="formations")
public class Formation{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="semestre")
	private String semestre;
	
	@Column(name="filliere")
	private String filliere;
	
	@Column(name="formation")
	private String formation;
	
	
	
	@Column(name="formateurs")
	private String formateurs;
	
	@Column(name="salle")
	private String salle;
	
	
	@Column(name="date")
	private Date date;
	
	
	@Column(name="prix")
	private int prix;
	
	
	
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getFilliere() {
		return filliere;
	}
	public void setFilliere(String filliere) {
		this.filliere = filliere;
	}
	public String getFormation() {
		return formation;
	}
	public void setFormation(String formation) {
		this.formation = formation;
	}
	
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFormateurs() {
		return formateurs;
	}
	public void setFormateurs(String formateurs) {
		this.formateurs = formateurs;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Formation(long id, String semestre, String filliere, String formation, String formateurs, String salle,
			Date date,int prix) {
		super();
		this.id = id;
		this.semestre = semestre;
		this.filliere = filliere;
		this.formation = formation;
		this.formateurs = formateurs;
		this.salle = salle;
		this.date = date;
		this.prix = prix;
	}
	
	


}
