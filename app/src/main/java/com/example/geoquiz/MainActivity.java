package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    //capturacion del view
    private TextView preguntaTextView, nPreguntas_textView, naciertos_textView;
    private Button verdaderoButton, falsoButton;
    private ImageButton siguienteImageButton, anteriorImageButton;

    //atributos para las questions
    private int idActual = 0;
    private Question[] questionArray = new Question[]{
            new Question(R.string.pregunta0,true),
            new Question(R.string.pregunta1,false),
            new Question(R.string.pregunta2,true),
            new Question(R.string.pregunta3,true),
            new Question(R.string.pregunta4,false),
            new Question(R.string.pregunta5,false),
            new Question(R.string.pregunta6,false)
    };

    //calificacion de aciertos
    private Calification calification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializamos la clase con 0 aciertos
        calification = new Calification();

        //numero de aciertos
        naciertos_textView = (TextView) findViewById(R.id.naciertos_textView);

        //numero de la pregunta en la que se esta
         nPreguntas_textView = (TextView) findViewById(R.id.nPreguntas_textView);

        //pregunta
        preguntaTextView = (TextView) findViewById(R.id.pregunta_textView);
        actulizarEstadoPregunta();
        preguntaTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                siguiente();
            }
        });

        //boton verdadero
        verdaderoButton = (Button) findViewById(R.id.verdadero_button);
        verdaderoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //comprobamos si es verdadero
                comprobarQuestion(true);
            }
        });

        //boton falso
        falsoButton = (Button) findViewById(R.id.falso_button);
        falsoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //comprobamos si es falso
                comprobarQuestion(false);
               }
        });

        //boton siguiente
        siguienteImageButton = (ImageButton) findViewById(R.id.siguiente_button);
        siguienteImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                siguiente();
            }
        });

        //boton anterior
       anteriorImageButton = (ImageButton) findViewById(R.id.anterior_button);
        anteriorImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                anterior();
            }
        });
    }

    private void actulizarEstadoPregunta() {
       // String estado = R.string.nPreguntas_text+idActual+"/"+(questionArray.length-1);
        String estado = idActual+"/"+(questionArray.length-1);
        nPreguntas_textView.setText(estado);
    }

    //comprobamos si es verdadero o falso la respuesta
    public void comprobarQuestion(boolean answer){
        if(questionArray[idActual].isAnswer() == answer){ //es correcta
            calification.setnAciertos(calification.getnAciertos()+1);
            Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
        }else{//es falsa
            calification.setnFallos(calification.getnFallos()+1);
            Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }

        try {
            //se muestra el porcentaje de aciertos
            naciertos_textView.setText("A: "+calification.getnAciertos()+"\n F: "+calification.getnFallos());
        }catch (Resources.NotFoundException e){
            e.getCause();
            e.getStackTrace();
        }
    }

    //accion del boton siguiente
    private void siguiente() {
        if((idActual+1) <= questionArray.length-1){
            idActual = idActual+1;
            int idText = questionArray[idActual].getIdText();
            preguntaTextView.setText(idText);
        }else{
            Toast.makeText(MainActivity.this,R.string.notQuestion,Toast.LENGTH_SHORT).show();
        }

        actulizarEstadoPregunta();
    }

    //accion del boton anterior
    private void anterior() {
        if((idActual-1) >= 0){
            idActual = idActual-1;
            int idText = questionArray[idActual].getIdText();
            preguntaTextView.setText(idText);
        }else{
            Toast.makeText(MainActivity.this,R.string.notQuestion,Toast.LENGTH_SHORT).show();
        }

        actulizarEstadoPregunta();
    }
}