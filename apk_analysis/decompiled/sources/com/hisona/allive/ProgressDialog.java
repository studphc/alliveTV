package com.hisona.allive;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import defpackage.t30;

/* loaded from: classes2.dex */
public class ProgressDialog {
    public final AlertDialog a;
    public final ProgressBar b;
    public final TextView c;
    public DialogInterface.OnCancelListener d;

    public ProgressDialog(@NonNull Activity activity) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.progress_dialog, (ViewGroup) null);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progress);
        this.b = progressBar;
        this.c = (TextView) inflate.findViewById(R.id.text);
        progressBar.setProgress(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.ProgressDialogStyle);
        builder.setTitle("");
        builder.setMessage("");
        builder.setView(inflate);
        AlertDialog create = builder.create();
        this.a = create;
        create.setCancelable(true);
        create.setCanceledOnTouchOutside(false);
        create.setOnCancelListener(new t30(1, this));
    }

    public void dismiss() {
        this.a.dismiss();
    }

    public void setMessage(String str) {
        this.a.setMessage(str);
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.d = onCancelListener;
    }

    public void setProgress(int i) {
        this.b.setProgress(i);
        this.c.setText(i + "%");
    }

    public void setTitle(String str) {
        this.a.setTitle(str);
    }

    public void show() {
        this.a.show();
    }
}
