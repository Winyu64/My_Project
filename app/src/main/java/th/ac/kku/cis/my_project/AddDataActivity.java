package th.ac.kku.cis.my_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import th.ac.kku.cis.my_project.R;

public class AddDataActivity extends AppCompatActivity {

    EditText name,course,email,turl;
    Button btnAdd,back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        name = (EditText)findViewById(R.id.txtName);
        course = (EditText)findViewById(R.id.txtCourse);
        email = (EditText)findViewById(R.id.txtEmail);
        turl = (EditText)findViewById(R.id.txtImageURL);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        back_btn = (Button)findViewById(R.id.back_btn);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearAll();
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void insertData(){
        Map<String,Object> map = new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("course",course.getText().toString());
        map.put("email",email.getText().toString());
        map.put("turl",turl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("teachers").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddDataActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddDataActivity.this, "Error while Insertion", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void clearAll(){
        name.setText("");
        course.setText("");
        email.setText("");
        turl.setText("");
    }
//    @Override
//    protected void onStop(){
//        super.onStop();
//        adapter.stopListening();
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.search,menu);
//        MenuItem item = menu.findItem(R.id.search);
//        SearchView searchView = (SearchView)item.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                txtSearch(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String query) {
//                txtSearch(query);
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu)
//    }
//    private void txtSearch(String str){
//        FirebaseRecyclerOptions<MainModel> options =
//                new FirebaseRecyclerOptions.Builder<MainModel>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("teachers").orderByChild("name").startAfter(str).endAt(str+"~"),MainModel.class)
//                        .build();
//        adapter = new Adapter(options);
//        adapter.startListening;
//        recyclerView.serAdapter(adapter);
//    }
}