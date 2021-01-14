
package services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getInfoResponse", namespace = "http://services/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInfoResponse", namespace = "http://services/")
public class GetInfoResponse {

    @XmlElement(name = "ville", namespace = "")
    private model.Ville ville;

    /**
     * 
     * @return
     *     returns Ville
     */
    public model.Ville getVille() {
        return this.ville;
    }

    /**
     * 
     * @param ville
     *     the value for the ville property
     */
    public void setVille(model.Ville ville) {
        this.ville = ville;
    }

}
