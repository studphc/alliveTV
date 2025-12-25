package androidx.leanback.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.z1 */
/* loaded from: classes.dex */
public final class C0413z1 extends C0372p {

    /* renamed from: j */
    public ObjectAdapter f6446j;

    /* renamed from: k */
    public final C0409y1 f6447k;

    /* renamed from: l */
    public final FrameLayout f6448l;

    /* renamed from: m */
    public Presenter.ViewHolder f6449m;

    /* renamed from: n */
    public boolean f6450n;

    /* renamed from: o */
    public final TextView f6451o;

    /* renamed from: p */
    public final TextView f6452p;

    /* renamed from: q */
    public final ProgressBar f6453q;

    /* renamed from: r */
    public long f6454r;

    /* renamed from: s */
    public long f6455s;

    /* renamed from: t */
    public final StringBuilder f6456t;

    /* renamed from: u */
    public final StringBuilder f6457u;

    /* renamed from: v */
    public final int f6458v;

    /* renamed from: w */
    public final int f6459w;

    /* renamed from: x */
    public final /* synthetic */ C0314a2 f6460x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0413z1(C0314a2 c0314a2, View view) {
        super(c0314a2, view);
        this.f6460x = c0314a2;
        this.f6454r = -1L;
        this.f6455s = -1L;
        this.f6456t = new StringBuilder();
        this.f6457u = new StringBuilder();
        this.f6448l = (FrameLayout) view.findViewById(androidx.leanback.R.id.more_actions_dock);
        TextView textView = (TextView) view.findViewById(androidx.leanback.R.id.current_time);
        this.f6451o = textView;
        TextView textView2 = (TextView) view.findViewById(androidx.leanback.R.id.total_time);
        this.f6452p = textView2;
        this.f6453q = (ProgressBar) view.findViewById(androidx.leanback.R.id.playback_progress);
        this.f6447k = new C0409y1(this);
        this.f6458v = ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).getMarginStart();
        this.f6459w = ((ViewGroup.MarginLayoutParams) textView2.getLayoutParams()).getMarginEnd();
    }

    @Override // androidx.leanback.widget.C0372p
    /* renamed from: b */
    public final int mo1501b(int i, Context context) {
        int i2;
        this.f6460x.getClass();
        if (C0376q.f6393g == 0) {
            C0376q.f6393g = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_control_icon_width);
        }
        int i3 = C0376q.f6393g;
        if (i < 4) {
            if (C0314a2.f6266j == 0) {
                C0314a2.f6266j = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_controls_child_margin_biggest);
            }
            i2 = C0314a2.f6266j;
        } else if (i < 6) {
            if (C0314a2.f6265i == 0) {
                C0314a2.f6265i = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_controls_child_margin_bigger);
            }
            i2 = C0314a2.f6265i;
        } else {
            if (C0376q.f6392f == 0) {
                C0376q.f6392f = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_controls_child_margin_default);
            }
            return i3 + C0376q.f6392f;
        }
        return i3 + i2;
    }

    @Override // androidx.leanback.widget.C0372p
    /* renamed from: c */
    public final ObjectAdapter mo1502c() {
        if (this.f6450n) {
            return this.f6446j;
        }
        return this.f6335b;
    }
}
