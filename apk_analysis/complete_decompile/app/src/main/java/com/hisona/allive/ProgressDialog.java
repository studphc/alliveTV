package com.hisona.allive;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import p000.t30;

/* loaded from: classes2.dex */
public class ProgressDialog {

    /* renamed from: a */
    public final AlertDialog f15907a;

    /* renamed from: b */
    public final ProgressBar f15908b;

    /* renamed from: c */
    public final TextView f15909c;

    /* renamed from: d */
    public DialogInterface.OnCancelListener f15910d;

    public ProgressDialog(@NonNull Activity activity) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.progress_dialog, (ViewGroup) null);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progress);
        this.f15908b = progressBar;
        this.f15909c = (TextView) inflate.findViewById(R.id.text);
        progressBar.setProgress(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.ProgressDialogStyle);
        builder.setTitle("");
        builder.setMessage("");
        builder.setView(inflate);
        AlertDialog create = builder.create();
        this.f15907a = create;
        create.setCancelable(true);
        create.setCanceledOnTouchOutside(false);
        create.setOnCancelListener(new t30(1, this));
    }

    public void dismiss() {
        this.f15907a.dismiss();
    }

    public void setMessage(String str) {
        this.f15907a.setMessage(str);
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.f15910d = onCancelListener;
    }

    public void setProgress(int i) {
        this.f15908b.setProgress(i);
        this.f15909c.setText(i + "%");
    }

    public void setTitle(String str) {
        this.f15907a.setTitle(str);
    }

    public void show() {
        this.f15907a.show();
    }
}
