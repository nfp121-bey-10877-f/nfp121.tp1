package tp1.question3;

/**
 * NFP121 TpIntroduction, usage de BlueJ et du "Submitter".
 * 
 * @version septembre 2009
 * @author à compléter
 * @see java.lang.String, java.lang.Math
 */
public class AuditeurCNAM {
    /** l'attribut nom de chaque auditeur. */
    private String nom;
    /** l'attribut prenom de chaque auditeur. */
    private String prenom;
    /** l'attribut matricule de chaque auditeur. */
    private String matricule;

    /**
     * "Création", le constructeur d'un auditeur avec son nom, son prénom et son
     * matricule.
     * 
     * @param nom
     *            le nom de l'auditeur
     * @param prenom
     *            son prénom
     * @param matricule
     *            sur la carte d'inscription, près de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

    /**
     * le login au Cnam : 6 premières lettres du nom suivies de la première
     * lettre du prénom séparées de '_' . le login retourné est en minuscules,
     * le trait d'union, ou spéciaux <i>(pour unix)</i> sont remplacés par des
     * '_' pas de caractères accentués pour le login voir les classes
     * prédéfines, java.lang.String : les méthodes replaceAll, toLowerCase et
     * substring java.lang.Math : la méthode min<br>
     * <b>BlueJ : Menu Aide</b>
     * 
     * @return le login du Cnam simplifié, sans les adaptations dues aux
     *         homonymes...
     */
    public String login() {
        	String sixPremierLettreDuNom = ""; 
		String premierLettreDuPrenom = "";
		StringBuffer result = new StringBuffer();
		StringBuffer result2 = new StringBuffer();

		if(this.nom!=null && this.nom.length()!=0) {
			int index = -1;
			char c = (char)0;

			String chars= "àâäéèêëîïôöùûüç";
			String replace= "aaaeeeeiioouuuc";

			for(int i=0; i<this.nom.length(); i++) {
				c = this.nom.charAt(i);
				if( (index=chars.indexOf(c))!=-1 )
					result.append(replace.charAt(index));
				else
					result.append(c);
			}
		}

		if(this.prenom!=null && this.prenom.length()!=0) {
			int index = -1;
			char c = (char)0;

			String chars= "àâäéèêëîïôöùûüç";
			String replace= "aaaeeeeiioouuuc";

			for(int i=0; i<this.prenom.length(); i++) {
				c = this.prenom.charAt(i);
				if( (index=chars.indexOf(c))!=-1 )
					result2.append(replace.charAt(index));
				else
					result2.append(c);
			}
		}

		if (result.length() > 6) 
		{   
			sixPremierLettreDuNom = result.substring(0, 6);
		}else {
			sixPremierLettreDuNom = result.toString();
		}

		if (result2.length() > 1) 
		{   
			premierLettreDuPrenom = result2.substring(0, 1);
		} 
		else {
			premierLettreDuPrenom = result2.toString();
		}


		return sixPremierLettreDuNom.toLowerCase().replaceAll(" ", "_").replaceAll("-", "_") +"_"+ premierLettreDuPrenom.toLowerCase().replaceAll(" ", "_").replaceAll("-", "_");
	
    }

    /**
     * Lecture du nom de l'auditeur.
     * 
     * @return son nom
     */
    public String nom() {
        return this.nom;// à compléter
    }

    /**
     * Lecture du prénom de l'auditeur.
     * 
     * @return son prénom
     */
    public String prenom() {
        return this.prenom;// à compléter
    }

    /**
     * Lecture du matricule de l'auditeur.
     * 
     * @return son matricule
     */
    public String matricule() {
        return this.matricule;// à compléter
    }

    /**
     * méthode toString ( méthode redéfinie de la classe Object).
     * 
     * @return la concaténation du nom, du prénom et du login, selon cette
     *         syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }

}
