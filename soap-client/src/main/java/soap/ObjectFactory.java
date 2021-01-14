
package soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHelloResponse_QNAME = new QName("http://soap/", "sayHelloResponse");
    private final static QName _GetPersonneInitResponse_QNAME = new QName("http://soap/", "getPersonneInitResponse");
    private final static QName _GetPersonneInit_QNAME = new QName("http://soap/", "getPersonneInit");
    private final static QName _SayHello_QNAME = new QName("http://soap/", "sayHello");
    private final static QName _GetPersonne_QNAME = new QName("http://soap/", "getPersonne");
    private final static QName _GetPersonneResponse_QNAME = new QName("http://soap/", "getPersonneResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link GetPersonne }
     * 
     */
    public GetPersonne createGetPersonne() {
        return new GetPersonne();
    }

    /**
     * Create an instance of {@link GetPersonneResponse }
     * 
     */
    public GetPersonneResponse createGetPersonneResponse() {
        return new GetPersonneResponse();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link GetPersonneInit }
     * 
     */
    public GetPersonneInit createGetPersonneInit() {
        return new GetPersonneInit();
    }

    /**
     * Create an instance of {@link GetPersonneInitResponse }
     * 
     */
    public GetPersonneInitResponse createGetPersonneInitResponse() {
        return new GetPersonneInitResponse();
    }

    /**
     * Create an instance of {@link Personne }
     * 
     */
    public Personne createPersonne() {
        return new Personne();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonneInitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getPersonneInitResponse")
    public JAXBElement<GetPersonneInitResponse> createGetPersonneInitResponse(GetPersonneInitResponse value) {
        return new JAXBElement<GetPersonneInitResponse>(_GetPersonneInitResponse_QNAME, GetPersonneInitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonneInit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getPersonneInit")
    public JAXBElement<GetPersonneInit> createGetPersonneInit(GetPersonneInit value) {
        return new JAXBElement<GetPersonneInit>(_GetPersonneInit_QNAME, GetPersonneInit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getPersonne")
    public JAXBElement<GetPersonne> createGetPersonne(GetPersonne value) {
        return new JAXBElement<GetPersonne>(_GetPersonne_QNAME, GetPersonne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getPersonneResponse")
    public JAXBElement<GetPersonneResponse> createGetPersonneResponse(GetPersonneResponse value) {
        return new JAXBElement<GetPersonneResponse>(_GetPersonneResponse_QNAME, GetPersonneResponse.class, null, value);
    }

}
