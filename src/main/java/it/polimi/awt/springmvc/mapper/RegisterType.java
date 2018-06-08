//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.05.17 alle 11:54:10 PM CEST 
//


package it.polimi.awt.springmvc.mapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per registerType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="registerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timestamp2" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *       &lt;attribute name="metering-point-id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value-id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="metering-point-name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="primary" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="transformer-ratio" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerType", propOrder = {
    "value",
    "status",
    "timestamp2"
})
public class RegisterType {

    protected float value;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp2;
    @XmlAttribute(name = "metering-point-id")
    protected String meteringPointId;
    @XmlAttribute(name = "value-id")
    protected String valueId;
    @XmlAttribute(name = "metering-point-name")
    protected String meteringPointName;
    @XmlAttribute(name = "unit")
    protected String unit;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "primary")
    protected String primary;
    @XmlAttribute(name = "transformer-ratio")
    protected Float transformerRatio;
    @XmlAttribute(name = "timestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;

    /**
     * Recupera il valore della proprietà value.
     * 
     */
    public float getValue() {
        return value;
    }

    /**
     * Imposta il valore della proprietà value.
     * 
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * Recupera il valore della proprietà status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Imposta il valore della proprietà status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Recupera il valore della proprietà timestamp2.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp2() {
        return timestamp2;
    }

    /**
     * Imposta il valore della proprietà timestamp2.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp2(XMLGregorianCalendar value) {
        this.timestamp2 = value;
    }

    /**
     * Recupera il valore della proprietà meteringPointId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringPointId() {
        return meteringPointId;
    }

    /**
     * Imposta il valore della proprietà meteringPointId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringPointId(String value) {
        this.meteringPointId = value;
    }

    /**
     * Recupera il valore della proprietà valueId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueId() {
        return valueId;
    }

    /**
     * Imposta il valore della proprietà valueId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueId(String value) {
        this.valueId = value;
    }

    /**
     * Recupera il valore della proprietà meteringPointName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringPointName() {
        return meteringPointName;
    }

    /**
     * Imposta il valore della proprietà meteringPointName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringPointName(String value) {
        this.meteringPointName = value;
    }

    /**
     * Recupera il valore della proprietà unit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Imposta il valore della proprietà unit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Recupera il valore della proprietà type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Imposta il valore della proprietà type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Recupera il valore della proprietà primary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimary() {
        return primary;
    }

    /**
     * Imposta il valore della proprietà primary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimary(String value) {
        this.primary = value;
    }

    /**
     * Recupera il valore della proprietà transformerRatio.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTransformerRatio() {
        return transformerRatio;
    }

    /**
     * Imposta il valore della proprietà transformerRatio.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTransformerRatio(Float value) {
        this.transformerRatio = value;
    }

    /**
     * Recupera il valore della proprietà timestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Imposta il valore della proprietà timestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

}
