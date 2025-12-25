package com.hisona.allive;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import defpackage.sn1;

/* loaded from: classes2.dex */
public class VolumePanel {
    public final LinearLayout a;
    public final ProgressBar b;
    public final Handler c;
    public final sn1 d;
    public boolean e = false;

    public VolumePanel(Activity activity) {
        LinearLayout linearLayout = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.dpad_volume, (ViewGroup) null);
        this.a = linearLayout;
        activity.addContentView(linearLayout, new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setVisibility(4);
        this.b = (ProgressBar) activity.findViewById(R.id.volumeControl);
        this.c = new Handler(Looper.getMainLooper());
        this.d = new sn1(16, this);
    }

    public void closeDelayed(int i) {
        Handler handler = this.c;
        sn1 sn1Var = this.d;
        handler.removeCallbacks(sn1Var);
        handler.postDelayed(sn1Var, i);
    }

    public void hideVolumePanel() {
        if (!this.e) {
            return;
        }
        this.a.setVisibility(4);
        this.c.removeCallbacks(this.d);
    }

    public Boolean isPanelShow() {
        return Boolean.valueOf(this.e);
    }

    public void setVolume(int i) {
        this.b.setProgress(i);
    }

    public void showVolumePanel(int i) {
        this.e = true;
        this.a.setVisibility(0);
        this.c.postDelayed(this.d, i);
    }
}
