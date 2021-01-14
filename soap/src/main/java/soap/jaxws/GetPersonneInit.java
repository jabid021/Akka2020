
package soap.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPersonneInit", namespace = "http://soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPersonneInit", namespace = "http://soap/", propOrder = {
    "prenom",
    "nom"
})
public class GetPersonneInit {

    @XmlElement(name = "prenom", namespace = "")
    private String prenom;
    @XmlElement(name = "nom", namespace = "")
    private String nom;

    /**
     * 
     * @return
     *     returns String
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * 
     * @param prenom
     *     the value for the prenom property
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * 
     * @param nom
     *     the value for the nom property
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

}
