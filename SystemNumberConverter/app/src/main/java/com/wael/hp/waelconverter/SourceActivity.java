package com.wael.hp.waelconverter;
//Wael Al-ameen
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class SourceActivity extends ActionBarActivity {

    Spinner spinner1,spinner2;
    ArrayAdapter<CharSequence>arrayAdapter;
    private String checkTheItemFromSpinner1;
    private String checkTheItemFromSpinner2;
    private EditText Input;
    private TextView Tv;
    private Button btnClick;
    private Button clearClick;
    private int[] decimalNumber = new int[2];
    private int[] binaryNumber = new int[2];
    private int[] octalNumber = new int[2];
    private int[] hexaNumber = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);
        spinner1 = (Spinner)findViewById(R.id.spinner);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        Input = (EditText)findViewById(R.id.editText);
        Tv = (TextView)findViewById(R.id.textView4);
        btnClick = (Button)findViewById(R.id.button);
        clearClick = (Button)findViewById(R.id.button3);
        arrayAdapter = ArrayAdapter.createFromResource(this,R.array.Number_System_types,                           android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkTheItemFromSpinner1 = parent.getItemAtPosition(position).toString();
                checkingTheItems(checkTheItemFromSpinner1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        clearClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tv.setText("0.00");
            }
        });

    }

    public void checkingTheItems(String item1){

        if(item1.equals("decimal")){
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    checkTheItemFromSpinner2 = parent.getItemAtPosition(position).toString();
                    if(checkTheItemFromSpinner2.equals("binary")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                if(keyInput.equals("")){
                                    return;
                                }
                                decimalNumber = getInput(keyInput);
                                Tv.setText(Integer.toBinaryString(decimalNumber[0]) + "." +                                                Integer.toBinaryString(decimalNumber[1]));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("octal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                if(keyInput.equals("")){
                                    return;
                                }
                                decimalNumber = getInput(keyInput);
                                Tv.setText(Integer.toOctalString(decimalNumber[0]) + "." +                                                 Integer.toOctalString(decimalNumber[1]));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("hexadecimal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                if(keyInput.equals("")){
                                    return;
                                }
                                decimalNumber = getInput(keyInput);
                                Tv.setText(Integer.toHexString(decimalNumber[0]) + "." +                                                   Integer.toHexString(decimalNumber[1]));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("decimal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                              Toast.makeText(getApplicationContext(),"You can not select the same options",                              Toast.LENGTH_SHORT).show( );
                            }
                        });
                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

        else if(item1.equals("binary")){
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    checkTheItemFromSpinner2 = parent.getItemAtPosition(position).toString();
                    if(checkTheItemFromSpinner2.equals("decimal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                binaryNumber = getInput(keyInput);
                                String[] binaryNumber2 = new String[2];
                                binaryNumber2[0] = String.valueOf(binaryNumber[0]);
                                binaryNumber2[1] = String.valueOf(binaryNumber[1]);
                                Tv.setText(Integer.parseInt(binaryNumber2[0],2) + "." +
                                Integer.parseInt(binaryNumber2[1],2));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("octal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                if(keyInput.equals("")){
                                    return;
                                }
                                binaryNumber = getInput(keyInput);
                                Tv.setText(Integer.toOctalString(binaryNumber[0]) + "." +                                                  Integer.toOctalString(binaryNumber[1]));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("hexadecimal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                if(keyInput.equals("")){
                                    return;
                                }
                                binaryNumber = getInput(keyInput);
                                Tv.setText(Integer.toHexString(binaryNumber[0]) + "." +                                                   Integer.toHexString(binaryNumber[1]));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("binary")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                              Toast.makeText(getApplicationContext(),"You can not select the same options",                                           Toast.LENGTH_SHORT).show( );
                            }
                        });
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }


        else if(item1.equals("octal")){
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    checkTheItemFromSpinner2 = parent.getItemAtPosition(position).toString();
                    if(checkTheItemFromSpinner2.equals("decimal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                octalNumber = getInput(keyInput);
                                String[] octalNumber2 = new String[2];
                                octalNumber2[0] = String.valueOf(octalNumber[0]);
                                octalNumber2[1] = String.valueOf(octalNumber[1]);
                                Tv.setText(Integer.parseInt(octalNumber2[0], 8) + "." +
                                        Integer.parseInt(octalNumber2[1], 8));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("binary")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                if(keyInput.equals("")){
                                    return;
                                }
                                octalNumber = getInput(keyInput);
                                Tv.setText(Integer.toBinaryString(octalNumber[0]) + "." +                                                   Integer.toBinaryString(octalNumber[1]));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("hexadecimal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                if(keyInput.equals("")){
                                    return;
                                }
                                octalNumber = getInput(keyInput);
                                Tv.setText(Integer.toHexString(octalNumber[0]) + "." +                                                   Integer.toHexString(octalNumber[1]));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("octal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                              Toast.makeText(getApplicationContext(),"You can not select the same options",                                           Toast.LENGTH_SHORT).show( );
                            }
                        });
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }


        else if(item1.equals("hexadecimal")){
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    checkTheItemFromSpinner2 = parent.getItemAtPosition(position).toString();
                    if(checkTheItemFromSpinner2.equals("decimal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                hexaNumber = getInput(keyInput);
                                String[] hexaNumber2 = new String[2];
                                hexaNumber2[0] = String.valueOf(hexaNumber[0]);
                                hexaNumber2[1] = String.valueOf(hexaNumber[1]);
                                Tv.setText(Integer.parseInt(hexaNumber2[0], 16) + "." +
                                        Integer.parseInt(hexaNumber2[1], 16));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("binary")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                if(keyInput.equals("")){
                                    return;
                                }
                                hexaNumber = getInput(keyInput);
                                Tv.setText(Integer.toBinaryString(hexaNumber[0]) + "." +                                                   Integer.toBinaryString(hexaNumber[1]));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("octal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String keyInput = Input.getText().toString();
                                if(keyInput.equals("")){
                                    return;
                                }
                                hexaNumber = getInput(keyInput);
                                Tv.setText(Integer.toOctalString(hexaNumber[0]) + "." +                                                    Integer.toOctalString(hexaNumber[1]));
                            }
                        });
                    }

                    else if(checkTheItemFromSpinner2.equals("hexadecimal")){
                        btnClick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                             Toast.makeText(getApplicationContext(),"You can not select the same options",                                           Toast.LENGTH_SHORT).show( );
                            }
                        });
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public int[] getInput(String keyInput){
        int[] separateDecimal = new int[2];
        String[] num = new String[2];
        if(keyInput.contains(".")){
            num = keyInput.split("\\.");
        }

        else{
            num[0] = keyInput;
            num[1] = "";
        }

        separateDecimal[0] = Integer.parseInt(num[0]);
        separateDecimal[1] = Integer.parseInt(num[1]);
        return separateDecimal;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_source, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
