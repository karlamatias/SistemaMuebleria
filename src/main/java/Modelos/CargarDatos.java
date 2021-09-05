/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Config.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author karlamatias
 */
public class CargarDatos {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    //metodo para leer el archivo que agregamos 
    public void leer() {
        try {
            
            FileInputStream file = new FileInputStream(new File("datafile"));

            //para extrar la informacion del archivo seleccionado.
            XSSFWorkbook wb = new XSSFWorkbook(file);
            //indicamos con que hoja trabajaremos
            XSSFSheet sheet = wb.getSheetAt(0);

            //control cuantas filas y columnas tiene la hoja 
            int numFilas = sheet.getLastRowNum();

            //extraer la informacion de la filaa
            for (int a = 0; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);
                int numCols = fila.getLastCellNum();

                //extraer la informacion de la columna
                for (int b = 0; b < numCols; b++) {
                    Cell celda = fila.getCell(b);

                    //especificar que tipo de celda vamos a leer, pueden ser texto, entero, double, etc
                    switch(celda.getCellType().toString()) {
                        case "NUMERIC":
                            System.out.print(celda.getNumericCellValue() + " ");
                            break;

                        case "STRING":
                            System.out.print(celda.getStringCellValue() + " ");
                            break;
                        default:
                    }

                }

                System.out.println("");

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //metodo para cargar los archivos a la base de datos
    public void cargar() throws IOException {
        String sql = "INSERT INTO PIEZAS (IDPieza, tipoPieza,CantidadExistenteP,precio) VALUES (?,?,?,?)";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            FileInputStream file = new FileInputStream(new File("datafile"));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);

                ps.setInt(1, (int) fila.getCell(0).getNumericCellValue());
                ps.setString(2, fila.getCell(1).getStringCellValue());
                ps.setInt(3, (int) fila.getCell(2).getNumericCellValue());
                ps.setDouble(4, fila.getCell(3).getNumericCellValue());
                ps.executeUpdate();
            }

        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(CargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
