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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per dynamic-dataType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="dynamic-dataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="registers" type="{}registersType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dynamic-dataType", propOrder = {
    "registers"
})
public class DynamicDataType {

    @XmlElement(required = true)
    protected RegistersType registers;

    /**
     * Recupera il valore della proprietà registers.
     * 
     * @return
     *     possible object is
     *     {@link RegistersType }
     *     
     */
    public RegistersType getRegisters() {
        return registers;
    }

    /**
     * Imposta il valore della proprietà registers.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistersType }
     *     
     */
    public void setRegisters(RegistersType value) {
        this.registers = value;
    }

}
