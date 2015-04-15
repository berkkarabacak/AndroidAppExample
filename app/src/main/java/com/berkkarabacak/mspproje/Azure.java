package com.berkkarabacak.mspproje;

import android.os.AsyncTask;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Berk on 15-Apr-15.
 */
public class Azure extends AsyncTask<Void, Void, Void> {
    public static final String ConnectionString =
            "DefaultEndpointsProtocol=http;"
                    + "AccountName=mspproje;"
                    + "AccountKey=bpBHfSA4uVJVJjxaQcOCKTH7Hib/NAJslvOvnl6q65x652mUahzu6JXKPxAhyP8/w/WKp0htVS5/EVhjaGTkaA==";

    @Override
    protected Void doInBackground(Void... voids) {

        try
        {


            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(ConnectionString);

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Retrieve reference to a previously created container.
            CloudBlobContainer container = blobClient.getContainerReference("mspproje");
            System.out.println("1//////////////////////1");
            System.out.println("2\\\\\\\\\\\\\\\\\\\\\\2");
            System.out.println("3//////////////////////3");
            System.out.println("4\\\\\\\\\\\\\\\\\\\\\\4");
            System.out.println(container.exists());
            System.out.println("5//////////////////////5");
            System.out.println("6\\\\\\\\\\\\\\\\\\\\\\6");
            System.out.println("7//////////////////////7");
            System.out.println("8\\\\\\\\\\\\\\\\\\\\\\8");

            // Loop over blobs within the container and output the URI to each of them.
            for (ListBlobItem blobItem : container.listBlobs()) {
                System.out.println("7//////////////////////7");
                System.out.println("7//////////////////////7");
                System.out.println("7//////////////////////7");

                System.out.println(blobItem.getUri());
            }

        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }


        return null;
    }
}
