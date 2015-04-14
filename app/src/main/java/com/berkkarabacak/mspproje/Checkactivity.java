package com.berkkarabacak.mspproje;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Checkactivity extends ActionBarActivity {
String tcnumara;
    public static final String ConnectionString =
            "DefaultEndpointsProtocol=http;"
                    + "AccountName=mspproje;"
                    + "AccountKey=bpBHfSA4uVJVJjxaQcOCKTH7Hib/NAJslvOvnl6q65x652mUahzu6JXKPxAhyP8/w/WKp0htVS5/EVhjaGTkaA==";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.checkheartbeat);
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            tcnumara = extras.getString("tcnumber");
        }
        TextView t=(TextView)findViewById(R.id.tcnumaraset);
        t.setText(tcnumara);

        try
        {
            System.out.println("*****************************");

            System.out.println("*****************************");

            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println("*****************************");

            System.out.println("*****************************");


            // Retrieve storage account from connection-string.
       CloudStorageAccount storageAccount = CloudStorageAccount.parse(ConnectionString);
          //  System.out.println(ConnectionString);
            System.out.println(storageAccount.toString()          );
            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println("*****************************");

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();


            // Retrieve reference to a previously created container.
            CloudBlobContainer container = blobClient.getContainerReference("mspproje");
            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println(container.getName());

            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println("*****************************");

            // Loop through each blob item in the container.
            for (ListBlobItem blobItem : container.listBlobs()) {
                System.out.println("*****************************");
                System.out.println("*****************************");
                System.out.println("*****************************");
                System.out.println("*****************************");
                CloudBlob blob = (CloudBlob) blobItem;
                blob.download(new FileOutputStream("C:\\" + blob.getName()));
                System.out.println(blob.getName());


                System.out.println("*****************************");
                System.out.println("*****************************");
                System.out.println("*****************************");
                System.out.println("*****************************");                // If the item is a blob, not a virtual directory.

            }
        }
        catch (Exception e)
        {
            // Output the stack trace.
          //  e.printStackTrace();
        }


    }

    }

