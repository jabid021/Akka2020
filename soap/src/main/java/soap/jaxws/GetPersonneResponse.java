
package soap.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPersonneResponse", namespace = "http://soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPersonneResponse", namespace = "http://soap/")
public class GetPersonneResponse {

    @XmlElement(name = "personne", namespace = "")
    private model.Personne personne;

    /**
     * 
     * @return
     *     returns Personne
     */
    public model.Personne getPersonne() {
        return this.personne;
    }

    /**
     * 
     * @param personne
     *     the value for the personne property
     */
    public void setPersonne(model.Personne personne) {
        this.personne = personne;
    }

}
