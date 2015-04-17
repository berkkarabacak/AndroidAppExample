package com.berkkarabacak.mspproje;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
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
import java.security.spec.ECField;


public class Checkactivity extends ActionBarActivity {
    String tcnumara;
    static Integer currentheartbeat;
    static String currentheartbeatstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.checkheartbeat);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tcnumara = extras.getString("tcnumber");
        }
        TextView t = (TextView) findViewById(R.id.tcnumaraset);
        t.setText(tcnumara);

    }

    @Override
    protected void onResume() {
        super.onResume();

        setContentView(R.layout.checkheartbeat);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tcnumara = extras.getString("tcnumber");
        }
        TextView t = (TextView) findViewById(R.id.tcnumaraset);
        t.setText(tcnumara);





  //  try {
    //    Thread.sleep(5000);

 //   } catch (Exception e) {

        // asd
   // }
        UIUpdater mUIUpdater = new UIUpdater(new Runnable() {
            @Override
            public void run() {
                new Azure().execute();

            }
        });
        mUIUpdater.startUpdates();
        UIUpdater mUIUpdater2 = new UIUpdater(new Runnable() {
            @Override
            public void run() {
                if (currentheartbeat != null) {
                    currentheartbeatstring = Integer.toString(currentheartbeat);
                    TextView t2 = (TextView) findViewById(R.id.currentheartbeat);
                    t2.setText(currentheartbeatstring);
                }
            }
        });
        mUIUpdater2.startUpdates();



    }

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
                // Define the path to a local file.
                final String filePath = "C:\\Users\\Berk\\Desktop\\audi.jpg";

                // Create or overwrite the "myimage.jpg" blob with contents from a local file.
                CloudBlockBlob blob = container.getBlockBlobReference(MainActivity.tcnumara+".csv");
                String lastelementdeleted=blob.downloadText().substring(0, blob.downloadText().length() - 1);

                currentheartbeat=Integer.parseInt(lastelementdeleted.substring(lastelementdeleted.lastIndexOf(";")+2));
                System.out.println(currentheartbeat+"in inner async try");
            }


        catch (Exception e)
        {
            // Output the stack trace.
            // e.printStackTrace();
        }



        return null;
        }
    }


}