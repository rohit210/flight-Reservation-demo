package com.rohit.flightreservation.Utill;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rohit.flightreservation.entities.Reservation;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


@Component
public class PDFGenerator {
    public void generateItinarary(Reservation reservation, String filePath) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(generateTable(reservation));
            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();


        }
    }

    private PdfPTable generateTable(Reservation reservation) {

        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("flight Itinarary"));
        cell.setColspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Flight Details"));
        cell.setColspan(2);
        table.addCell(cell);
        table.addCell("airline name");
        table.addCell(reservation.getFlight().getOperatingAirlines());
        table.addCell("Departure city");
        table.addCell(reservation.getFlight().getDepartureCity());
        table.addCell("Arrival city");
        table.addCell(reservation.getFlight().getArrivalCity());
        table.addCell(" flight number");
        table.addCell(reservation.getFlight().getFlightNumber());
        table.addCell("estimated time for departure ");
        table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

        cell = new PdfPCell(new Phrase("passenger details"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("first Name");
        table.addCell(reservation.getPassenger().getFirstName());
        table.addCell("last Name");
        table.addCell(reservation.getPassenger().getLastName());
        table.addCell(" email");
        table.addCell(reservation.getPassenger().getEmail());
        table.addCell("phone");
        table.addCell(reservation.getPassenger().getPhone());
        return table;
    }


}
