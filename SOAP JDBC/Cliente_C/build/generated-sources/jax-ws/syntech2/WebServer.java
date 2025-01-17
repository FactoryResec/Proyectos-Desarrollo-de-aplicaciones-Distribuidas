
package syntech2;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServer", targetNamespace = "http://syntech2/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServer {


    /**
     * 
     * @param resultado
     * @param num1
     * @param operador
     * @param num2
     */
    @WebMethod
    @RequestWrapper(localName = "operation", targetNamespace = "http://syntech2/", className = "syntech2.Operation")
    @ResponseWrapper(localName = "operationResponse", targetNamespace = "http://syntech2/", className = "syntech2.OperationResponse")
    @Action(input = "http://syntech2/WebServer/operationRequest", output = "http://syntech2/WebServer/operationResponse")
    public void operation(
        @WebParam(name = "num1", targetNamespace = "")
        int num1,
        @WebParam(name = "operador", targetNamespace = "")
        String operador,
        @WebParam(name = "num2", targetNamespace = "")
        int num2,
        @WebParam(name = "resultado", targetNamespace = "")
        int resultado);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "actualizar", targetNamespace = "http://syntech2/", className = "syntech2.Actualizar")
    @ResponseWrapper(localName = "actualizarResponse", targetNamespace = "http://syntech2/", className = "syntech2.ActualizarResponse")
    @Action(input = "http://syntech2/WebServer/actualizarRequest", output = "http://syntech2/WebServer/actualizarResponse")
    public List<String> actualizar();

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://syntech2/", className = "syntech2.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://syntech2/", className = "syntech2.HelloResponse")
    @Action(input = "http://syntech2/WebServer/helloRequest", output = "http://syntech2/WebServer/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
