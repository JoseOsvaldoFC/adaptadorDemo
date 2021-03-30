package com.adaptadorDemo.model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author xcheko51x
 */
public class XMLaJSON_json_simple {

    // nomArchivo = "usuarios";


    public static JSONObject convertirListaJSONconJSONSimple(List<Usuario> listaUsuarios) {

        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();

        for(int i = 0 ; i < listaUsuarios.size() ; i++) {
            JSONObject obj1 = new JSONObject();
            obj1.put("name", listaUsuarios.get(i).getName());
            obj1.put("dni", listaUsuarios.get(i).getDni());
            array.add(obj1);
        }

        obj.put("Usuarios", array);

        return obj;
    }

    public static void leerXML(List<Usuario> listaUsuarios, File archivo) {

        try {

            //archivo = new File("usuarios.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);

            document.getDocumentElement().normalize();

            NodeList listaNodo = document.getElementsByTagName("USUARIO");

            for(int i = 0 ; i < listaNodo.getLength() ; i++) {

                Node nodo = listaNodo.item(i);

                if(nodo.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodo;

                    listaUsuarios.add(
                            new Usuario(
                                    element.getElementsByTagName("NAME").item(0).getTextContent(),
                                    element.getElementsByTagName("DNI").item(0).getTextContent()
                            )
                    );

                }

            }


        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}