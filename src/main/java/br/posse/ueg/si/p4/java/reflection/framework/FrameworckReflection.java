/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.posse.ueg.si.p4.java.reflection.framework;

import br.posse.ueg.si.p4.java.reflection.model.Administrador;
import br.posse.ueg.si.p4.java.reflection.model.Auxiliar;
import br.posse.ueg.si.p4.java.reflection.dao.Dao;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 *
 * @author willi
 */
public class FrameworckReflection {
    public static void main(String[] args) throws SQLException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, Exception {
        Class<Administrador> classAdm = Administrador.class;
        Class<Auxiliar> classAux = Auxiliar.class;
        Dao dao = new Dao();

        Administrador adm = new Administrador(null, "Willian Pereira de Jesus", 23, "623488111");
        Auxiliar aux = new Auxiliar(1, "Will", 16081997, "Pessoa muito emotiva");

        String StrAdm = adm.toString();
        String StrAuxiliar = aux.toString();

//        dao.createTable(classAdm);
//        dao.createTable(classAux);
//        dao.save(classAdm, StrAdm);
//        dao.save(classAux, StrAuxiliar);
//        dao.Update(classAdm, "nome", 1, "wpj");
//        dao.delete(classAdm,1);
        
    }
}
