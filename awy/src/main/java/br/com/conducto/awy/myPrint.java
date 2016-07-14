package br.com.conducto.awy;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

public class myPrint 
{
	private static boolean jobRunning = true;


	public myPrint() throws PrintException, InterruptedException, IOException
    {

		// Open the image file

  InputStream is = new BufferedInputStream(new FileInputStream("/home/abraao/Documentos/Prova1-Respostas.pdf"));

  // create a PDF doc flavor

  DocFlavor flavor = DocFlavor.INPUT_STREAM.PDF;

  // Locate the default print service for this environment.

  PrintService service = PrintServiceLookup.lookupDefaultPrintService();

  // Create and return a PrintJob capable of handling data from

  // any of the supported document flavors.

  DocPrintJob printJob = service.createPrintJob();

  // register a listener to get notified when the job is complete

  printJob.addPrintJobListener(new JobCompleteMonitor());

  // Construct a SimpleDoc with the specified 

  // print data, doc flavor and doc attribute set.

  Doc doc = new SimpleDoc(is, flavor, null);

  // Print a document with the specified job attributes.

  printJob.print(doc, null);

  while (jobRunning) {

  	Thread.sleep(1000);

  }

  System.out.println("Exiting app");

  is.close();

	}

	private static class JobCompleteMonitor extends PrintJobAdapter {
		@Override
		public void printJobCompleted(PrintJobEvent jobEvent) {
			System.out.println("Job completed");
			jobRunning = false;
		}
	}

}

