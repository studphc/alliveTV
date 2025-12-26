package com.google.android.exoplayer2.p003ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.p003ui.C0731m;
import com.google.android.exoplayer2.p003ui.StyledPlayerControlView;
import java.util.ArrayList;
import java.util.Iterator;
import p000.mp2;
import p000.np2;
import p000.rp2;
import p000.tp2;
import p000.up2;

/* renamed from: com.google.android.exoplayer2.ui.m */
/* loaded from: classes.dex */
public final class C0731m {

    /* renamed from: A */
    public boolean f12353A;

    /* renamed from: B */
    public boolean f12354B;

    /* renamed from: a */
    public final StyledPlayerControlView f12356a;

    /* renamed from: b */
    public final View f12357b;

    /* renamed from: c */
    public final ViewGroup f12358c;

    /* renamed from: d */
    public final ViewGroup f12359d;

    /* renamed from: e */
    public final ViewGroup f12360e;

    /* renamed from: f */
    public final ViewGroup f12361f;

    /* renamed from: g */
    public final ViewGroup f12362g;

    /* renamed from: h */
    public final ViewGroup f12363h;

    /* renamed from: i */
    public final ViewGroup f12364i;

    /* renamed from: j */
    public final View f12365j;

    /* renamed from: k */
    public final View f12366k;

    /* renamed from: l */
    public final AnimatorSet f12367l;

    /* renamed from: m */
    public final AnimatorSet f12368m;

    /* renamed from: n */
    public final AnimatorSet f12369n;

    /* renamed from: o */
    public final AnimatorSet f12370o;

    /* renamed from: p */
    public final AnimatorSet f12371p;

    /* renamed from: q */
    public final ValueAnimator f12372q;

    /* renamed from: r */
    public final ValueAnimator f12373r;

    /* renamed from: s */
    public final rp2 f12374s = new rp2(this, 0);

    /* renamed from: t */
    public final rp2 f12375t = new rp2(this, 3);

    /* renamed from: u */
    public final rp2 f12376u = new rp2(this, 4);

    /* renamed from: v */
    public final rp2 f12377v = new rp2(this, 5);

    /* renamed from: w */
    public final rp2 f12378w = new rp2(this, 6);

    /* renamed from: x */
    public final np2 f12379x = new np2(1, this);

    /* renamed from: C */
    public boolean f12355C = true;

    /* renamed from: z */
    public int f12381z = 0;

    /* renamed from: y */
    public final ArrayList f12380y = new ArrayList();

