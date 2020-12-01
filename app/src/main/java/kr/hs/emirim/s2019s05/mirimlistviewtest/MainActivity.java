package kr.hs.emirim.s2019s05.mirimlistviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   //String[] items = {"빨","주","노","초","파","남","보"};
    ArrayList<String> arrayList = new ArrayList<String>();
    EditText editText;
    ArrayAdapter<String> adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList );
        ListView list1 = findViewById(R.id.list1);
        editText  = findViewById(R.id.input);
        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(btnListener);

        list1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list1.setAdapter(adapter);
        list1.setOnItemLongClickListener(listListener);
    }

   View.OnClickListener btnListener = new View.OnClickListener() {
       @Override
       public void onClick(View v) {
            arrayList.add(editText.getText().toString());
            adapter.notifyDataSetChanged();
       }
   };


    AdapterView.OnItemLongClickListener listListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            arrayList.remove(position);
            adapter.notifyDataSetChanged();

            return false;
        }
    };
}