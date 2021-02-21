/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.posse.ueg.si.p4.java.reflection.dao;

import br.posse.ueg.si.p4.java.reflection.connection.ConnectionFactory;
import br.posse.ueg.si.p4.java.reflection.validator.ValidationJavaSql;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author willi
 */
public class Dao {

    Connection con = new ConnectionFactory().getConexaoMySQL();

    public Dao() throws Exception {
        ConnectionFactory.getConexaoMySQL();

    }

    public <T> void createTable(Class<T> classGenericType) {
        try {

            System.out.println(ConnectionFactory.statusConection());

            ValidationJavaSql validate = new ValidationJavaSql();
            Field FieldList[] = classGenericType.getDeclaredFields();

            String tableCreate = "CREATE TABLE IF NOT EXISTS " + classGenericType.getSimpleName() + "(";
            tableCreate += "" + "\n" + FieldList[1 - 1].getName() + " "
                    + validate.validatorConversor(FieldList[1 - 1].getType()
                            .toString().replaceAll("class java.lang.", "")) + " AUTO_INCREMENT,";

            for (int index = 2; index <= FieldList.length; index++) {

                tableCreate += "" + "\n" + FieldList[index - 1].getName() + " " + validate.validatorConversor(FieldList[index - 1].getType().toString().replaceAll("class java.lang.", "")) + ",";

            }
            tableCreate += "" + "\n" + "PRIMARY KEY(" + FieldList[1 - 1].getName() + ")";
            tableCreate += "\n )";
            PreparedStatement stmt = con.prepareStatement(tableCreate);
            stmt.execute();
            stmt.close();

            System.out.println(tableCreate);
            System.out.println("\n tabela `" + classGenericType.getSimpleName() + "` criada com Sucesso! \n");

        } catch (SQLException e) {

            System.out.println("Tabela `" + classGenericType.getSimpleName() + "` não foi criada \n" + e);

        }
    }

    public <T> void save(Class<T> classGenericType, String lista) throws IllegalArgumentException, IllegalAccessException {
        try {
            System.out.println(ConnectionFactory.statusConection());
            Field FieldList[] = classGenericType.getDeclaredFields();

            String sqlSave = "INSERT INTO " + classGenericType.getSimpleName() + "(";
            for (int index = 1; index <= FieldList.length; index++) {
                String parameterSql = FieldList[index - 1].getName();

                sqlSave += "`" + parameterSql + "`,";
            }
            sqlSave = sqlSave.substring(0, sqlSave.length() - 1);
            sqlSave += ")";
            sqlSave += "VALUES(";

            sqlSave += lista + ")";
            PreparedStatement stmt = con.prepareStatement(sqlSave);
            stmt.execute();
            stmt.close();

            System.out.println(sqlSave);
            System.out.println("\n Dados salvo com sucesso! \n ");
        } catch (SQLException e) {
            System.out.println("Não foi possivel salvar dados: " + e);
        }
    }

    public <T> void delete(Class<T> classGenericType, Integer id) throws IllegalArgumentException, IllegalAccessException, SQLException {
        try {
            System.out.println(ConnectionFactory.statusConection());
            Field FieldList[] = classGenericType.getDeclaredFields();
            ValidationJavaSql validator = new ValidationJavaSql();
            String sqlDelete = "DELETE FROM `" + classGenericType.getSimpleName() + "` WHERE "
                    + validator.validatorConversor(FieldList[1 - 1].getName()) + " = " + id;

            System.out.println(sqlDelete);

            PreparedStatement stmt = con.prepareStatement(sqlDelete);
            stmt.execute();
            stmt.close();
            System.out.println("\n Deltado com sucesso \n");
        } catch (SQLException e) {
            System.out.println("Não foi possivel Deletar: " + e);
        }

    }

    public <T> void findListAll(Class<T> classGenericType) {
        try {
            System.out.println(ConnectionFactory.statusConection());
            Field FieldList[] = classGenericType.getDeclaredFields();
            String selectAll = "SELECT * FROM `" + classGenericType.getSimpleName() + "`";
            System.out.println(selectAll);
            PreparedStatement stmt = con.prepareStatement(selectAll);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\n Resultado da listagem: \n");
            while (rs.next()) {
                for (int index = 1; index <= FieldList.length; index++) {

                    FieldList[1 - 1].getName();
                    System.out.print(FieldList[index - 1].getName() + ":");

                    System.out.print(rs.getString(index) + " ");

                }
                System.out.println("\n");
            }

            System.out.println("\n Listado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha ao listar: " + e);
        }
    }

    public <T> void Update(Class<T> classGenericType, String atribute, Integer id, String value) {
        try {
            System.out.println(ConnectionFactory.statusConection());
            Field FieldList[] = classGenericType.getDeclaredFields();
            String sqlUpdate = "UPDATE `" + classGenericType.getSimpleName() + "` SET `"
                    + atribute + "` = '" + value + "' WHERE `" + classGenericType.getSimpleName() + "`.`" + FieldList[1 - 1].getName() + "` = " + id;
            System.out.println(sqlUpdate);
            PreparedStatement stmt = con.prepareStatement(sqlUpdate);
            stmt.execute();
            stmt.close();
            System.out.println("\n Atualização efetuada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Não foi possivel atualizar: " + e);
        }
    }

}
