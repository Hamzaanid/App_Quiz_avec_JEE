package beans;

public class reponse {
	private int id_reponse;
	private int id_question;
	private String lib_reponse;
	private boolean correct;
	public reponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_reponse() {
		return id_reponse;
	}
	public void setId_reponse(int id_reponse) {
		this.id_reponse = id_reponse;
	}
	public int getId_question() {
		return id_question;
	}
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	public String getLib_reponse() {
		return lib_reponse;
	}
	public void setLib_reponse(String lib_reponse) {
		this.lib_reponse = lib_reponse;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
}
