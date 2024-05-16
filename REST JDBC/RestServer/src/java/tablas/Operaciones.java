/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "operaciones", catalog = "calcubd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operaciones.findAll", query = "SELECT o FROM Operaciones o")
    , @NamedQuery(name = "Operaciones.findById", query = "SELECT o FROM Operaciones o WHERE o.id = :id")
    , @NamedQuery(name = "Operaciones.findByNum1", query = "SELECT o FROM Operaciones o WHERE o.num1 = :num1")
    , @NamedQuery(name = "Operaciones.findByOperador", query = "SELECT o FROM Operaciones o WHERE o.operador = :operador")
    , @NamedQuery(name = "Operaciones.findByNum2", query = "SELECT o FROM Operaciones o WHERE o.num2 = :num2")
    , @NamedQuery(name = "Operaciones.findByResultado", query = "SELECT o FROM Operaciones o WHERE o.resultado = :resultado")})
public class Operaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num1")
    private int num1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "operador")
    private String operador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num2")
    private int num2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resultado")
    private int resultado;

    public Operaciones() {
    }

    public Operaciones(Integer id) {
        this.id = id;
    }

    public Operaciones(Integer id, int num1, String operador, int num2, int resultado) {
        this.id = id;
        this.num1 = num1;
        this.operador = operador;
        this.num2 = num2;
        this.resultado = resultado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operaciones)) {
            return false;
        }
        Operaciones other = (Operaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.Operaciones[ id=" + id + " ]";
    }
    
}
