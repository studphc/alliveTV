package p000;

import android.content.res.Resources;
import android.view.View;
import androidx.leanback.R;

/* loaded from: classes.dex */
public final class rs0 implements qs0 {

    /* renamed from: a */
    public final int f26122a;

    /* renamed from: b */
    public final boolean f26123b;

    public rs0(int i, boolean z) {
        int i2;
        boolean z2 = true;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            i2 = 0;
                        } else {
                            i2 = R.fraction.lb_focus_zoom_factor_xsmall;
                        }
                    } else {
                        i2 = R.fraction.lb_focus_zoom_factor_large;
                    }
                } else {
                    i2 = R.fraction.lb_focus_zoom_factor_medium;
                }
            } else {
                i2 = R.fraction.lb_focus_zoom_factor_small;
            }
            if (i2 <= 0) {
                z2 = false;
            }
        }
        if (z2) {
            this.f26122a = i;
            this.f26123b = z;
            return;
        }
        throw new IllegalArgumentException("Unhandled zoom index");
    }

    @Override // p000.qs0
    /* renamed from: a */
    public final void mo7143a(View view, boolean z) {
        view.setSelected(z);
        m7297c(view).m7401a(z, false);
    }

    @Override // p000.qs0
    /* renamed from: b */
    public final void mo7144b(View view) {
        m7297c(view).m7401a(false, true);
    }

    /* renamed from: c */
    public final ss0 m7297c(View view) {
        int i;
        float fraction;
        int i2 = R.id.lb_focus_animator;
        ss0 ss0Var = (ss0) view.getTag(i2);
        if (ss0Var == null) {
            Resources resources = view.getResources();
            int i3 = this.f26122a;
            if (i3 == 0) {
                fraction = 1.0f;
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                i = 0;
                            } else {
                                i = R.fraction.lb_focus_zoom_factor_xsmall;
                            }
                        } else {
                            i = R.fraction.lb_focus_zoom_factor_large;
                        }
                    } else {
                        i = R.fraction.lb_focus_zoom_factor_medium;
                    }
                } else {
                    i = R.fraction.lb_focus_zoom_factor_small;
                }
                fraction = resources.getFraction(i, 1, 1);
            }
            ss0Var = new ss0(view, fraction, this.f26123b, 150);
            view.setTag(i2, ss0Var);
        }
        return ss0Var;
    }
}
