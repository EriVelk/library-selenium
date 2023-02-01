package org.example.controller.document;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.utils.Constants;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Document {
    XWPFDocument document = new XWPFDocument();

    public void create(String title, LinkedHashMap<String, File> images, HashMap<String, String> errors){
        //configDocument();

        createHeader(title);

        images.entrySet().forEach(item->{
            createImage(item.getValue().getAbsolutePath(), item.getKey());
        });

        if(!errors.isEmpty()){
            createParagraph("Errores", Constants.fontArial, 14, true);
            errors.entrySet().forEach(error ->{
                createParagraph(error.getKey() + " - " + error.getValue(), Constants.fontArial, 12, false);
            });
            saveAndCreateDocument(title, Constants.folderError);
        }else{
            saveAndCreateDocument(title, Constants.folderSuccess);
        }
    }

    public void saveAndCreateDocument(String title, String folder){
        try {
            String doc = Constants.pathSaveDocument.concat(folder).concat("\\").concat(title).concat("-").concat(Constants.timestamp).concat(".docx");
            FileOutputStream outputStream = new FileOutputStream(doc);
            document.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createParagraph(String text, String font, double size, boolean bold){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setFirstLineIndent(400);
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun run = paragraph.createRun();
        run.setBold(bold);
        run.setFontFamily(font);
        run.setFontSize(size);
        run.setText(text);
    }

    public void createImage(String fileImage, String titleImage){
        XWPFParagraph image = document.createParagraph();
        XWPFRun run = image.createRun();
        run.setText(titleImage);
        run.setBold(true);
        image.setAlignment(ParagraphAlignment.LEFT);

        try {
            FileInputStream fileInputStream = new FileInputStream(fileImage);
            run.addBreak();
            run.addPicture(fileInputStream, XWPFDocument.PICTURE_TYPE_PNG, fileImage, Units.toEMU(480), Units.toEMU(380));
            fileInputStream.close();
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }

    }

    public void createHeader(String title){
        createParagraph(title, Constants.fontArial, 16, true);
        createParagraph(Constants.titleDate, Constants.fontArial, 14, false);
        createParagraph(Constants.titleTime, Constants.fontArial, 14, false);
    }

    /**
     * This method configure margins of document and settings
     */
    public void configDocument(){
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        CTPageMar pageMar = sectPr.addNewPgMar();
        pageMar.setLeft(BigInteger.valueOf(180L));
        pageMar.setRight(BigInteger.valueOf(180L));
    }
}
