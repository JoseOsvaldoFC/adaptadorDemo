package com.adaptadorDemo.service;

import com.adaptadorDemo.AdaptadorDemoApplication;
import com.adaptadorDemo.model.Usuario;
import com.adaptadorDemo.model.XMLaJSON_json_simple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdaptadorServiceImp implements IAdaptadorService{

    private static Logger LOG = LoggerFactory.getLogger(AdaptadorDemoApplication.class);

    static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    static XMLaJSON_json_simple conversor = new XMLaJSON_json_simple();

    @Override
    public void convertir(File archivoXml) {

        conversor.leerXML(listaUsuarios, archivoXml);
        System.out.println(conversor.convertirListaJSONconJSONSimple(listaUsuarios));

    }
}
