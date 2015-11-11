package com.example.pablo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnRaiz;
    Button btnPorcentaje;
    Button btnC;
    Button btnBorrar;
    Button btnDividir;
    Button btnMultiplicar;
    Button btnRestar;
    Button btnSumar;
    Button btnEx2;
    Button btnMasMenos;
    Button btnIgual;
    Button btnPunto;

    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnRaiz = (Button) findViewById(R.id.btnRaiz);
        btnPorcentaje = (Button) findViewById(R.id.btnPorcentaje);
        btnC = (Button) findViewById(R.id.btnC);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        btnDividir = (Button) findViewById(R.id.btnDividir);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnRestar = (Button) findViewById(R.id.btnRestar);
        btnSumar = (Button) findViewById(R.id.btnSumar);
        btnEx2 = (Button) findViewById(R.id.btnEx2);
        btnMasMenos = (Button) findViewById(R.id.btnMasMenos);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnPunto = (Button) findViewById(R.id.btnPunto);

        textResultado = (TextView) findViewById(R.id.textResultado);


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnRaiz.setOnClickListener(this);
        btnPorcentaje.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnSumar.setOnClickListener(this);
        btnEx2.setOnClickListener(this);
        btnMasMenos.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnPunto.setOnClickListener(this);

        textResultado.setOnClickListener(this);


    }


    int fg =0;
    String simbolo="";
    Double total= 0.0;
    int ultimoBoton=0;
    boolean serIgual=false;

    /**
     * Muestra el número (resultado) y los valores que tecleamos
     * @param num
     */
    public void mostrarNumero(String num){
        if(fg ==1){
            textResultado.setText("");
            fg =0;
        }else if(textResultado.getText()=="0"){
            textResultado.setText("");
        }
        if(!serIgual) {
            textResultado.setText(textResultado.getText() + num);
        }else{
            textResultado.setText(num.toString());
            serIgual=false;
        }
    }

    /**
     * Muestra el símbolo correspondiente a la operación
     * @param simb
     */
    public void mostrarSimbolo(String simb){
        if(ultimoBoton==R.id.btnSumar || ultimoBoton==R.id.btnRestar || ultimoBoton==R.id.btnMultiplicar || ultimoBoton==R.id.btnDividir){
            //No hace nada
        }else{
            fg =1;
            Double nuevoNumero= Double.parseDouble(textResultado.getText().toString());
            if(simbolo==""||simbolo=="="){
                total=nuevoNumero;
            }else if(simbolo=="+"){
                total= total + nuevoNumero;
            }else if(simbolo=="-"){
                total=total-nuevoNumero;
            }else if(simbolo=="*"){
                total=total*nuevoNumero;
            }else if(simbolo=="/"){
                total=total/nuevoNumero;
            }
            textResultado.setText(total.toString());
        }
        simbolo=simb;
    }

    /**
     * Recoge el id correspondiente a cada vista y realiza una operación diferente dependiendo de cual haya sido la vista seleccionada
     * @param v
     */
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn0){
            mostrarNumero("0");
        }else if(v.getId()==R.id.btn1){
            mostrarNumero("1");
        }else if(v.getId()==R.id.btn2){
            mostrarNumero("2");
        }else if(v.getId()==R.id.btn3){
            mostrarNumero("3");
        }else if(v.getId()==R.id.btn4){
            mostrarNumero("4");
        }else if(v.getId()==R.id.btn5){
            mostrarNumero("5");
        }else if(v.getId()==R.id.btn6){
            mostrarNumero("6");
        }else if(v.getId()==R.id.btn7){
            mostrarNumero("7");
        }else if(v.getId()==R.id.btn8){
            mostrarNumero("8");
        }else if(v.getId()==R.id.btn9){
            mostrarNumero("9");
        }else if(v.getId()==R.id.btnC){
            textResultado.setText("0");
            total=0.0;
            simbolo="";
        }else if(v.getId()==R.id.btnPunto){
            if(fg ==1){
                textResultado.setText("");
                fg =0;
            }
            if(textResultado.getText().toString().indexOf(".")<0){
                textResultado.setText(textResultado.getText()+".");
            }
        }else if(v.getId()==R.id.btnBorrar){
            if(textResultado.getText().toString().length()>0){
                int principio =0;
                int fin = textResultado.getText().toString().length()-1;
                String nuevoResultado= textResultado.getText().toString().substring(principio,fin);
                textResultado.setText(nuevoResultado);
                if(textResultado.getText().length()==0){
                    textResultado.setText("0");
                }
            }
        }else if(v.getId()==R.id.btnSumar){
            mostrarSimbolo("+");
        }else if(v.getId()==R.id.btnRestar) {
            mostrarSimbolo("-");
        }else if(v.getId()==R.id.btnMultiplicar){
            mostrarSimbolo("*");
        }else if(v.getId()==R.id.btnDividir){
            mostrarSimbolo("/");
        }else if(v.getId()==R.id.btnIgual){
            Double nuevoNumero = Double.parseDouble(textResultado.getText().toString());
            if(simbolo=="+"){
                total=total+nuevoNumero;
            }else if(simbolo=="-"){
                total=total-nuevoNumero;
            }else if(simbolo=="*"){
                total=total*nuevoNumero;
            }else if(simbolo=="/"){
                total=total/nuevoNumero;
            }else if(simbolo=="%"){
                total=(total*nuevoNumero)/100;
            }
            textResultado.setText(total.toString());
            serIgual=true;
            simbolo="=";
        }else if(v.getId()==R.id.btnRaiz){
            Double nuevoNumero = Double.parseDouble(textResultado.getText().toString());
            total = Math.sqrt(nuevoNumero);
            textResultado.setText(total.toString());
        }else if(v.getId()==R.id.btnPorcentaje){
            simbolo="%";
            fg =1;
            Double nuevoNumero = Double.parseDouble(textResultado.getText().toString());
            total=nuevoNumero;
        }else if(v.getId()==R.id.btnEx2){
            Double nuevoNumero = Double.parseDouble(textResultado.getText().toString());
            total = Math.pow(nuevoNumero,2);
            textResultado.setText(total.toString());
        }else if(v.getId()==R.id.btnMasMenos){
            Double nuevoNumero = Double.parseDouble(textResultado.getText().toString());
            total=nuevoNumero*(-1);
            textResultado.setText(total.toString());
        }
        ultimoBoton= v.getId();
    }
}
