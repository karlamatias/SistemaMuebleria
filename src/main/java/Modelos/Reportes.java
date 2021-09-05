/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Config.Conexion;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author karlamatias
 */
public class Reportes {

            Connection con;
            PreparedStatement ps;
            ResultSet rs = null;
            Conexion cn = new Conexion();
    public void reporteVentas() throws IOException {
        
        
//creamos el libro uy las hojas de excel para el reporte
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("ReporteVentas");

        try {
            //para que al inicio del reporte apareza el logo de la empresa
            InputStream is = new FileInputStream("MiMuebleria.jpg");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            is.close();

            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();

            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(1, 3);

            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("ReporteVentas");

            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));

            String[] cabecera = new String[]{"Venta", "Producto", "Precio", "Importe"};

            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(4);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            

            int numFilaDatos = 5;

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            //seleccionamos los datos para el reporte 
            String sql = "SELECT * FROM VENTA WHERE fechaVenta BETWEEN ? AND ?";
            try {
            con = cn.Conectar();
           
               ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 2 || a == 3) {
                        CeldaDatos.setCellValue(rs.getDouble(a + 1));
                    } else {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    }
                }

                Cell celdaImporte = filaDatos.createCell(4);
                celdaImporte.setCellStyle(datosEstilo);
                celdaImporte.setCellFormula(String.format("C%d+D%d", numFilaDatos + 1, numFilaDatos + 1));

                numFilaDatos++;

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);

            sheet.setZoom(150);

            FileOutputStream fileOut = new FileOutputStream("ReporteVentas.xlsx");
            book.write(fileOut);
            fileOut.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
