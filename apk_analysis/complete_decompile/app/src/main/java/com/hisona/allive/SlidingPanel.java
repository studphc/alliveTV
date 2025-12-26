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
import com.google.android.exoplayer2.C0643C;
import com.hisona.allive.Utils;
import p000.rk2;
import p000.sn1;

/* loaded from: classes2.dex */
public class SlidingPanel {

    /* renamed from: a */
    public final Animation f15937a;

    /* renamed from: b */
    public final Animation f15938b;

    /* renamed from: c */
    public final LinearLayout f15939c;

    /* renamed from: d */
    public final LinearLayout f15940d;

    /* renamed from: e */
    public final TextView f15941e;

    /* renamed from: f */
    public final TextView f15942f;

    /* renamed from: g */
    public final TextView f15943g;

    /* renamed from: h */
    public final ImageView f15944h;

    /* renamed from: i */
    public final ImageView f15945i;

    /* renamed from: j */
    public final ProgressBar f15946j;

    /* renamed from: k */
    public final Handler f15947k;

    /* renamed from: l */
    public final sn1 f15948l;

    /* renamed from: m */
    public boolean f15949m = false;

    public SlidingPanel(Activity activity) {
        this.f15939c = (LinearLayout) activity.findViewById(R.id.slidingPanel);
        this.f15944h = (ImageView) activity.findViewById(R.id.siteView);
        this.f15941e = (TextView) activity.findViewById(R.id.infoView);
        this.f15942f = (TextView) activity.findViewById(R.id.timeView);
        this.f15943g = (TextView) activity.findViewById(R.id.resView);
        this.f15945i = (ImageView) activity.findViewById(R.id.favoriteView);
        this.f15946j = (ProgressBar) activity.findViewById(R.id.timeProgress);
        LinearLayout linearLayout = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.dpad_videoplayer, (ViewGroup) null);
        this.f15940d = linearLayout;
        activity.addContentView(linearLayout, new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setVisibility(4);
        Animation loadAnimation = AnimationUtils.loadAnimation(activity, R.anim.translate_top);
        this.f15937a = loadAnimation;
        Animation loadAnimation2 = AnimationUtils.loadAnimation(activity, R.anim.translate_bottom);
        this.f15938b = loadAnimation2;
        loadAnimation.setAnimationListener(new rk2(this, 0));
        loadAnimation2.setAnimationListener(new rk2(this, 1));
        this.f15947k = new Handler(Looper.getMainLooper());
        this.f15948l = new sn1(7, this);
    }

    public void closeDelayed(int i) {
        Handler handler = this.f15947k;
        sn1 sn1Var = this.f15948l;
        handler.removeCallbacks(sn1Var);
        handler.postDelayed(sn1Var, i);
    }

    public void hideDPadPanel() {
        this.f15940d.setVisibility(4);
    }

    public void hideFavorite() {
        this.f15945i.setVisibility(4);
    }

    public void hideSlidingPanel(boolean z) {
        if (!this.f15949m) {
            return;
        }
        Animation animation = this.f15938b;
        LinearLayout linearLayout = this.f15939c;
        linearLayout.startAnimation(animation);
        linearLayout.setVisibility(4);
        if (z) {
            this.f15940d.setVisibility(4);
        }
        this.f15947k.removeCallbacks(this.f15948l);
    }

    public Boolean isPanelShow() {
        return Boolean.valueOf(this.f15949m);
    }

    public void setInfoText(String str) {
        this.f15941e.setText(str);
    }

    public void setResText(String str) {
        this.f15943g.setText(str);
    }

    public void setSiteIcon(int i) {
        int ordinal = Utils.SiteType.Wavve.ordinal();
        ImageView imageView = this.f15944h;
        if (i == ordinal) {
            imageView.setImageResource(R.drawable.wavve_icon_24);
        } else if (i == Utils.SiteType.Tving.ordinal()) {
            imageView.setImageResource(R.drawable.tving_icon_24);
        }
    }

    public void setTimeProgress(int i) {
        this.f15946j.setProgress(i);
    }

    public void setTimeText(String str) {
        this.f15942f.setText(str);
    }

    public void showDpadPanel() {
        this.f15940d.setVisibility(0);
    }

    public void showFavorite() {
        this.f15945i.setVisibility(0);
    }

    public void showSlidingPanel(int i, int i2) {
        int ordinal = Utils.SiteType.Wavve.ordinal();
        ImageView imageView = this.f15944h;
        if (i == ordinal) {
            imageView.setImageResource(R.drawable.wavve_icon_24);
        } else if (i == Utils.SiteType.Tving.ordinal()) {
            imageView.setImageResource(R.drawable.tving_icon_24);
        }
        Animation animation = this.f15937a;
        LinearLayout linearLayout = this.f15939c;
        linearLayout.startAnimation(animation);
        linearLayout.setVisibility(0);
        int visibility = this.f15940d.getVisibility();
        sn1 sn1Var = this.f15948l;
        Handler handler = this.f15947k;
        if (visibility == 0) {
            handler.postDelayed(sn1Var, C0643C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        } else {
            handler.postDelayed(sn1Var, i2);
        }
    }
}
