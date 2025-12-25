package com.hisona.allive;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import p000.sn1;

/* loaded from: classes2.dex */
public class VolumePanel {

    /* renamed from: a */
    public final LinearLayout f15965a;

    /* renamed from: b */
    public final ProgressBar f15966b;

    /* renamed from: c */
    public final Handler f15967c;

    /* renamed from: d */
    public final sn1 f15968d;

    /* renamed from: e */
    public boolean f15969e = false;

    public VolumePanel(Activity activity) {
        LinearLayout linearLayout = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.dpad_volume, (ViewGroup) null);
        this.f15965a = linearLayout;
        activity.addContentView(linearLayout, new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setVisibility(4);
        this.f15966b = (ProgressBar) activity.findViewById(R.id.volumeControl);
        this.f15967c = new Handler(Looper.getMainLooper());
        this.f15968d = new sn1(16, this);
    }

    public void closeDelayed(int i) {
        Handler handler = this.f15967c;
        sn1 sn1Var = this.f15968d;
        handler.removeCallbacks(sn1Var);
        handler.postDelayed(sn1Var, i);
    }

    public void hideVolumePanel() {
        if (!this.f15969e) {
            return;
        }
        this.f15965a.setVisibility(4);
        this.f15967c.removeCallbacks(this.f15968d);
    }

    public Boolean isPanelShow() {
        return Boolean.valueOf(this.f15969e);
    }

    public void setVolume(int i) {
        this.f15966b.setProgress(i);
    }

    public void showVolumePanel(int i) {
        this.f15969e = true;
        this.f15965a.setVisibility(0);
        this.f15967c.postDelayed(this.f15968d, i);
    }
}
