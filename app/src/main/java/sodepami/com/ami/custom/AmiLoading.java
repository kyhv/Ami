package sodepami.com.ami.custom;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;

import sodepami.com.ami.R;

public class AmiLoading {

    private static ProgressDialog progressDialog;

    public static void showLoadingDialog(Context context) {
        progressDialog = new ProgressDialog(context, R.style.ProgressTheme);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public static void hideLoadingDialog(){
        if (progressDialog != null
                && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
