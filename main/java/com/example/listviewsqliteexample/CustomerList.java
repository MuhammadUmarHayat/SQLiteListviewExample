package com.example.listviewsqliteexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerList extends AppCompatActivity
{
    Button btnShow;
    ListView listView;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    Customer_Table db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        try {
            btnShow = (Button) findViewById(R.id.show);
            listView = (ListView) findViewById(R.id.lvCars);
            //CarList(Activity context, List<Car> cars)


            listItem=new ArrayList<>();
            //Carid,CarId1,CarModel,CarColour,CarCapacity,CarOwnerID,CarStatus
            db = new Customer_Table(this);

            viewData();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String text=listView.getItemAtPosition(position).toString();
                    // Toast.makeText(ViewCars1.this,text,Toast.LENGTH_SHORT).show();
                    try {
                        ViewCustomer(text);
                    }
                    catch (Exception ex)
                    {


                    }

                }
            });

        }
        catch(Exception exp){
            //  btnShow.setText(exp.getMessage().toString());
            Toast.makeText(CustomerList.this,exp.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }


    }

    private void viewData()
    {
        Cursor cursor= db.getAllData();
        if(cursor.getCount()==0)
        {
            //no data
        }
        else
        {

            while(cursor.moveToNext())
            {
                listItem.add(cursor.getString(0));// name
                listItem.add(cursor.getString(1));//username



            }
            adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItem);
            listView.setAdapter(adapter);
        }


    }//view data



    private void ViewCustomer(String carid)
    {
//cars available for rent
        Cursor res =db.getCustomer(carid);
        if(res.getCount() == 0) {
            // show message
            showMessage("Total Cars ","Nothing is found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext()) {
//String name, String username, String passwrod, String email, String mobileNo, String address, String status, String Designation
            //CarTable(carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT ,imageName TEXT ,image BLOB";
            buffer.append("Id :" + res.getString(0) + "\n");
            buffer.append("carId :" + res.getString(1) + "\n");
            buffer.append("model :" + res.getString(2) + "\n");
            buffer.append("capacity " + res.getString(3) + "\n");
            buffer.append("colour :" + res.getString(4) + "\n");
            buffer.append("Owner Name " + res.getString(5) + "\n");
            buffer.append("Status:" + res.getString(6) + "\n");

        }//while
        showMessage("Total Cars  ",buffer.toString());

    }



    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}