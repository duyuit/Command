package vn.nks.sunny.phieucongtac;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import adapter.MyDatabaseAdapter;
import adapter.UserAdapter;
import model.User;

public class AddCommand extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {
    MyDatabaseAdapter myDatabase;
    SQLiteDatabase database;
    AutoCompleteTextView txtchihuy, txtgiamsat ;
    int mYear,mMonth,mDay,fyear,fmonth,fday, hour,minute,fhour,fminute;
    EditText edtnoicongtac,  edtnoidung, edtdonvi, edtdieukien,edtphuongtien, edtdungcu,txtgichu,txtpos,txtstatus ,edtcurrent ,edtsophieu;
    TextView txttungay,txtdenngay,txtracong,txtch,txtgs,txtct ,txtnd,txtdv,txtdk;
    List<User> users;
    Button btnaddmember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_command);

        AddControl();
        AddEvent();

    }
    private void AddControl() {
        txtstatus=findViewById(R.id.txtstatus);
        txtgichu=findViewById(R.id.txtgichu);
        txtpos=findViewById(R.id.txtpos);
        txtch=findViewById(R.id.txtch);
        txtgs=findViewById(R.id.txtgs);
        txtct=findViewById(R.id.txtct);
        edtsophieu=findViewById(R.id.edtsophieu);

        txtdk=findViewById(R.id.txtdk);
        txtnd=findViewById(R.id.txtnd);
        txtdv=findViewById(R.id.txtdv);
        txtchihuy = findViewById(R.id.txtchihuy);
        txtgiamsat = findViewById(R.id.txtgiamsat);
        edtnoicongtac = findViewById(R.id.edtnoicongtac);

        edtnoidung = findViewById(R.id.edtnoidung);
        edtdonvi = findViewById(R.id.edtdonvi);
        edtdieukien = findViewById(R.id.edtdieukien);
        edtdungcu = findViewById(R.id.edtdungcu);
        edtphuongtien = findViewById(R.id.edtphuongtien);
        btnaddmember=findViewById(R.id.btnaddmember);
        txttungay=findViewById(R.id.txttungay);
        txtdenngay=findViewById(R.id.txtdenngay);
        txtracong=findViewById(R.id.txtracong);
        myDatabase = new MyDatabaseAdapter(this);
        myDatabase.Khoitai();
        database = myDatabase.getMyDatabase();
        users=new ArrayList<>();
    }
    private void AddEvent() {
        btnaddmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddCommand.this,Add_Employ.class);
                intent.putExtra("sophieu",edtsophieu.getText().toString());
                startActivity(intent);
            }
        });

        edtdonvi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) edtdonvi.getLayoutParams();
                if(edtdonvi.hasFocus())
                {
                    txtdv.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtdv.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                edtdonvi.setLayoutParams(mlp);
            }
        });
        edtdieukien.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) edtdieukien.getLayoutParams();
                if(edtdieukien.hasFocus())
                {
                    txtdk.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtdk.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                edtdieukien.setLayoutParams(mlp);
            }
        });

        edtnoidung.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) edtnoidung.getLayoutParams();
                if(edtnoidung.hasFocus())
                {
                    txtnd.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtnd.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                edtnoidung.setLayoutParams(mlp);
            }
        });


        txtchihuy.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) txtchihuy.getLayoutParams();
                if(txtchihuy.hasFocus())
                {
                    txtch.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtch.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                txtchihuy.setLayoutParams(mlp);
            }
        });

        txtgiamsat.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) txtgiamsat.getLayoutParams();
                if(txtgiamsat.hasFocus())
                {
                    txtgs.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtgs.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                txtgiamsat.setLayoutParams(mlp);
            }
        });
        edtnoicongtac.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) edtnoicongtac.getLayoutParams();
                if(edtnoicongtac.hasFocus())
                {
                    txtct.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtct.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                edtnoicongtac.setLayoutParams(mlp);
            }
        });





        txttungay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ik=1;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddCommand.this,AddCommand.this,mYear,mMonth,mDay);

                datePickerDialog.show();

            }
        });

        txtdenngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ik=2;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddCommand.this,AddCommand.this,mYear,mMonth,mDay);

                datePickerDialog.show();
            }
        });

        txtracong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ik=0;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddCommand.this,AddCommand.this,mYear,mMonth,mDay);

                datePickerDialog.show();
            }
        });

        Cursor cursor = database.rawQuery("select  * from User", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast())
        {
            Log.d("aaa",cursor.getString(1));
            users.add(new User(cursor.getString(1).toString(),cursor.getString(3).toString(),cursor.getString(4).toString()));
            cursor.moveToNext();
        }

        UserAdapter adapter=new UserAdapter(this,R.layout.item_user,users);
        txtchihuy.setAdapter(adapter);

        txtgiamsat.setAdapter(adapter);
    }
    int ik=0;
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        fyear = i;
        fmonth = i1 + 1;
        fday = i2;
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        if(ik==1){
            txttungay.setText(fyear + "-" + fmonth + "-" + fday);
        }else if(ik==2)
        {
            txtdenngay.setText(fyear + "-" + fmonth + "-" + fday);
        }
        else {
            TimePickerDialog timePickerDialog = new TimePickerDialog(AddCommand.this, AddCommand.this, hour, minute, android.text.format.DateFormat.is24HourFormat(this));
            timePickerDialog.show();
        }
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        fhour = i;
        fminute = i1;
        txtracong.setText(fyear + "-" + fmonth + "-" + fday + " " + fhour + ":" + fminute);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.done_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.btnDone)
        {
            ContentValues values=new ContentValues();

            //Insert Congtac


            values.put("SoPhieu ", edtsophieu.getText().toString());
            Cursor cursor = database.rawQuery("select  id from User where Username =?", new String[]{txtchihuy.getText().toString()});
            cursor.moveToFirst();
            Calendar calendar=Calendar.getInstance();
            values.put("Ngay",calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE));
            values.put("ChiHuyTrucTiep ", Integer.parseInt(cursor.getString(0)));

            Cursor cursor1 = database.rawQuery("select  id from User  where Username =?", new String[]{txtgiamsat.getText().toString()});
            cursor1.moveToFirst();
            values.put("GiamSatAnToan ", Integer.parseInt(cursor1.getString(0)));
            values.put("NoiCongTac", edtnoicongtac.getText().toString());
            values.put("NoiDungCongTac ", edtnoidung.getText().toString());
            values.put("DonViYeuCau", edtdonvi.getText().toString());
            values.put("DieuKien", edtdieukien.getText().toString());
            values.put("NgayBatDau", txttungay.getText().toString());
            values.put("NgayKetThuc", txtdenngay.getText().toString());
            values.put("DungCu", edtdungcu.getText().toString());
            Cursor cursor2 = database.rawQuery("select  id from PhuongTien  where Title =?", new String[]{edtphuongtien.getText().toString()});
cursor2.moveToFirst();

            values.put("PhuongTienId ", cursor2.getString(0));
            values.put("GhiChu", txtgichu.getText().toString());
            values.put("pos", txtpos.getText().toString());
            values.put("status", txtstatus.getText().toString());
            values.put("RaCong", txtracong.getText().toString());


            database.insertWithOnConflict("PHIEUCONGTAC", null, values, SQLiteDatabase.CONFLICT_FAIL);
        }
        return super.onOptionsItemSelected(item);
    }
}
