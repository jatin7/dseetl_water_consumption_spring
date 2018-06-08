//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.05.17 alle 11:54:10 PM CEST 
//


package it.polimi.awt.springmvc.mapper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polimi.awt.springmvc.mapper package. 
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

    private final static QName _EnergyDataExchangeFormat_QNAME = new QName("", "energy-data-exchange-format");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polimi.awt.springmvc.mapper
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnergyDataExchangeFormatType }
     * 
     */
    public EnergyDataExchangeFormatType createEnergyDataExchangeFormatType() {
        return new EnergyDataExchangeFormatType();
    }

    /**
     * Create an instance of {@link DocumentInformationType }
     * 
     */
    public DocumentInformationType createDocumentInformationType() {
        return new DocumentInformationType();
    }

    /**
     * Create an instance of {@link DynamicDataType }
     * 
     */
    public DynamicDataType createDynamicDataType() {
        return new DynamicDataType();
    }

    /**
     * Create an instance of {@link RegistersType }
     * 
     */
    public RegistersType createRegistersType() {
        return new RegistersType();
    }

    /**
     * Create an instance of {@link RegisterType }
     * 
     */
    public RegisterType createRegisterType() {
        return new RegisterType();
    }

    /**
     * Create an instance of {@link TimeZoneInformationType }
     * 
     */
    public TimeZoneInformationType createTimeZoneInformationType() {
        return new TimeZoneInformationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnergyDataExchangeFormatType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "energy-data-exchange-format")
    public JAXBElement<EnergyDataExchangeFormatType> createEnergyDataExchangeFormat(EnergyDataExchangeFormatType value) {
        return new JAXBElement<EnergyDataExchangeFormatType>(_EnergyDataExchangeFormat_QNAME, EnergyDataExchangeFormatType.class, null, value);
    }

}
