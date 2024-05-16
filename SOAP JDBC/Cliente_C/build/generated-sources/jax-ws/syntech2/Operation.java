
package syntech2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para operation complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="operation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="num1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="num2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operation", propOrder = {
    "num1",
    "operador",
    "num2",
    "resultado"
})
public class Operation {

    protected int num1;
    protected String operador;
    protected int num2;
    protected int resultado;

    /**
     * Obtiene el valor de la propiedad num1.
     * 
     */
    public int getNum1() {
        return num1;
    }

    /**
     * Define el valor de la propiedad num1.
     * 
     */
    public void setNum1(int value) {
        this.num1 = value;
    }

    /**
     * Obtiene el valor de la propiedad operador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperador() {
        return operador;
    }

    /**
     * Define el valor de la propiedad operador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperador(String value) {
        this.operador = value;
    }

    /**
     * Obtiene el valor de la propiedad num2.
     * 
     */
    public int getNum2() {
        return num2;
    }

    /**
     * Define el valor de la propiedad num2.
     * 
     */
    public void setNum2(int value) {
        this.num2 = value;
    }

    /**
     * Obtiene el valor de la propiedad resultado.
     * 
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * Define el valor de la propiedad resultado.
     * 
     */
    public void setResultado(int value) {
        this.resultado = value;
    }

}
