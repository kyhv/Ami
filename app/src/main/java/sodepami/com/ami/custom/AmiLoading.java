package sodepami.com.ami.custom;

import android.app.AlertDialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;

import sodepami.com.ami.R;

public class AmiLoading {

    private static AlertDialog alertDialog;

    public static void showLoadingDialog(Context context) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.FullScreenDialog));
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View dialogView = inflater.inflate(R.layout.custom_loading, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    public static void hideLoadingDialog(){
        alertDialog.dismiss();
    }
}
