package uga.sahilshankar.com.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText itemet;
    private Button btn;
    private ListView itemlist;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemet = findViewById(R.id.list_item);
        btn = findViewById(R.id.addbutton);
        itemlist = findViewById(R.id.listview);

        items = filehelper.readdata(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        itemlist.setAdapter(adapter);
        btn.setOnClickListener(this);
        itemlist.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addbutton:    String itementered = itemet.getText().toString();
                                    adapter.add(itementered);
                                    itemet.setText("");
                                    filehelper.writedata(items, this);
                                    Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
                                    break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Item Removed", Toast.LENGTH_SHORT).show();
    }
}
