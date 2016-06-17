package guillermoab.posgrado.unam.mx.tarea1;

import android.os.CancellationSignal;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private float a,b;
    private boolean isMas,isMenos,isPor,isDiv,isMod,isDot,isBin,isDos=false;
    private EditText display;
    private String disp,op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (EditText) findViewById(R.id.activitymain_txtdisplay);
        findViewById(R.id.activitymain_btn0).setOnClickListener(this);
        findViewById(R.id.activitymain_btn1).setOnClickListener(this);
        findViewById(R.id.activitymain_btn2).setOnClickListener(this);
        findViewById(R.id.activitymain_btn3).setOnClickListener(this);
        findViewById(R.id.activitymain_btn4).setOnClickListener(this);
        findViewById(R.id.activitymain_btn5).setOnClickListener(this);
        findViewById(R.id.activitymain_btn6).setOnClickListener(this);
        findViewById(R.id.activitymain_btn7).setOnClickListener(this);
        findViewById(R.id.activitymain_btn8).setOnClickListener(this);
        findViewById(R.id.activitymain_btn9).setOnClickListener(this);
        findViewById(R.id.activitymain_btnbin).setOnClickListener(this);
        findViewById(R.id.activitymain_btnC).setOnClickListener(this);
        findViewById(R.id.activitymain_btndel).setOnClickListener(this);
        findViewById(R.id.activitymain_btndiv).setOnClickListener(this);
        findViewById(R.id.activitymain_btndot).setOnClickListener(this);
        findViewById(R.id.activitymain_btnigual).setOnClickListener(this);
        findViewById(R.id.activitymain_btnmas).setOnClickListener(this);
        findViewById(R.id.activitymain_btnmenos).setOnClickListener(this);
        findViewById(R.id.activitymain_btnmod).setOnClickListener(this);
        findViewById(R.id.activitymain_btnpor).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activitymain_btn1:
            case R.id.activitymain_btn2:
            case R.id.activitymain_btn3:
            case R.id.activitymain_btn4:
            case R.id.activitymain_btn5:
            case R.id.activitymain_btn6:
            case R.id.activitymain_btn7:
            case R.id.activitymain_btn8:
            case R.id.activitymain_btn9:
                Button Datos = (Button) findViewById(v.getId());
                if(isPor==false && isMas==false && isMod==false && isMenos==false && isDiv==false) {
                    disp=display.getText().toString();
                    if(!TextUtils.isEmpty(disp) && !disp.equals("0")){
                        disp = display.getText().toString()+Datos.getText().toString();
                        display.setText(disp);
                    }else{
                        display.setText(Datos.getText().toString());
                    }
                }else{
                    if(isDos==false){
                        display.setText("");
                    }
                    disp=display.getText().toString();
                    if(!TextUtils.isEmpty(disp) && !disp.equals("0")){
                        disp = display.getText().toString()+Datos.getText().toString();
                    }else{
                        disp=Datos.getText().toString();
                    }
                    isDos=true;
                    isDot=false;
                    display.setText(disp);
                }
                break;
            case R.id.activitymain_btnbin:
                if(isBin==false){
                    findViewById(R.id.activitymain_btn2).setEnabled(false);
                    findViewById(R.id.activitymain_btn3).setEnabled(false);
                    findViewById(R.id.activitymain_btn4).setEnabled(false);
                    findViewById(R.id.activitymain_btn5).setEnabled(false);
                    findViewById(R.id.activitymain_btn6).setEnabled(false);
                    findViewById(R.id.activitymain_btn7).setEnabled(false);
                    findViewById(R.id.activitymain_btn8).setEnabled(false);
                    findViewById(R.id.activitymain_btn9).setEnabled(false);
                    findViewById(R.id.activitymain_btndiv).setEnabled(false);
                    findViewById(R.id.activitymain_btndot).setEnabled(false);
                    findViewById(R.id.activitymain_btnmenos).setEnabled(false);
                    findViewById(R.id.activitymain_btnmod).setEnabled(false);
                    findViewById(R.id.activitymain_btnpor).setEnabled(false);
                    isBin=true;
                }else {
                    findViewById(R.id.activitymain_btn2).setEnabled(true);
                    findViewById(R.id.activitymain_btn3).setEnabled(true);
                    findViewById(R.id.activitymain_btn4).setEnabled(true);
                    findViewById(R.id.activitymain_btn5).setEnabled(true);
                    findViewById(R.id.activitymain_btn6).setEnabled(true);
                    findViewById(R.id.activitymain_btn7).setEnabled(true);
                    findViewById(R.id.activitymain_btn8).setEnabled(true);
                    findViewById(R.id.activitymain_btn9).setEnabled(true);
                    findViewById(R.id.activitymain_btndiv).setEnabled(true);
                    findViewById(R.id.activitymain_btndot).setEnabled(true);
                    findViewById(R.id.activitymain_btnmenos).setEnabled(true);
                    findViewById(R.id.activitymain_btnmod).setEnabled(true);
                    findViewById(R.id.activitymain_btnpor).setEnabled(true);
                    isBin=false;
                }
                break;
            case R.id.activitymain_btnC:
                    reset();
                break;
            case R.id.activitymain_btndel:
                disp=display.getText().toString();
                if(!TextUtils.isEmpty(disp)){
                    String ultimo = disp.substring(disp.length()-1);
                    if(ultimo.equals("+") || ultimo.equals("-") || ultimo.equals("*") || ultimo.equals("/") || ultimo.equals("M")){
                        isMas=isDiv=isMenos=isMod=isPor=false;
                        op="";
                        Toast.makeText(getApplicationContext(),ultimo,Toast.LENGTH_SHORT).show();
                    }else{
                        if(ultimo.equals(".")){
                            isDot=false;
                        }
                    }
                    display.setText(disp.substring(0,disp.length()-1));
                }else{
                    Toast.makeText(getApplicationContext(),"Has llegado al inicio!!!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.activitymain_btndiv:
            case R.id.activitymain_btnmas:
            case R.id.activitymain_btnmenos:
            case R.id.activitymain_btnmod:
            case R.id.activitymain_btnpor:
                disp=display.getText().toString();
                if(!TextUtils.isEmpty(disp)){
                    Button operacion = (Button) findViewById(v.getId());
                    if(isPor==false && isMas==false && isMod==false && isMenos==false && isDiv==false) {
                        a=Float.parseFloat(disp);
                        op=operacion.getText().toString();
                        if(op.equals("mod")){
                            op="%";
                        }
                        disp = display.getText().toString()+op;
                        display.setText(disp);
                        //findViewById(R.id.activitymain_btndel).setEnabled(false);
                        habilita_op(op);
                    }else{
                        if(isDos==false){
                            op=operacion.getText().toString();
                            disp=disp.substring(0,disp.length()-1);
                            a=Float.parseFloat(disp);
                            display.setText(disp+op);
                            habilita_op(op);
                        }else{
                            if(isBin==false){
                                //Cuando se ha ingresado el 2o número y se presiona otra operación
                                //se realiza la primera operación y se asigna el resultado como el
                                //1er número y se habilita para seguir ingresando dígitos
                                b=Float.parseFloat(disp);
                                calcular(a,b,op);
                                op=operacion.getText().toString();
                                disp=display.getText().toString();
                                a=Float.parseFloat(disp);
                                disp = display.getText().toString()+op;
                                display.setText(disp);
                                habilita_op(op);
                                isDos=false;
                            }else{
                                //código para calculadora binarea en el caso de haber ingresado
                                //el segundo numerando y haber presionado otro signo, en este caso
                                //el más.
                            }
                        }
                    }
                }
                break;
            case R.id.activitymain_btndot:
                disp=display.getText().toString();
                Button punto = (Button) findViewById(v.getId());
                if(!TextUtils.isEmpty(disp)){
                    if(isDot==false){
                        if(isPor==false && isMas==false && isMod==false && isMenos==false && isDiv==false) {
                            disp = display.getText().toString()+punto.getText().toString();
                            display.setText(disp);
                        }else{
                            if(isDos==false){
                                display.setText("");
                            }
                            display.setText("0"+punto.getText().toString());
                            isDos=true;
                        }
                        isDot=true;
                    }else{
                        Toast.makeText(getApplicationContext(),"Solo se puede usar el punto una vez!!",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    if(isDot==false){
                        disp = "0"+punto.getText().toString();
                        display.setText(disp);
                        isDot=true;
                    }else {
                        Toast.makeText(getApplicationContext(),"Solo se puede usar el punto una vez!!",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.activitymain_btn0:
                disp=display.getText().toString();
                if(!TextUtils.isEmpty(disp)){
                    if(isPor==false && isMas==false && isMod==false && isMenos==false && isDiv==false) {
                        disp = display.getText().toString()+"0";
                        display.setText(disp);
                    }else{
                        if(isDos==false){
                            display.setText("");
                        }
                        isDos=true;
                        isDot=false;
                        display.setText("0");
                    }
                }else{
                    display.setText("0");
                }
                break;
            case R.id.activitymain_btnigual:
                    if(isDos==true){
                        if(isBin==false){
                            b=Float.parseFloat(display.getText().toString());
                            calcular(a,b,op);
                            isMas=isDiv=isMenos=isMod=isPor=isDos=false;
                            op="";
                        }else{

                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"Se debe introducir otro número!!!",Toast.LENGTH_SHORT).show();
                    }
                break;
        }
    }
    public void reset(){
        a=b=0;
        isMas=isDiv=isMenos=isMod=isPor=isDot=false;
        display.setText("");
    }
    public void calcular(float num1,float num2,String operador){
        float resul=0;
        switch (operador){
            case "+":
                resul = num1+num2;
                break;
            case "-":
                resul=num1-num2;
                break;
            case "*":
                resul=num1*num2;
                break;
            case "%":
                resul=num1%num2;
                break;
            case "/":
                if(num2>0){
                    resul=num1/num2;
                }else{
                    resul=0;
                    Toast.makeText(getApplicationContext(),"No se puede dividir por 0",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                resul=0;
                break;
        }
        display.setText(String.valueOf(resul));
    }
    public void habilita_op(String op1){
        switch (op1){
            case "+":
                isMas=true;
                isMenos=false;
                isPor=false;
                isMod=false;
                isDiv=false;
                break;
            case "-":
                isMenos=true;
                isMas=false;
                isPor=false;
                isMod=false;
                isDiv=false;
                break;
            case "*":
                isPor=true;
                isMenos=false;
                isMas=false;
                isMod=false;
                isDiv=false;
                break;
            case "%":
                isMod=true;
                isPor=false;
                isMenos=false;
                isMas=false;
                isDiv=false;
                break;
            case "/":
                isDiv=true;
                isMod=false;
                isPor=false;
                isMenos=false;
                isMas=false;
                break;
        }
    }
}
