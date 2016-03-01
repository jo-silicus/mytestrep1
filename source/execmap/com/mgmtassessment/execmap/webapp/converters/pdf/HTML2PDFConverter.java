/**
 * 
 *
 * @author singhrau
 */
package com.mgmtassessment.execmap.webapp.converters.pdf;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


import org.w3c.tidy.Node;
import org.w3c.tidy.Tidy;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class HTML2PDFConverter {

    /**
     * @param htmlFileName
     * @return
     */
    public int html2xml(String repPath, String htmlFileName) {

        String xmlFileName = htmlFileName;
        xmlFileName = xmlFileName.replace(".html", ".xml");
        if (xmlFileName == null) {
            return 1;
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(repPath + "\\" + htmlFileName);
            out = new FileOutputStream(repPath + "\\" + xmlFileName);
            Tidy t = new Tidy();
            t.setXHTML(true);
            t.setNumEntities(true);
            Node n = t.parse(in, out);
            in.close();
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException i) {
            i.printStackTrace();
        }

        return 0;
    }

    /**
     * Determine if this is an html tag need to be processed or not
     * 
     * @param name
     *            tag name
     * @return boolean true if this is h1, h2, h3, h4, h5, or h6; false
     *         otherwise
     */
    private boolean htmlTags(String name) {

        String[] htmlTags = { "head",  "tr", "title", "p", "b", "i", "u",
                "table", "td", "hr", "font", "img", "center" };
        int matchTag = 0;
        while (matchTag < htmlTags.length) {
            if (name.equals(htmlTags[matchTag]))
                return true;
            matchTag++;
        }
        return false;
    }

public int xml2pdfForLead(String repPath, String imgPath, String xmlFileName, String rptId) {

        
        String pdfFileName = xmlFileName;
        pdfFileName = pdfFileName.replaceFirst(".xml", ".pdf");
        if (pdfFileName == null) {
            return 1;
        }
        Paragraph paraGraph = null;
        int paraStart = 0, bold = 0, itallic = 0, align = 0, underLine = 0;
        Document document = new Document(PageSize.A4, 80, 50, 30, 65);
        int outerTD = 0, outermostTD = 0, innerTD = 0;
        int outerTDContent = 0, outermostTDContent = 0, innerTDContent = 0;
        PdfPTable outermostTable = null;// cols =1
        PdfPTable outerTable = null;// cols =2
        PdfPTable innermostTable = null;// cols =6
        final String CHUNK_1STPART = "00";// for the Bars to be displayed
        int returnValue = 0;
        final String fontValue = FontFactory.TIMES;
        int fontSize = 10;

        final Color fontColor = Color.BLACK;// color to be followed throughout
        // the doc
        final int fontStyle = Font.NORMAL;// style to be followed throughout
        // the doc

        try {

            try {

                PdfWriter newpdf = PdfWriter.getInstance(document,
                        new FileOutputStream(repPath + "\\" + pdfFileName));
                XMLStreamReader parser = XMLInputFactory
                        .newInstance()
                        .createXMLStreamReader(new FileInputStream(repPath + "\\" + xmlFileName));
                document.open();
                paraGraph = new Paragraph("", FontFactory.getFont(fontValue,
                        fontSize, fontStyle, fontColor));
                int inHeader = 0;
                for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser
                        .next()) {
                    switch (event) {
                        case XMLStreamConstants.START_ELEMENT: // Processing
                                                   // the Start of any TAG here

                            String paragString = parser.getLocalName();
                            if (htmlTags(paragString)) {
                                if ("img".equalsIgnoreCase(paragString)) {
                                    int hrAttributeCount = parser
                                            .getAttributeCount();
                                    for (int hrattribnames = 0; hrattribnames < hrAttributeCount; hrattribnames++) {
                                        String hrattributeName = parser
                                                .getAttributeLocalName(hrattribnames);
                                        if ("src".equalsIgnoreCase(hrattributeName)) {
                                            String attribvalue = parser
                                                    .getAttributeValue(hrattribnames);
                                            Image jpg = Image
                                                    .getInstance(attribvalue);
                                            jpg
                                                    .setAlignment(Image.ALIGN_CENTER);
                                            document.add(jpg);
                                        }
                                    }
                                }
                                if ("font".equalsIgnoreCase(paragString)) {
                                    int hrAttributeCount = parser
                                            .getAttributeCount();
                                    for (int hrattribnames = 0; hrattribnames < hrAttributeCount; hrattribnames++) {
                                        String hrattributeName = parser
                                                .getAttributeLocalName(hrattribnames);
                                        if ("size".equalsIgnoreCase(hrattributeName)) {
                                            String attribvalue = parser
                                                    .getAttributeValue(hrattribnames);
                                            fontSize = Integer
                                                    .parseInt(attribvalue);
                                            switch (fontSize) {
                                                case 1:
                                                    fontSize = 8;

                                                    break;
                                                case 2:
                                                    fontSize = 10;

                                                    break;
                                                case 3:
                                                    fontSize = 12;

                                                    break;
                                                case 4:
                                                    fontSize = 14;

                                                    break;
                                                case 5:
                                                    fontSize = 16;

                                                    break;
                                                case 6:
                                                    fontSize = 20;

                                                    break;
                                                case 7:
                                                    fontSize = 30;

                                                    break;

                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if ("hr".equalsIgnoreCase(paragString)) {
                                    innerTDContent = 1;
                                }

                                if ("table".equalsIgnoreCase(paragString)) {
                                    if (outermostTable != null) {
                                        if (outerTable != null) {
                                            innermostTable = new PdfPTable(4);

                                            innerTD = 0;
                                        } else {
                                                outerTable = new PdfPTable(2);
                                            
                                            
                                            outerTD = 0;
                                        }
                                    } else {
                                        if ("4".equalsIgnoreCase(rptId)) {
                                            outermostTable = new PdfPTable(2);
                                        } else {
                                           outermostTable = new PdfPTable(1);
                                        }
                                        
                                        outermostTD = 0;
                                    }

                                }
                                if ("td".equalsIgnoreCase(paragString)) {
                                    if (innermostTable != null) {
                                        innerTD++;
                                        innerTDContent = 0;
                                    } else {
                                        if (outerTable != null) {
                                            outerTD++;
                                            outerTDContent = 0;
                                        } else {
                                            outermostTD++;
                                            outermostTDContent = 0;
                                        }
                                    }
                                }

                                
                                if ("b".equalsIgnoreCase(paragString)) {
                                    bold = 1;
                                }
                                if ("i".equalsIgnoreCase(paragString)) {
                                    itallic = 1;

                                }
                                if ("u".equalsIgnoreCase(paragString)) {
                                    underLine = 1;

                                }
                                if ("p".equalsIgnoreCase(paragString)) {
                                    int attribCount = parser
                                            .getAttributeCount();
                                    for (int attribnames = 0; attribnames < attribCount; attribnames++) {
                                        String attributeName = parser
                                                .getAttributeLocalName(attribnames);
                                        if ("align".equalsIgnoreCase(attributeName)) {
                                            String attributeValue = parser
                                                    .getAttributeValue(attribnames);
                                            paraGraph
                                                    .setAlignment(Element.ALIGN_JUSTIFIED);
                                            document.add(paraGraph);
                                            paraGraph = new Paragraph("",
                                                    FontFactory.getFont(
                                                            fontValue,
                                                            fontSize,
                                                            fontStyle,
                                                            fontColor));

                                            if ("center".equalsIgnoreCase(attributeValue)) {
                                                align = 1;
                                            }
                                            if ("right".equalsIgnoreCase(attributeValue)) {
                                                align = 2;
                                            }
                                            if ("left".equalsIgnoreCase(attributeValue)) {
                                                align = 3;
                                            }

                                        }
                                    }

                                    paraStart = 1;
                                    paraGraph.add("\n");

                                }

                                inHeader++;
                            }
                            break;
                        case XMLStreamConstants.END_ELEMENT:// Processing the
                                                            // End of
                            // any TAG here
                            String paragclose = parser.getLocalName();
                            if (htmlTags(paragclose)) {
                                if ("font".equalsIgnoreCase(paragclose)) {

                                    fontSize = 10;

                                }
                                if ("p".equalsIgnoreCase(paragclose)) {
                                    if (align == 1) {
                                        paraGraph
                                                .setAlignment(Element.ALIGN_CENTER);
                                        document.add(paraGraph);
                                        paraGraph = new Paragraph("",
                                                FontFactory.getFont(fontValue,
                                                        fontSize, fontStyle,
                                                        fontColor));
                                    }
                                    if (align == 2) {
                                        paraGraph
                                                .setAlignment(Element.ALIGN_RIGHT);
                                        document.add(paraGraph);
                                        paraGraph = new Paragraph("",
                                                FontFactory.getFont(fontValue,
                                                        fontSize, fontStyle,
                                                        fontColor));
                                    }
                                    if (align == 3) {
                                        paraGraph
                                                .setAlignment(Element.ALIGN_LEFT);
                                        document.add(paraGraph);
                                        paraGraph = new Paragraph("",
                                                FontFactory.getFont(fontValue,
                                                        fontSize, fontStyle,
                                                        fontColor));
                                    }

                                    align = 0;
                                    paraStart--;
                                }
                                if ("td".equalsIgnoreCase(paragclose)) {
                                    if (innerTD == 0) {
                                        if (outerTD == 0) {

                                            if (outermostTDContent == 0)

                                            {
                                                outermostTable.addCell("");
                                            }
                                            outermostTD--;
                                            outermostTDContent = 0;
                                        } else {
                                            if (outerTDContent == 0) {
                                                outerTable.addCell("");
                                            }

                                            outerTD--;
                                            outerTDContent = 0;
                                        }
                                    } else {

                                        if (innerTDContent == 0) {
                                            // innermostTable.addCell("");
                                        }
                                        innerTDContent = 0;
                                        innerTD--;
                                    }

                                }
                                if ("table".equalsIgnoreCase(paragclose)) {
                                    if (innermostTable == null) {
                                        if (outerTable == null) {
                                            paraGraph.add(outermostTable);
                                            outermostTable = null;
                                            outermostTD = outerTD = innerTD = 0;
                                            outermostTDContent = outerTDContent = innerTDContent = 0;

                                        } else {
                                            outermostTable.addCell(outerTable);
                                            outerTable = null;
                                            outermostTDContent = 1;
                                            outerTDContent = innerTDContent = 0;
                                            outerTD = innerTD = 0;
                                        }
                                    } else {

                                        outerTable.addCell(innermostTable);
                                        innermostTable = null;
                                        outerTDContent = 1;
                                        innerTD = 0;
                                        innerTDContent = 0;

                                    }

                                }

                                if ("b".equalsIgnoreCase(paragclose)) {
                                    bold = 0;
                                }
                                if ("i".equalsIgnoreCase(paragclose)) {
                                    itallic = 0;

                                }
                                if ("u".equalsIgnoreCase(paragclose)) {
                                    underLine = 0;

                                }
                                inHeader--;
                                if (inHeader == 0)
                                    System.out.println();
                            }
                            break;
                        case XMLStreamConstants.CHARACTERS:// Processing the
                            // charactes in the start and closing any TAG here

                            int addcol = outerTD + outermostTD + innerTD;
                            if ((paraStart > 0) || (addcol > 0)) {
                                String outputString = parser.getText();
                                boolean whiteSpace = parser.isWhiteSpace();
                                outputString = outputString.replaceAll("\n",
                                        " ");

                                int fontUsed = Font.NORMAL;
                                if ((bold == 1) && (itallic == 1)
                                        && (underLine == 1)) {
                                    fontUsed = Font.BOLDITALIC;
                                }

                                if ((bold == 1) && (itallic == 1)
                                        && (underLine == 0)) {
                                    fontUsed = Font.BOLDITALIC;
                                }
                                if ((bold == 1) && (itallic == 0)
                                        && (underLine == 1)) {
                                    fontUsed = Font.BOLDITALIC;
                                }
                                if ((bold == 0) && (itallic == 1)
                                        && (underLine == 1)) {
                                    fontUsed = Font.ITALIC;
                                }
                                if ((bold == 1) && (itallic == 0)
                                        && (underLine == 0)) {
                                    fontUsed = Font.BOLD;
                                }
                                if ((bold == 0) && (itallic == 1)
                                        && (underLine == 0)) {
                                    fontUsed = Font.ITALIC;
                                }
                                if ((bold == 0) && (itallic == 0)
                                        && (underLine == 1)) {
                                    fontUsed = Font.UNDERLINE;
                                }
                                if (addcol > 0) {
                                    if (!"  ".equalsIgnoreCase(outputString)
                                            && (!whiteSpace)) {
                                        Phrase newPhrase = new Phrase(
                                                new Chunk(outputString,
                                                        FontFactory.getFont(
                                                                fontValue,
                                                                fontSize,
                                                                fontUsed,
                                                                fontColor)));
                                        if (innermostTable != null) {

                                            PdfPCell newCell = new PdfPCell(
                                                    newPhrase);
                                            newCell.setBorderColor(Color.WHITE);
                                            innermostTable.addCell(newCell);
                                            int graphValue = (int) Float
                                                    .parseFloat(outputString
                                                            .trim());
                                            Chunk backgroundColor = new Chunk(
                                                    CHUNK_1STPART
                                                            + CHUNK_1STPART
                                                            + CHUNK_1STPART);
                                            backgroundColor
                                                    .setUnderline(
                                                            Color.BLUE,
                                                            0.0f,
                                                            0.7f,
                                                            0.0f,
                                                            0.4f,
                                                            PdfContentByte.LINE_CAP_PROJECTING_SQUARE);
                                            backgroundColor
                                                    .setTextRenderMode(
                                                            PdfContentByte.TEXT_RENDER_MODE_INVISIBLE,
                                                            PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE,
                                                            Color.BLACK);
                                            Chunk backgroundhalfColor = new Chunk(
                                                    CHUNK_1STPART
                                                            + CHUNK_1STPART);
                                            backgroundhalfColor
                                                    .setUnderline(
                                                            Color.BLUE,
                                                            0.0f,
                                                            0.7f,
                                                            0.0f,
                                                            0.4f,
                                                            PdfContentByte.LINE_CAP_PROJECTING_SQUARE);
                                            backgroundhalfColor
                                                    .setTextRenderMode(
                                                            PdfContentByte.TEXT_RENDER_MODE_INVISIBLE,
                                                            PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE,
                                                            Color.BLACK);

                                            Chunk additionalbackgroundColor = new Chunk(
                                                    CHUNK_1STPART);
                                            additionalbackgroundColor
                                                    .setTextRenderMode(
                                                            PdfContentByte.TEXT_RENDER_MODE_INVISIBLE,
                                                            PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE,
                                                            Color.BLACK);
                                            additionalbackgroundColor
                                                    .setUnderline(
                                                            Color.GREEN,
                                                            0.0f,
                                                            0.7f,
                                                            0.0f,
                                                            0.4f,
                                                            PdfContentByte.LINE_CAP_PROJECTING_SQUARE);

                                            Phrase bckfillPhrase = new Phrase();
                                            bckfillPhrase.add(backgroundColor);
                                            Phrase bckIstHalffillPhrase = new Phrase();
                                            Phrase bck2ndhalffillPhrase = new Phrase();

                                            bckIstHalffillPhrase
                                                    .add(additionalbackgroundColor);
                                            bckIstHalffillPhrase
                                                    .add(backgroundhalfColor);

                                            bck2ndhalffillPhrase
                                                    .add(backgroundhalfColor);
                                            bck2ndhalffillPhrase
                                                    .add(additionalbackgroundColor);

                                            if (graphValue < 4) {
                                                newCell = new PdfPCell(
                                                        bckIstHalffillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                                newCell = new PdfPCell(
                                                        bckfillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                                innermostTable.addCell(newCell);

                                            }
                                            if (graphValue == 4) {
                                                newCell = new PdfPCell(
                                                        bck2ndhalffillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                                newCell = new PdfPCell(
                                                        bckfillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                                innermostTable.addCell(newCell);

                                            }
                                            if (graphValue == 5) {
                                                newCell = new PdfPCell(
                                                        bckfillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                                newCell = new PdfPCell(
                                                        bckIstHalffillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                                newCell = new PdfPCell(
                                                        bckfillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                            }
                                            if (graphValue == 6) {
                                                newCell = new PdfPCell(
                                                        bckfillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                                newCell = new PdfPCell(
                                                        bck2ndhalffillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                                newCell = new PdfPCell(
                                                        bckfillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                            }

                                            if (graphValue > 6) {
                                                newCell = new PdfPCell(
                                                        bckfillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);
                                                innermostTable.addCell(newCell);
                                                newCell = new PdfPCell(
                                                        bckIstHalffillPhrase);
                                                newCell
                                                        .setBorderColor(Color.WHITE);
                                                innermostTable.addCell(newCell);

                                            }

                                            innerTDContent = 1;
                                        } else if (outerTable != null) {
                                            outerTable.addCell(newPhrase);
                                            outerTDContent = 1;
                                        } else

                                        if (outermostTable != null) {
                                            outermostTable.addCell(newPhrase);
                                            outermostTDContent = 1;
                                        }

                                    }
                                } else if (!whiteSpace) {
                                    paraGraph.add(new Chunk(outputString,
                                            FontFactory.getFont(fontValue,
                                                    fontSize, fontUsed,
                                                    fontColor)));
                                }
                            }
                            break;
                        case XMLStreamConstants.CDATA:
                            break;
                    } // end switch
                } // end while
                parser.close();
                paraGraph.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(paraGraph);
            }
            catch (DocumentException e) {

                e.printStackTrace();
                returnValue = 1;
            }
            catch (FactoryConfigurationError e) {

                e.printStackTrace();
                returnValue = 1;
            }
        }
        catch (XMLStreamException ex) {

            returnValue = 1;
            ex.printStackTrace();
        }
        catch (IOException ex) {
            returnValue = 1;
            ex.printStackTrace();

        }
        finally {
            document.close();

        }

        return returnValue;
    }    






        public int xml2pdfForGenInd(String repPath, String imgPath, String xmlFileName) {

        String pdfFileName = xmlFileName;
        pdfFileName = pdfFileName.replaceFirst(".xml", ".pdf");
        if (pdfFileName == null) {
            return 1;
        }
        Paragraph paraGraph = null;
        int paraStart = 0, bold = 0, itallic = 0, align = 0, underLine = 0;
        Document document = new Document(PageSize.A4, 80, 50, 30, 65);
        int outerTD = 0, outermostTD = 0, innerTD = 0;
        int outerTDContent = 0, outermostTDContent = 0, innerTDContent = 0;
        PdfPTable outermostTable = null;// cols =1
        PdfPTable outerTable = null;// cols =2
        PdfPTable innermostTable = null;// cols =6

        int returnValue = 0;
        final String fontValue = FontFactory.TIMES; // font to be followed
        // throughout the doc
        int fontSize = 10;
        int countColumns = 0;
        final Color fontColor = Color.BLACK;// color to be followed throughout
        // the doc
        final int fontStyle = Font.NORMAL;// style to be followed throughout
        // the doc
        int centerTag = 0;
        try {

            try {

                PdfWriter newpdf = PdfWriter.getInstance(document,
                        new FileOutputStream(repPath + "\\" + pdfFileName));
                XMLStreamReader parser = XMLInputFactory
                        .newInstance()
                        .createXMLStreamReader(new FileInputStream(repPath + "\\" + xmlFileName));
                document.open();
                paraGraph = new Paragraph("", FontFactory.getFont(fontValue,
                        fontSize, fontStyle, fontColor));
                int inHeader = 0;
                for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser
                        .next()) {
                    switch (event) {
                        case XMLStreamConstants.START_ELEMENT: // Processing
                            // the
                            // Start of any TAG here

                            String paragString = parser.getLocalName();
                            if (htmlTags(paragString)) {
                                if ("img".equals(paragString)) {
                                    int hrAttributeCount = parser
                                            .getAttributeCount();
                                    for (int hrattribnames = 0; hrattribnames < hrAttributeCount; hrattribnames++) {
                                        String hrattributeName = parser
                                                .getAttributeLocalName(hrattribnames);
                                        if ("src".equals(hrattributeName)) {
                                            String attribvalue = parser
                                                    .getAttributeValue(hrattribnames);
                                            Image jpg = Image
                                                    .getInstance(attribvalue);
                                            jpg
                                                    .setAlignment(Image.ALIGN_CENTER);
                                            if (outermostTable != null) {
                                                outermostTable.addCell(jpg);

                                            } else {
                                                document.add(jpg);
                                            }

                                        }
                                    }
                                }
                                if ("font".equalsIgnoreCase(paragString)) {
                                    int hrAttributeCount = parser
                                            .getAttributeCount();
                                    for (int hrattribnames = 0; hrattribnames < hrAttributeCount; hrattribnames++) {
                                        String hrattributeName = parser
                                                .getAttributeLocalName(hrattribnames);
                                        if ("size".equalsIgnoreCase(hrattributeName)) {
                                            String attribvalue = parser
                                                    .getAttributeValue(hrattribnames);
                                            fontSize = Integer
                                                    .parseInt(attribvalue);
                                            switch (fontSize) {
                                                case 1:
                                                    fontSize = 8;

                                                    break;
                                                case 2:
                                                    fontSize = 10;

                                                    break;
                                                case 3:
                                                    fontSize = 12;

                                                    break;
                                                case 4:
                                                    fontSize = 14;

                                                    break;
                                                case 5:
                                                    fontSize = 16;

                                                    break;
                                                case 6:
                                                    fontSize = 20;

                                                    break;
                                                case 7:
                                                    fontSize = 30;

                                                    break;

                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if ("hr".equalsIgnoreCase(paragString)) {
                                    int barsize = 0;
                                    int hrAttributeCount = parser
                                            .getAttributeCount();
                                    for (int hrattribnames = 0; hrattribnames < hrAttributeCount; hrattribnames++) {
                                        String hrattributeName = parser
                                                .getAttributeLocalName(hrattribnames);
                                        if ("width".equalsIgnoreCase(hrattributeName)) {
                                            String attribvalue = parser
                                                    .getAttributeValue(hrattribnames);
                                            barsize = Integer
                                                    .parseInt(attribvalue) + 2;
                                            barsize = barsize / 60;
                                        }
                                    }
                                    innermostTable = new PdfPTable(3);
                                    Chunk backgroundColor = new Chunk("111");
                                    backgroundColor
                                            .setUnderline(
                                                    Color.BLUE,
                                                    0.0f,
                                                    0.7f,
                                                    0.0f,
                                                    0.4f,
                                                    PdfContentByte.LINE_CAP_PROJECTING_SQUARE);
                                    backgroundColor
                                            .setTextRenderMode(
                                                    PdfContentByte.TEXT_RENDER_MODE_INVISIBLE,
                                                    PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE,
                                                    Color.WHITE);
                                    for (int loopCount = 1; loopCount < 10; loopCount++) {
                                        if (loopCount <= barsize) {
                                            Phrase fillphrase = new Phrase(
                                                    backgroundColor);
                                            PdfPCell newCell = new PdfPCell(
                                                    fillphrase);
                                            newCell
                                                    .setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

                                            innermostTable.addCell(newCell);
                                        } else {
                                            Phrase fillphrase = new Phrase("");
                                            PdfPCell newCell = new PdfPCell(
                                                    fillphrase);
                                            newCell
                                                    .setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                                            if (loopCount < 9)
                                                newCell
                                                        .setBorderColorRight(Color.WHITE);
                                            if (loopCount > 1)
                                                newCell
                                                        .setBorderColorLeft(Color.WHITE);
                                            innermostTable.addCell(newCell);
                                        }
                                        int loopRemainder = loopCount % 3;
                                        if (loopRemainder == 0) {
                                            PdfPCell newCell = new PdfPCell(
                                                    innermostTable);
                                            newCell.setBorderColor(Color.WHITE);
                                            outerTable.addCell(newCell);
                                            innermostTable = new PdfPTable(3);
                                        }
                                    }
                                    innermostTable = null;
                                    outerTDContent = 1;
                                    countColumns = 4;

                                }

                                if ("table".equalsIgnoreCase(paragString)) {
                                    if (outermostTable != null) {
                                        if (outerTable != null) {
                                            innermostTable = new PdfPTable(4);

                                            innerTD = 0;
                                        } else {
                                            outerTable = new PdfPTable(4);
                                            outerTD = 0;
                                        }
                                    } else {
                                        outermostTable = new PdfPTable(1);
                                        outermostTD = 0;
                                    }

                                }
                                if ("tr".equalsIgnoreCase(paragString)) {
                                    if (outerTable != null) {
                                        countColumns = 0;
                                    }
                                }
                                if ("td".equalsIgnoreCase(paragString)) {
                                    if (innermostTable != null) {
                                        innerTD++;
                                        innerTDContent = 0;
                                    } else {
                                        if (outerTable != null) {
                                            outerTD++;
                                            outerTDContent = 0;
                                            countColumns++;
                                        } else {
                                            outermostTD++;
                                            outermostTDContent = 0;
                                        }
                                    }

                                }
                                
                                if ("center".equalsIgnoreCase(paragString)) {
                                    align = 1;
                                    centerTag = 1;
                                }
                                if ("b".equalsIgnoreCase(paragString)) {
                                    bold = 1;
                                }
                                if ("i".equalsIgnoreCase(paragString)) {
                                    itallic = 1;

                                }
                                if ("u".equalsIgnoreCase(paragString)) {
                                    underLine = 1;

                                }
                                if ("p".equalsIgnoreCase(paragString)) {
                                    int attribCount = parser
                                            .getAttributeCount();
                                    for (int attribnames = 0; attribnames < attribCount; attribnames++) {
                                        String attributeName = parser
                                                .getAttributeLocalName(attribnames);
                                        if ("align".equalsIgnoreCase(attributeName)) {
                                            String attributeValue = parser
                                                    .getAttributeValue(attribnames);
                                            paraGraph
                                                    .setAlignment(Element.ALIGN_JUSTIFIED);
                                            if (!"".equalsIgnoreCase(paraGraph.content()
                                                    .trim())) {
                                                document.add(paraGraph);
                                            }
                                            paraGraph = new Paragraph("",
                                                    FontFactory.getFont(
                                                            fontValue,
                                                            fontSize,
                                                            fontStyle,
                                                            fontColor));

                                            if ("center".equalsIgnoreCase(attributeValue)) {
                                                align = 1;
                                            }
                                            if ("right".equalsIgnoreCase(attributeValue)) {
                                                align = 2;
                                            }
                                            if ("left".equalsIgnoreCase(attributeValue)) {
                                                align = 3;
                                            }

                                        }
                                    }

                                    paraStart = 1;
                                    paraGraph.add("\n");

                                }

                                inHeader++;
                            }
                            break;
                        case XMLStreamConstants.END_ELEMENT:// Processing the
                            // End of
                            // any TAG here
                            String paragclose = parser.getLocalName();
                            if (htmlTags(paragclose)) {
                                if ("font".equalsIgnoreCase(paragclose)) {

                                    fontSize = 10;

                                }
                                if ("tr".equalsIgnoreCase(paragclose)) {
                                    if (outerTable != null && countColumns > 0) {
                                        while (countColumns < 4) {
                                            outerTable.addCell("");
                                            countColumns++;
                                        }
                                        countColumns = 0;
                                    }
                                }
                                if ("p".equalsIgnoreCase(paragclose)) {
                                    if (align == 1) {
                                        paraGraph
                                                .setAlignment(Element.ALIGN_CENTER);
                                        if (!"".equalsIgnoreCase(paraGraph.content()
                                                .trim())) {
                                            document.add(paraGraph);
                                        }
                                        paraGraph = new Paragraph("",
                                                FontFactory.getFont(fontValue,
                                                        fontSize, fontStyle,
                                                        fontColor));
                                    }
                                    if (align == 2) {
                                        paraGraph
                                                .setAlignment(Element.ALIGN_RIGHT);
                                        if (!"".equalsIgnoreCase(paraGraph.content()
                                                .trim())) {

                                            document.add(paraGraph);
                                        }

                                        paraGraph = new Paragraph("",
                                                FontFactory.getFont(fontValue,
                                                        fontSize, fontStyle,
                                                        fontColor));
                                    }
                                    if (align == 3) {
                                        paraGraph
                                                .setAlignment(Element.ALIGN_LEFT);
                                        if (!"".equalsIgnoreCase(paraGraph.content()
                                                .trim())) {
                                            document.add(paraGraph);
                                        }
                                        paraGraph = new Paragraph("",
                                                FontFactory.getFont(fontValue,
                                                        fontSize, fontStyle,
                                                        fontColor));
                                    }
                                    if (centerTag == 0)
                                        align = 0;
                                    paraStart--;
                                }
                                if ("center".equalsIgnoreCase(paragclose)) {
                                    align = 0;
                                    centerTag = 0;
                                }
                                if ("td".equalsIgnoreCase(paragclose)) {
                                    if (innerTD == 0) {
                                        if (outerTD == 0) {
                                            if (outermostTDContent == 0)

                                            {
                                                outermostTable.addCell("");
                                            }
                                            outermostTD--;
                                            outermostTDContent = 0;
                                        } else {
                                            if (outerTDContent == 0) {
                                                outerTable.addCell("");
                                            }

                                            outerTD--;
                                            outerTDContent = 0;
                                        }
                                    } else {

                                        innerTDContent = 0;
                                        innerTD--;
                                    }

                                }
                                if ("table".equalsIgnoreCase(paragclose)) {
                                    if (innermostTable == null) {
                                        if (outerTable == null) {
                                            paraGraph.add("");
                                            paraGraph.add(outermostTable);

                                            outermostTable = null;
                                            outermostTD = outerTD = innerTD = 0;
                                            outermostTDContent = outerTDContent = innerTDContent = 0;

                                        } else {
                                            Phrase fillPhrase = new Phrase("");
                                            PdfPCell newCell = new PdfPCell(
                                                    fillPhrase);
                                            outerTable.addCell(newCell);

                                            outermostTable.addCell(outerTable);
                                            outerTable = null;
                                            outermostTDContent = 1;
                                            outerTDContent = innerTDContent = 0;
                                            outerTD = innerTD = 0;
                                        }
                                    } else {
                                        innermostTable = null;
                                        outerTDContent = 1;
                                        innerTD = 0;
                                        innerTDContent = 0;
                                    }

                                }
                                if ("b".equalsIgnoreCase(paragclose)) {
                                    bold = 0;
                                }
                                if ("i".equalsIgnoreCase(paragclose)) {
                                    itallic = 0;

                                }
                                if ("u".equalsIgnoreCase(paragclose)) {
                                    underLine = 0;
                                }
                                inHeader--;
                            }
                            break;
                        case XMLStreamConstants.CHARACTERS:// Processing the
                            // charactes in the start and closing any TAG here

                            int addcol = outerTD + outermostTD + innerTD;
                            if ((paraStart > 0) || (addcol > 0)) {
                                String outputString = parser.getText();
                                boolean whiteSpace = parser.isWhiteSpace();
                                outputString = outputString.replaceAll("\n",
                                        " ");
                                char charAtPos = outputString.charAt(0);

                                int fontUsed = Font.NORMAL;
                                if ((bold == 1) && (itallic == 1)
                                        && (underLine == 1)) {
                                    fontUsed = Font.BOLDITALIC;
                                }

                                if ((bold == 1) && (itallic == 1)
                                        && (underLine == 0)) {
                                    fontUsed = Font.BOLDITALIC;
                                }
                                if ((bold == 1) && (itallic == 0)
                                        && (underLine == 1)) {
                                    fontUsed = Font.BOLDITALIC;
                                }
                                if ((bold == 0) && (itallic == 1)
                                        && (underLine == 1)) {
                                    fontUsed = Font.ITALIC;
                                }
                                if ((bold == 1) && (itallic == 0)
                                        && (underLine == 0)) {
                                    fontUsed = Font.BOLD;
                                }
                                if ((bold == 0) && (itallic == 1)
                                        && (underLine == 0)) {
                                    fontUsed = Font.ITALIC;
                                }
                                if ((bold == 0) && (itallic == 0)
                                        && (underLine == 1)) {
                                    fontUsed = Font.UNDERLINE;
                                }
                                if (addcol > 0) {
                                    if (!whiteSpace) {
                                        Phrase newPhrase = new Phrase(
                                                new Chunk(outputString,
                                                        FontFactory.getFont(
                                                                fontValue,
                                                                fontSize,
                                                                fontUsed,
                                                                fontColor)));
                                        if (innermostTable != null) {

                                            PdfPCell newCell = new PdfPCell(
                                                    newPhrase);
                                            newCell.setBorderColor(Color.WHITE);
                                            innermostTable.addCell(newCell);
                                            innerTDContent = 1;
                                        } else if (outerTable != null) {

                                            if (!Character.isDigit(charAtPos)) {

                                                if (outputString
                                                        .contains(". . . . . .")) {
                                                    String subString = outputString
                                                            .substring(1, 3);
                                                    if ("Ta".equalsIgnoreCase(subString)) {
                                                        outerTable
                                                                .addCell(" Tactical . . . . . .");
                                                    } else {
                                                        outerTable
                                                                .addCell(" Unstructured . .");
                                                    }
                                                    outerTable
                                                            .addCell(" . . . . . . . . . . . .");
                                                    if ("Ta".equalsIgnoreCase(subString)) {
                                                        outerTable
                                                                .addCell(". . . . . Strategic");
                                                    } else {
                                                        outerTable
                                                                .addCell(". . . . . Process");
                                                    }

                                                    countColumns += 3;
                                                } else {
                                                    outerTable
                                                            .addCell(newPhrase);

                                                    if ("Scale".equalsIgnoreCase(outputString)) {
                                                        countColumns = 4;
                                                        innermostTable = new PdfPTable(
                                                                3);
                                                        Phrase phrase = new Phrase(
                                                                "1");
                                                        PdfPCell pdfPCell = new PdfPCell(
                                                                phrase);
                                                        pdfPCell
                                                                .setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                                        pdfPCell
                                                                .setBorderColor(Color.WHITE);
                                                        innermostTable
                                                                .addCell(pdfPCell);
                                                        phrase = new Phrase("2");
                                                        pdfPCell = new PdfPCell(
                                                                phrase);
                                                        pdfPCell
                                                                .setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                                        pdfPCell
                                                                .setBorderColor(Color.WHITE);
                                                        innermostTable
                                                                .addCell(pdfPCell);
                                                        phrase = new Phrase("3");
                                                        pdfPCell = new PdfPCell(
                                                                phrase);
                                                        pdfPCell
                                                                .setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                                        pdfPCell
                                                                .setBorderColor(Color.WHITE);
                                                        innermostTable
                                                                .addCell(pdfPCell);

                                                        outerTable
                                                                .addCell(innermostTable);
                                                        innermostTable = new PdfPTable(
                                                                3);
                                                        phrase = new Phrase("4");
                                                        pdfPCell = new PdfPCell(
                                                                phrase);
                                                        pdfPCell
                                                                .setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                                        pdfPCell
                                                                .setBorderColor(Color.WHITE);
                                                        innermostTable
                                                                .addCell(pdfPCell);
                                                        phrase = new Phrase("5");
                                                        pdfPCell = new PdfPCell(
                                                                phrase);
                                                        pdfPCell
                                                                .setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                                        pdfPCell
                                                                .setBorderColor(Color.WHITE);
                                                        innermostTable
                                                                .addCell(pdfPCell);
                                                        phrase = new Phrase("6");
                                                        pdfPCell = new PdfPCell(
                                                                phrase);
                                                        pdfPCell
                                                                .setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                                        pdfPCell
                                                                .setBorderColor(Color.WHITE);
                                                        innermostTable
                                                                .addCell(pdfPCell);

                                                        outerTable
                                                                .addCell(innermostTable);
                                                        innermostTable = new PdfPTable(
                                                                3);
                                                        phrase = new Phrase("7");
                                                        pdfPCell = new PdfPCell(
                                                                phrase);
                                                        pdfPCell
                                                                .setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                                        pdfPCell
                                                                .setBorderColor(Color.WHITE);
                                                        innermostTable
                                                                .addCell(pdfPCell);
                                                        phrase = new Phrase("8");
                                                        pdfPCell = new PdfPCell(
                                                                phrase);
                                                        pdfPCell
                                                                .setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                                        pdfPCell
                                                                .setBorderColor(Color.WHITE);
                                                        innermostTable
                                                                .addCell(pdfPCell);
                                                        phrase = new Phrase("9");
                                                        pdfPCell = new PdfPCell(
                                                                phrase);
                                                        pdfPCell
                                                                .setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                                                        pdfPCell
                                                                .setBorderColor(Color.WHITE);
                                                        innermostTable
                                                                .addCell(pdfPCell);

                                                        outerTable
                                                                .addCell(innermostTable);
                                                        innermostTable = null;
                                                    }
                                                }
                                            } else {
                                                countColumns--;
                                            }

                                            outerTDContent = 1;
                                        } else

                                        if (outermostTable != null) {
                                            outermostTable.addCell(newPhrase);
                                            outermostTDContent = 1;
                                        }

                                    }
                                } else if (!whiteSpace) {
                                    paraGraph.add(new Chunk(outputString,
                                            FontFactory.getFont(fontValue,
                                                    fontSize, fontUsed,
                                                    fontColor)));
                                }
                            }
                            break;
                        case XMLStreamConstants.CDATA:
                            break;
                    } // end switch
                } // end while
                parser.close();
                paraGraph.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(paraGraph);
            }
            catch (DocumentException e) {

                e.printStackTrace();
                returnValue = 1;
            }
            catch (FactoryConfigurationError e) {

                e.printStackTrace();
                returnValue = 1;
            }
        }
        catch (XMLStreamException ex) {

            returnValue = 1;
            ex.printStackTrace();
        }
        catch (IOException ex) {
            returnValue = 1;
            ex.printStackTrace();

        }
        finally {
            document.close();

        }

        return returnValue;
    }

}