    public C0731m(StyledPlayerControlView styledPlayerControlView) {
        final int i = 2;
        this.f12356a = styledPlayerControlView;
        final int i2 = 0;
        final int i3 = 3;
        int i4 = 4;
        final int i5 = 1;
        this.f12357b = styledPlayerControlView.findViewById(R.id.exo_controls_background);
        this.f12358c = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_center_controls);
        this.f12360e = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_bottom_bar);
        this.f12359d = viewGroup;
        this.f12364i = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_time);
        View findViewById = styledPlayerControlView.findViewById(R.id.exo_progress);
        this.f12365j = findViewById;
        this.f12361f = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_basic_controls);
        this.f12362g = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_extra_controls);
        this.f12363h = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_extra_controls_scroll_view);
        View findViewById2 = styledPlayerControlView.findViewById(R.id.exo_overflow_show);
        this.f12366k = findViewById2;
        View findViewById3 = styledPlayerControlView.findViewById(R.id.exo_overflow_hide);
        if (findViewById2 != null && findViewById3 != null) {
            findViewById2.setOnClickListener(new mp2(i4, this));
            findViewById3.setOnClickListener(new mp2(i4, this));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, RecyclerView.f7068F0);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: sp2

            /* renamed from: b */
            public final /* synthetic */ C0731m f26523b;

            {
                this.f26523b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i3) {
                    case 0:
                        C0731m c0731m = this.f26523b;
                        c0731m.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = c0731m.f12357b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = c0731m.f12358c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = c0731m.f12360e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            return;
                        }
                        return;
                    case 1:
                        C0731m c0731m2 = this.f26523b;
                        c0731m2.getClass();
                        c0731m2.m2967a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    case 2:
                        C0731m c0731m3 = this.f26523b;
                        c0731m3.getClass();
                        c0731m3.m2967a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    default:
                        C0731m c0731m4 = this.f26523b;
                        c0731m4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = c0731m4.f12357b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = c0731m4.f12358c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = c0731m4.f12360e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            return;
                        }
                        return;
                }
            }
        });
        ofFloat.addListener(new tp2(this, 0));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(RecyclerView.f7068F0, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: sp2

            /* renamed from: b */
            public final /* synthetic */ C0731m f26523b;

            {
                this.f26523b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        C0731m c0731m = this.f26523b;
                        c0731m.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = c0731m.f12357b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = c0731m.f12358c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = c0731m.f12360e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            return;
                        }
                        return;
                    case 1:
                        C0731m c0731m2 = this.f26523b;
                        c0731m2.getClass();
                        c0731m2.m2967a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    case 2:
                        C0731m c0731m3 = this.f26523b;
                        c0731m3.getClass();
                        c0731m3.m2967a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    default:
                        C0731m c0731m4 = this.f26523b;
                        c0731m4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = c0731m4.f12357b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = c0731m4.f12358c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = c0731m4.f12360e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            return;
                        }
                        return;
                }
            }
        });
        ofFloat2.addListener(new tp2(this, 1));
        Resources resources = styledPlayerControlView.getResources();
        int i6 = R.dimen.exo_styled_bottom_bar_height;
        float dimension = resources.getDimension(i6) - resources.getDimension(R.dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(i6);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f12367l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new up2(this, styledPlayerControlView, i2));
        animatorSet.play(ofFloat).with(m2965d(findViewById, RecyclerView.f7068F0, dimension)).with(m2965d(viewGroup, RecyclerView.f7068F0, dimension));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f12368m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new up2(this, styledPlayerControlView, i5));
        animatorSet2.play(m2965d(findViewById, dimension, dimension2)).with(m2965d(viewGroup, dimension, dimension2));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f12369n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new up2(this, styledPlayerControlView, i));
        animatorSet3.play(ofFloat).with(m2965d(findViewById, RecyclerView.f7068F0, dimension2)).with(m2965d(viewGroup, RecyclerView.f7068F0, dimension2));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f12370o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new tp2(this, 2));
        animatorSet4.play(ofFloat2).with(m2965d(findViewById, dimension, RecyclerView.f7068F0)).with(m2965d(viewGroup, dimension, RecyclerView.f7068F0));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f12371p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new tp2(this, 3));
        animatorSet5.play(ofFloat2).with(m2965d(findViewById, dimension2, RecyclerView.f7068F0)).with(m2965d(viewGroup, dimension2, RecyclerView.f7068F0));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(RecyclerView.f7068F0, 1.0f);
        this.f12372q = ofFloat3;
        ofFloat3.setDuration(250L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: sp2

            /* renamed from: b */
            public final /* synthetic */ C0731m f26523b;

            {
                this.f26523b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i5) {
                    case 0:
                        C0731m c0731m = this.f26523b;
                        c0731m.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = c0731m.f12357b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = c0731m.f12358c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = c0731m.f12360e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            return;
                        }
                        return;
                    case 1:
                        C0731m c0731m2 = this.f26523b;
                        c0731m2.getClass();
                        c0731m2.m2967a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    case 2:
                        C0731m c0731m3 = this.f26523b;
                        c0731m3.getClass();
                        c0731m3.m2967a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    default:
                        C0731m c0731m4 = this.f26523b;
                        c0731m4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = c0731m4.f12357b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = c0731m4.f12358c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = c0731m4.f12360e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            return;
                        }
                        return;
                }
            }
        });
        ofFloat3.addListener(new tp2(this, 4));
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, RecyclerView.f7068F0);
        this.f12373r = ofFloat4;
        ofFloat4.setDuration(250L);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: sp2

            /* renamed from: b */
            public final /* synthetic */ C0731m f26523b;

            {
                this.f26523b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        C0731m c0731m = this.f26523b;
                        c0731m.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = c0731m.f12357b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = c0731m.f12358c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = c0731m.f12360e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            return;
                        }
                        return;
                    case 1:
                        C0731m c0731m2 = this.f26523b;
                        c0731m2.getClass();
                        c0731m2.m2967a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    case 2:
                        C0731m c0731m3 = this.f26523b;
                        c0731m3.getClass();
                        c0731m3.m2967a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    default:
                        C0731m c0731m4 = this.f26523b;
                        c0731m4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = c0731m4.f12357b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = c0731m4.f12358c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = c0731m4.f12360e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            return;
                        }
                        return;
                }
            }
        });
        ofFloat4.addListener(new tp2(this, 5));
    }

    /* renamed from: c */
    public static int m2964c(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        }
        return width;
    }

    /* renamed from: d */
    public static ObjectAnimator m2965d(View view, float f, float f2) {
        return ObjectAnimator.ofFloat(view, "translationY", f, f2);
    }

    /* renamed from: j */
    public static boolean m2966j(View view) {
        int id = view.getId();
        if (id != R.id.exo_bottom_bar && id != R.id.exo_prev && id != R.id.exo_next && id != R.id.exo_rew && id != R.id.exo_rew_with_amount && id != R.id.exo_ffwd && id != R.id.exo_ffwd_with_amount) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final void m2967a(float f) {
        ViewGroup viewGroup = this.f12363h;
        if (viewGroup != null) {
            viewGroup.setTranslationX((int) ((1.0f - f) * viewGroup.getWidth()));
        }
        ViewGroup viewGroup2 = this.f12364i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f);
        }
        ViewGroup viewGroup3 = this.f12361f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f);
        }
    }

    /* renamed from: b */
    public final boolean m2968b(View view) {
        if (view != null && this.f12380y.contains(view)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final void m2969e(long j, Runnable runnable) {
        if (j >= 0) {
            this.f12356a.postDelayed(runnable, j);
        }
    }

    /* renamed from: f */
    public final void m2970f() {
        rp2 rp2Var = this.f12378w;
        StyledPlayerControlView styledPlayerControlView = this.f12356a;
        styledPlayerControlView.removeCallbacks(rp2Var);
        styledPlayerControlView.removeCallbacks(this.f12375t);
        styledPlayerControlView.removeCallbacks(this.f12377v);
        styledPlayerControlView.removeCallbacks(this.f12376u);
    }

    /* renamed from: g */
    public final void m2971g() {
        if (this.f12381z == 3) {
            return;
        }
        m2970f();
        int showTimeoutMs = this.f12356a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.f12355C) {
                m2969e(showTimeoutMs, this.f12378w);
            } else if (this.f12381z == 1) {
                m2969e(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, this.f12376u);
            } else {
                m2969e(showTimeoutMs, this.f12377v);
            }
        }
    }

    /* renamed from: h */
    public final void m2972h(View view, boolean z) {
        if (view == null) {
            return;
        }
        ArrayList arrayList = this.f12380y;
        if (!z) {
            view.setVisibility(8);
            arrayList.remove(view);
            return;
        }
        if (this.f12353A && m2966j(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        arrayList.add(view);
    }

    /* renamed from: i */
    public final void m2973i(int i) {
        int i2 = this.f12381z;
        this.f12381z = i;
        StyledPlayerControlView styledPlayerControlView = this.f12356a;
        if (i == 2) {
            styledPlayerControlView.setVisibility(8);
        } else if (i2 == 2) {
            styledPlayerControlView.setVisibility(0);
        }
        if (i2 != i) {
            Iterator it = styledPlayerControlView.f12204b.iterator();
            while (it.hasNext()) {
                ((StyledPlayerControlView.VisibilityListener) it.next()).onVisibilityChange(styledPlayerControlView.getVisibility());
            }
        }
    }

    /* renamed from: k */
    public final void m2974k() {
        if (!this.f12355C) {
            m2973i(0);
            m2971g();
            return;
        }
        int i = this.f12381z;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return;
                    }
                } else {
                    this.f12354B = true;
                }
            } else {
                this.f12371p.start();
            }
        } else {
            this.f12370o.start();
        }
        m2971g();
    }
}
