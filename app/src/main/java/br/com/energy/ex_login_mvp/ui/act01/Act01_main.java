package br.com.energy.ex_login_mvp.ui.act01;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.energy.ex_login_mvp.R;

/**
 * Created by addmn.cassio on 13/05/2017.
 */

public class Act01_main extends AppCompatActivity implements Act01_main_View {

    private Context context;
    private EditText et_name;
    private EditText et_password;
    private Button btn_cancel;
    private Button btn_login;
    //especializado em processar comandos
    private Act01_main_presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act01_main);
        inicializar();
        iniActions();
    }


    private void inicializar() {
        context = getBaseContext();

        mPresenter = new Act01_main_presenter_impl(context, this);
        et_name = (EditText) findViewById(R.id.act01_main_et_name);
        et_password = (EditText) findViewById(R.id.act01_main_et_password);

        btn_cancel = (Button) findViewById(R.id.act01_main_btn_cancel);
        btn_login = (Button) findViewById(R.id.act01_main_btn_login);

    }

    private void iniActions() {
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanScreen();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.validForm(et_name.getText().toString(), et_password.getText().toString());
            }
        });
    }

    private void cleanScreen() {
        et_password.setText("");
        et_name.setText("");
    }

    @Override
    public void showMessage(String mensagem) {
        AlertDialog.Builder alert = new AlertDialog.Builder(Act01_main.this);
        alert.setTitle(R.string.act01_main_label_alert_title);
        alert.setMessage(mensagem);
        alert.setPositiveButton(R.string.act01_main_label_alert_btn_ok, null);
        alert.show();
    }

    @Override
    public void callSecondScreen() {
        Toast.makeText(context,
                "Implementar Chamar a Segunda Tela",
                Toast.LENGTH_SHORT).show();
    }
}
