package sodepami.com.ami.utils;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;

public class DialogHelper {

    public static void alertDialog(Context context, String message, String ok, final DialogButtonListener listener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton(ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (listener != null) {
                    listener.onOKClicked();
                }
            }
        });
        builder.setMessage(message);
        builder.show();
    }

    public interface DialogButtonListener {
        void onOKClicked();
    }
}
