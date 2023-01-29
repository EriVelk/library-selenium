package org.example.controller.document;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class Document {
    XWPFDocument document = new XWPFDocument();

    public void create(){


    }

    public void createParagraph(String texto, double size){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setFirstLineIndent(400);
        paragraph.setAlignment(ParagraphAlignment.DISTRIBUTE);
    }
}
