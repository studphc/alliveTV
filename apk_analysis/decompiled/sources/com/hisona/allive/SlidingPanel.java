package com.hisona.allive;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.hisona.allive.Utils;
import defpackage.rk2;
import defpackage.sn1;

/* loaded from: classes2.dex */
public class SlidingPanel {
    public final Animation a;
    public final Animation b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final ImageView h;
    public final ImageView i;
    public final ProgressBar j;
    public final Handler k;
    public final sn1 l;
    public boolean m = false;

    public SlidingPanel(Activity activity) {
        this.c = (LinearLayout) activity.findViewById(R.id.slidingPanel);
        this.h = (ImageView) activity.findViewById(R.id.siteView);
        this.e = (TextView) activity.findViewById(R.id.infoView);
        this.f = (TextView) activity.findViewById(R.id.timeView);
        this.g = (TextView) activity.findViewById(R.id.resView);
        this.i = (ImageView) activity.findViewById(R.id.favoriteView);
        this.j = (ProgressBar) activity.findViewById(R.id.timeProgress);
        LinearLayout linearLayout = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.dpad_videoplayer, (ViewGroup) null);
        this.d = linearLayout;
        activity.addContentView(linearLayout, new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setVisibility(4);
        Animation loadAnimation = AnimationUtils.loadAnimation(activity, R.anim.translate_top);
        this.a = loadAnimation;
        Animation loadAnimation2 = AnimationUtils.loadAnimation(activity, R.anim.translate_bottom);
        this.b = loadAnimation2;
        loadAnimation.setAnimationListener(new rk2(this, 0));
        loadAnimation2.setAnimationListener(new rk2(this, 1));
        this.k = new Handler(Looper.getMainLooper());
        this.l = new sn1(7, this);
    }

    public void closeDelayed(int i) {
        Handler handler = this.k;
        sn1 sn1Var = this.l;
        handler.removeCallbacks(sn1Var);
        handler.postDelayed(sn1Var, i);
    }

    public void hideDPadPanel() {
        this.d.setVisibility(4);
    }

    public void hideFavorite() {
        this.i.setVisibility(4);
    }

    public void hideSlidingPanel(boolean z) {
        if (!this.m) {
            return;
        }
        Animation animation = this.b;
        LinearLayout linearLayout = this.c;
        linearLayout.startAnimation(animation);
        linearLayout.setVisibility(4);
        if (z) {
            this.d.setVisibility(4);
        }
        this.k.removeCallbacks(this.l);
    }

    public Boolean isPanelShow() {
        return Boolean.valueOf(this.m);
    }

    public void setInfoText(String str) {
        this.e.setText(str);
    }

    public void setResText(String str) {
        this.g.setText(str);
    }

    public void setSiteIcon(int i) {
        int ordinal = Utils.SiteType.Wavve.ordinal();
        ImageView imageView = this.h;
        if (i == ordinal) {
            imageView.setImageResource(R.drawable.wavve_icon_24);
        } else if (i == Utils.SiteType.Tving.ordinal()) {
            imageView.setImageResource(R.drawable.tving_icon_24);
        }
    }

    public void setTimeProgress(int i) {
        this.j.setProgress(i);
    }

    public void setTimeText(String str) {
        this.f.setText(str);
    }

    public void showDpadPanel() {
        this.d.setVisibility(0);
    }

    public void showFavorite() {
        this.i.setVisibility(0);
    }

    public void showSlidingPanel(int i, int i2) {
        int ordinal = Utils.SiteType.Wavve.ordinal();
        ImageView imageView = this.h;
        if (i == ordinal) {
            imageView.setImageResource(R.drawable.wavve_icon_24);
        } else if (i == Utils.SiteType.Tving.ordinal()) {
            imageView.setImageResource(R.drawable.tving_icon_24);
        }
        Animation animation = this.a;
        LinearLayout linearLayout = this.c;
        linearLayout.startAnimation(animation);
        linearLayout.setVisibility(0);
        int visibility = this.d.getVisibility();
        sn1 sn1Var = this.l;
        Handler handler = this.k;
        if (visibility == 0) {
            handler.postDelayed(sn1Var, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        } else {
            handler.postDelayed(sn1Var, i2);
        }
    }
}
