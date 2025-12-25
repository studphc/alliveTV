package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.Presenter;
import p000.ViewOnClickListenerC1109d4;
import p000.a52;

/* renamed from: androidx.leanback.widget.a2 */
/* loaded from: classes.dex */
public final class C0314a2 extends C0376q {

    /* renamed from: i */
    public static int f6265i;

    /* renamed from: j */
    public static int f6266j;

    /* renamed from: h */
    public boolean f6267h;

    /* renamed from: a */
    public static void m1491a(C0413z1 c0413z1, boolean z) {
        int i;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) c0413z1.f6451o.getLayoutParams();
        int i2 = 0;
        if (z) {
            i = c0413z1.f6458v;
        } else {
            i = 0;
        }
        marginLayoutParams.setMarginStart(i);
        c0413z1.f6451o.setLayoutParams(marginLayoutParams);
        TextView textView = c0413z1.f6452p;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        if (z) {
            i2 = c0413z1.f6459w;
        }
        marginLayoutParams2.setMarginEnd(i2);
        textView.setLayoutParams(marginLayoutParams2);
    }

    /* renamed from: b */
    public static void m1492b(long j, StringBuilder sb) {
        long j2 = j / 60;
        long j3 = j2 / 60;
        long j4 = j - (j2 * 60);
        long j5 = j2 - (60 * j3);
        sb.setLength(0);
        if (j3 > 0) {
            sb.append(j3);
            sb.append(':');
            if (j5 < 10) {
                sb.append('0');
            }
        }
        sb.append(j5);
        sb.append(':');
        if (j4 < 10) {
            sb.append('0');
        }
        sb.append(j4);
    }

    /* renamed from: c */
    public static void m1493c(C0413z1 c0413z1, long j) {
        long j2 = j / 1000;
        if (j != c0413z1.f6454r) {
            c0413z1.f6454r = j;
            StringBuilder sb = c0413z1.f6457u;
            m1492b(j2, sb);
            c0413z1.f6451o.setText(sb.toString());
        }
        c0413z1.f6453q.setProgress((int) ((c0413z1.f6454r / c0413z1.f6455s) * 2.147483647E9d));
    }

    /* renamed from: d */
    public static void m1494d(C0413z1 c0413z1, long j) {
        ProgressBar progressBar = c0413z1.f6453q;
        TextView textView = c0413z1.f6452p;
        if (j <= 0) {
            textView.setVisibility(8);
            progressBar.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        progressBar.setVisibility(0);
        c0413z1.f6455s = j;
        StringBuilder sb = c0413z1.f6456t;
        m1492b(j / 1000, sb);
        textView.setText(sb.toString());
        progressBar.setMax(Integer.MAX_VALUE);
    }

    @Override // androidx.leanback.widget.C0376q, androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        C0413z1 c0413z1 = (C0413z1) viewHolder;
        ObjectAdapter objectAdapter = c0413z1.f6446j;
        ObjectAdapter objectAdapter2 = ((a52) obj).f45c;
        if (objectAdapter != objectAdapter2) {
            c0413z1.f6446j = objectAdapter2;
            objectAdapter2.registerObserver(c0413z1.f6447k);
            c0413z1.f6450n = false;
        }
        super.onBindViewHolder(viewHolder, obj);
        boolean z = this.f6267h;
        FrameLayout frameLayout = c0413z1.f6448l;
        if (z) {
            if (c0413z1.f6449m == null) {
                PlaybackControlsRow.MoreActions moreActions = new PlaybackControlsRow.MoreActions(frameLayout.getContext());
                Presenter.ViewHolder onCreateViewHolder = c0413z1.f6337d.onCreateViewHolder(frameLayout);
                c0413z1.f6449m = onCreateViewHolder;
                c0413z1.f6337d.onBindViewHolder(onCreateViewHolder, moreActions);
                c0413z1.f6337d.setOnClickListener(c0413z1.f6449m, new ViewOnClickListenerC1109d4(6, c0413z1));
            }
            if (c0413z1.f6449m.view.getParent() == null) {
                frameLayout.addView(c0413z1.f6449m.view);
                return;
            }
            return;
        }
        Presenter.ViewHolder viewHolder2 = c0413z1.f6449m;
        if (viewHolder2 != null && viewHolder2.view.getParent() != null) {
            frameLayout.removeView(c0413z1.f6449m.view);
        }
    }

    @Override // androidx.leanback.widget.C0376q, androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new C0413z1(this, LayoutInflater.from(viewGroup.getContext()).inflate(this.f6396d, viewGroup, false));
    }

    @Override // androidx.leanback.widget.C0376q, androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        super.onUnbindViewHolder(viewHolder);
        C0413z1 c0413z1 = (C0413z1) viewHolder;
        ObjectAdapter objectAdapter = c0413z1.f6446j;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(c0413z1.f6447k);
            c0413z1.f6446j = null;
        }
    }
}
