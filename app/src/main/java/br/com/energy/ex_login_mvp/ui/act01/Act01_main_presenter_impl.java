package br.com.energy.ex_login_mvp.ui.act01;

import android.content.Context;

import br.com.energy.ex_login_mvp.R;

/**
 * Created by addmn.cassio on 13/05/2017.
 */

public class Act01_main_presenter_impl implements Act01_main_presenter {
    private Context context;

    private Act01_main_View mView;

    private String message;

    public Act01_main_presenter_impl(Context context, Act01_main_View mView) {
        this.context = context;
        this.mView = mView;
    }

    @Override
    public void validForm(String name, String password) {


        if (validation(name, password)) {
            mView.callSecondScreen();
        }else{
            mView.showMessage(message);
        }


    }

    private boolean validation(String name, String password) {

        if (name.trim().length() == 0) {
            message = context.getString(R.string.act01_main_msg_error_name_required);
            return false;
        }
        if (password.trim().length() == 0) {
            message = context.getString(R.string.act01_main_msg_error_password_required);
            return false;
        }
        if (!name.equalsIgnoreCase("Cassio") || !password.equals("Palestra")) {
            message = context.getString(R.string.act01_main_msg_error_credential_invalid);
            return false;
        }

        return true;
    }

    @Override
    public void action_BackPressed() {



    }


}
