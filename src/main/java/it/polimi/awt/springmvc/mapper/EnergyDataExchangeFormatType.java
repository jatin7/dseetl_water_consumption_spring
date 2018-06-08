//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.05.17 alle 11:54:10 PM CEST 
//


package it.polimi.awt.springmvc.mapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per energy-data-exchange-formatType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="energy-data-exchange-formatType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="document-information" type="{}document-informationType"/>
 *         &lt;element name="time-zone-information" type="{}time-zone-informationType"/>
 *         &lt;element name="dynamic-data" type="{}dynamic-dataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="energy-data-exchange-format")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "energy-data-exchange-formatType", propOrder = {
    "documentInformation",
    "timeZoneInformation",
    "dynamicData"
})
public class EnergyDataExchangeFormatType {

    @XmlElement(name = "document-information", required = true)
    protected DocumentInformationType documentInformation;
    @XmlElement(name = "time-zone-information", required = true)
    protected TimeZoneInformationType timeZoneInformation;
    @XmlElement(name = "dynamic-data", required = true)
    protected DynamicDataType dynamicData;

    /**
     * Recupera il valore della proprietà documentInformation.
     * 
     * @return
     *     possible object is
     *     {@link DocumentInformationType }
     *     
     */
    public DocumentInformationType getDocumentInformation() {
        return documentInformation;
    }

    /**
     * Imposta il valore della proprietà documentInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentInformationType }
     *     
     */
    public void setDocumentInformation(DocumentInformationType value) {
        this.documentInformation = value;
    }

    /**
     * Recupera il valore della proprietà timeZoneInformation.
     * 
     * @return
     *     possible object is
     *     {@link TimeZoneInformationType }
     *     
     */
    public TimeZoneInformationType getTimeZoneInformation() {
        return timeZoneInformation;
    }

    /**
     * Imposta il valore della proprietà timeZoneInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeZoneInformationType }
     *     
     */
    public void setTimeZoneInformation(TimeZoneInformationType value) {
        this.timeZoneInformation = value;
    }

    /**
     * Recupera il valore della proprietà dynamicData.
     * 
     * @return
     *     possible object is
     *     {@link DynamicDataType }
     *     
     */
    public DynamicDataType getDynamicData() {
        return dynamicData;
    }

    /**
     * Imposta il valore della proprietà dynamicData.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicDataType }
     *     
     */
    public void setDynamicData(DynamicDataType value) {
        this.dynamicData = value;
    }

}
