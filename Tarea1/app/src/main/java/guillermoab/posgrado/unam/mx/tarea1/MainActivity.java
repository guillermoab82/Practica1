package guillermoab.posgrado.unam.mx.tarea1;

import android.content.res.Resources;
import android.os.CancellationSignal;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private float a,b;
    private int bin_a,bin_b;
    private boolean isMas,isMenos,isPor,isDiv,isMod,isDot,isBin,isDos;
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
                WriteNumber(v.getId());
                break;
            case R.id.activitymain_btnbin:
                IsBinEnabled();
                break;
            case R.id.activitymain_btnC:
                reset();
                break;
            case R.id.activitymain_btndel:
                DelLastStr(display.getText().toString());
                break;
            case R.id.activitymain_btndiv:
            case R.id.activitymain_btnmas:
            case R.id.activitymain_btnmenos:
            case R.id.activitymain_btnmod:
            case R.id.activitymain_btnpor:
                ChooseOp(display.getText().toString(),v.getId());
                break;
            case R.id.activitymain_btndot:
                PushDot(display.getText().toString(),v.getId());
                break;
            case R.id.activitymain_btn0:
                WriteZero(display.getText().toString());
                break;
            case R.id.activitymain_btnigual:
                    if(isDos==true){
                        if(isBin==false){
                            b=Float.parseFloat(display.getText().toString());
                            calcular(a,b,op);
                            isMas=isDiv=isMenos=isMod=isPor=isDos=isDot=false;
                            op="";
                        }else{
                            bin_b=Integer.parseInt(display.getText().toString(),2);
                            getBinResult(bin_a,bin_b,op);
                            isMas=isDiv=isMenos=isMod=isPor=isDos=isDot=false;
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),R.string.another_number,Toast.LENGTH_SHORT).show();
                    }
                break;
        }
    }

    public void WriteNumber(int btnID){
        Button number = (Button) findViewById(btnID);
        if(isPor==false && isMas==false && isMod==false && isMenos==false && isDiv==false) {
            disp=display.getText().toString();
            if(!TextUtils.isEmpty(disp) && !disp.equals("0")){
                disp = display.getText().toString()+number.getText().toString();
                display.setText(disp);
            }else{
                display.setText(number.getText().toString());
            }
        }else{
            if(isDos==false){
                display.setText("");
            }
            disp=display.getText().toString();
            if(!TextUtils.isEmpty(disp) && !disp.equals("0")){
                disp = display.getText().toString()+number.getText().toString();
            }else{
                disp=number.getText().toString();
            }
            isDos=true;
            isDot=false;
            display.setText(disp);
        }
    }
    public void IsBinEnabled(){
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
            Button btn = (Button) findViewById(R.id.activitymain_btnbin);
            btn.setText(R.string.decimal);
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
            Button btn = (Button) findViewById(R.id.activitymain_btnbin);
            btn.setText(R.string.binario);
            isBin=false;
        }
        reset();
    }
    public void reset(){
        a=b=0;
        isMas=isDiv=isMenos=isMod=isPor=isDot=isDos=false;
        op="";
        display.setText("");
    }
    public void DelLastStr(String strDisplay){
        disp=strDisplay;
        if(!TextUtils.isEmpty(disp)){
            String last_str = disp.substring(disp.length()-1);
            if(last_str.equals("+") || last_str.equals("-") || last_str.equals("*") || last_str.equals("/") || last_str.equals("M")){
                isMas=isDiv=isMenos=isMod=isPor=false;
                op="";
            }else{
                if(last_str.equals(".")){
                    isDot=false;
                }
            }
            display.setText(disp.substring(0,disp.length()-1));
        }else{
            Toast.makeText(getApplicationContext(),R.string.begin,Toast.LENGTH_SHORT).show();
        }
    }
    public void ChooseOp(String strDisplay,int btnId){
        disp=strDisplay;
        if(!TextUtils.isEmpty(disp)){
            Button operacion = (Button) findViewById(btnId);
            if(isPor==false && isMas==false && isMod==false && isMenos==false && isDiv==false) {
                if(isBin==false){
                    a=Float.parseFloat(disp);
                }else{
                    bin_a= Integer.parseInt(disp,2);
                }
                op=operacion.getText().toString();
                if(op.equals("mod")){
                    op="%";
                }
                disp = display.getText().toString()+op;
                display.setText(disp);
                habilita_op(op);
            }else{
                if(isDos==false){
                    op=operacion.getText().toString();
                    disp=disp.substring(0,disp.length()-1);
                    if(isBin==false){
                        a=Float.parseFloat(disp);
                    }else{
                        bin_a= Integer.parseInt(disp,2);
                    }
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
                    }else{
                        //código para calculadora binarea en el caso de haber ingresado
                        //el segundo numerando y haber presionado otro signo, en este caso
                        //el más.
                        bin_b = Integer.parseInt(disp,2);
                        getBinResult(bin_a,bin_b,op);
                        op=operacion.getText().toString();
                        disp=display.getText().toString();
                        bin_a = Integer.parseInt(disp,2);
                    }
                    disp = display.getText().toString()+op;
                    display.setText(disp);
                    habilita_op(op);
                    isDos=false;
                }
            }
        }
    }
    public void PushDot(String StrDisplay,int btnId){
        disp=StrDisplay;
        Button dot = (Button) findViewById(btnId);
        if(!TextUtils.isEmpty(disp)){
            if(disp.indexOf(".")>=0) {
                isDot=true;
                Toast.makeText(getApplicationContext(),R.string.onedot,Toast.LENGTH_SHORT).show();
            }else{
                if(isDot==false){
                    if(isPor==false && isMas==false && isMod==false && isMenos==false && isDiv==false) {
                        disp = display.getText().toString()+dot.getText().toString();
                        display.setText(disp);
                    }else{
                        if(isDos==false){
                            display.setText("");
                            disp="";
                        }
                        display.setText(disp+dot.getText().toString());
                        isDos=true;
                    }
                    isDot=true;
                }else{
                    Toast.makeText(getApplicationContext(),R.string.onedot,Toast.LENGTH_SHORT).show();
                }
            }
        }else {
            if(isDot==false){
                disp = "0"+dot.getText().toString();
                display.setText(disp);
                isDot=true;
            }else {
                Toast.makeText(getApplicationContext(),R.string.onedot,Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void WriteZero(String StrDisplay){
        disp=StrDisplay;
        if(!TextUtils.isEmpty(disp)){
            if(isPor==false && isMas==false && isMod==false && isMenos==false && isDiv==false) {
                disp = display.getText().toString()+"0";
                display.setText(disp);
            }else{
                if(isDos==false){
                    display.setText("");
                    disp="";
                }
                isDos=true;
                isDot=false;
                display.setText(disp+"0");
            }
        }else{
            display.setText("0");
        }
    }
    public void getBinResult(int num1,int num2,String op){
        int bin_res;
        bin_res = num1+num2;
        display.setText(Integer.toString(bin_res,2));
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
                    Toast.makeText(getApplicationContext(),R.string.nodivide,Toast.LENGTH_SHORT).show();
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
