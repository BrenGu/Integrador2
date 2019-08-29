package com.example.integrador2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity implements View.OnClickListener {


    /*Se crean los campos nocesarios para recoger los componentes de la interfaz
    *grafica que luego tendremos que utilizar */

    EditText dolares;
    EditText euros;
    EditText cambio;
    RadioButton dtoe;
    RadioButton etod;
    Button convert;


    /*Fin de Campos*/

    /*Se Inicia la Actividad*/
    /*En el metodo onCreate() le damos memoria a los campos creados en la clase
    *ademas de suscribir los eventos de los radioButton y el boton convertir */

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);



        //INICIALIZACION DE CAMPOS //

        dolares = (EditText)this.findViewById(R.id.etDolares);
        euros = (EditText)this.findViewById(R.id.etEuros);
        cambio= (EditText)this.findViewById(R.id.etCambio);

        dtoe = (RadioButton)this.findViewById(R.id.rbDolarAeuros);
        dtoe.setChecked(true);
        etod= (RadioButton)this.findViewById(R.id.rbEuroAdolar);

        convert= (Button)this.findViewById(R.id.btnConvertir);

        /*Fin de Inicializacion de Campos*/

        /*Eventos */

        convert.setOnClickListener(this);
        dtoe.setOnClickListener(this);
        etod.setOnClickListener(this);

        /*Fin de Eventos*/
     }

    /*Se crea el Metodo de convertir los dolares a euros */


    protected void convertDolaresEnEuros(){

        double val;
        double tmp;
        /*Controla los campos introducidos */

        if("".equals(dolares.getText().toString())){
            val=0;
        }
        else {
            val = Double.parseDouble(dolares.getText().toString());
        }
        if("".equals(cambio.getText().toString())){
            tmp=0;
        }
        else {
            tmp = Double.parseDouble(cambio.getText().toString());
        }

        /*Convierto el cambio a euros*/
        euros.setText(Double.toString(val*tmp));
    }

    /* Se crea el metodo que convierte los euros a dolares */

    protected void convertEurosEnDolares(){

        double val;
        double tmp;

        /*Controlamos los campos introducidos */

        if("".equals(euros.getText().toString())){
           val=0;
        }
        else {
            val= Double.parseDouble((euros.getText().toString()));
        }
        if("".equals(cambio.getText().toString())){
            tmp=0;
        }
        else{
            tmp = Double.parseDouble(cambio.getText().toString());
        }

        /*Convertimos los cambios a dolares*/
        dolares.setText(Double.toString(val/tmp));
    }

    /*FINALMENTE Comntrolamos que no haya dos RdioButtons chequeados y segun la opcion que
    *realicemos la conversion */

    /*
    *Convertir los euros a dolares o
    * los dolares a euros
     */

    @Override
    public void onClick(View v) {

        /*Controlo el radiobuttons chequeado */

        if(v==convert){
            if(dtoe.isChecked()){
                convertDolaresEnEuros();
            }
            if(etod.isChecked()){
                convertEurosEnDolares();
            }
        }
        /*Controlo que no esten dos radioButtons chequeados */
        if(v==dtoe){
            etod.setChecked(false);
        }
        if(v ==etod){
            dtoe.setChecked(false);
        }
    }
}
