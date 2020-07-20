package mr.cset.tp_14_in;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button valider;
   private  EditText mail, passwd;
   TextView tmpTextView;
   private FrameLayout fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        valider.setOnClickListener(this);


    }

    private void initViews() {
        valider = findViewById(R.id.btnValider);
        mail = findViewById(R.id.txtEMAIL);
        passwd = findViewById(R.id.txtPASSWOD);
        fragment=findViewById(R.id.welcomeFragment);


    }

    @Override
    public void onClick(View v) {
        //initViews();
        if (v.getId() == R.id.btnValider) {


                if (!isEmailtEmpty() && !isPasswdtEmpty() ) {
                    if ( (emailValide(mail) == true) && (passwdValide(passwd)==true)) {
                        addTextViewToFragment("Bienvenue " + mail.getText().toString());

                        mail.setText("");
                        passwd.setText("");
                    }
                    else {
                        if ((emailValide(mail) == false))
                            mail.setError("mail pas valide");
                        if (passwdValide(passwd) == false)
                            passwd.setError("passwod pas valide");
                    }
                }

        }
    }
    private boolean isEmailtEmpty() {
        if (mail.getText().toString().trim().isEmpty()) {
            mail.requestFocus();
            mail.setError("Veuillez saisir un mail !");
            return true;
        }
        return false;
    }

    private boolean isPasswdtEmpty() {
        if (passwd.getText().toString().trim().isEmpty()) {
            passwd.requestFocus();
            passwd.setError("Veuillez saisir un passwod !");
            return true;
        }
        return false;
    }

    public static boolean emailValide (EditText e) {
        boolean isValid = false;
        String email = e.getText().toString().trim();
        String emailPattern = "[a-z]{2}+@[a-z]{3}+((\\.com)|(\\.net)|(\\.org))$";


        if (email.matches(emailPattern)) {
            isValid = true;

        }
        return isValid;


    }
    public static boolean passwdValide (EditText e) {
        boolean isValid = false;
        String passwd = e.getText().toString().trim();
       String passwdPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[-+!*$@%_])([-+!*$@%_\\w]{4,15})$";
       if (passwd.matches(passwdPattern)) {
          isValid = true;

      }
      return isValid;
    }



    private void addTextViewToFragment(String str) {
        int r = (int)Math.round(Math.random()*255+1);
        int g = (int)Math.round(Math.random()*255+1);
        int b = (int)Math.round(Math.random()*255+1);

      int  i=Color.argb(200,r,g,b);
        fragment=findViewById(R.id.welcomeFragment);
LinearLayout lf=new LinearLayout(this);

        tmpTextView = new TextView(this);
        tmpTextView.setTextColor(Color.BLACK);
        tmpTextView.setTextSize(16);
lf.addView(tmpTextView);
        tmpTextView.setText(str);
        fragment.addView(lf);
        fragment.setBackgroundColor(i);
    }



}