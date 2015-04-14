package com.berkkarabacak.mspproje;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.ListBlobItem;

public class Checkactivity extends ActionBarActivity {
String tcnumara;
    public static final String ConnectionString =
            "DefaultEndpointsProtocol=https;"
                    + "AccountName=mspproje;"
                    + "AccountKey=B5lzqD1If9Jf2buT9cnrZJeIf0zgMhkcv4qUsQFObGnFtcs5w7byPP86dHlwILkGeiui4gax9PTSuccIrP4qcA==";



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
            // Retrieve storage account from connection-string.
       CloudStorageAccount storageAccount = CloudStorageAccount.parse(ConnectionString);
          //  System.out.println(ConnectionString);

            // Create the blob client.
           CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Retrieve reference to a previously created container.
          CloudBlobContainer container = blobClient.getContainerReference("mspproje");

            // Loop over blobs within the container and output the URI to each of them.
          for (ListBlobItem blobItem : container.listBlobs()) {
              System.out.println("*****************************");
              System.out.println(blobItem.getUri());
              System.out.println("*****************************");

              System.out.println("*****************************");

              System.out.println("*****************************");
              System.out.println("*****************************");
              System.out.println("*****************************");
              System.out.println("*****************************");


          }


        }
        catch (Exception e)
        {
            // Output the stack trace.
          //  e.printStackTrace();
        }


    }

    }

