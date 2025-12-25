package p000;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.p003ui.C0731m;
import com.google.android.exoplayer2.p003ui.DefaultTimeBar;
import com.google.android.exoplayer2.p003ui.R;
import com.google.android.exoplayer2.p003ui.StyledPlayerControlView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class rp2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f26095a;

    /* renamed from: b */
    public final /* synthetic */ C0731m f26096b;

    public /* synthetic */ rp2(C0731m c0731m, int i) {
        this.f26095a = i;
        this.f26096b = c0731m;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int i;
        int i2;
        ViewGroup viewGroup;
        switch (this.f26095a) {
            case 0:
                this.f26096b.m2974k();
                return;
            case 1:
                C0731m c0731m = this.f26096b;
                ViewGroup viewGroup2 = c0731m.f12360e;
                if (viewGroup2 != null) {
                    if (c0731m.f12353A) {
                        i2 = 0;
                    } else {
                        i2 = 4;
                    }
                    viewGroup2.setVisibility(i2);
                }
                View view = c0731m.f12365j;
                if (view != null) {
                    int dimensionPixelSize = c0731m.f12356a.getResources().getDimensionPixelSize(R.dimen.exo_styled_progress_margin_bottom);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    if (marginLayoutParams != null) {
                        if (c0731m.f12353A) {
                            dimensionPixelSize = 0;
                        }
                        marginLayoutParams.bottomMargin = dimensionPixelSize;
                        view.setLayoutParams(marginLayoutParams);
                    }
                    if (view instanceof DefaultTimeBar) {
                        DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                        if (c0731m.f12353A) {
                            defaultTimeBar.hideScrubber(true);
                        } else {
                            int i3 = c0731m.f12381z;
                            if (i3 == 1) {
                                defaultTimeBar.hideScrubber(false);
                            } else if (i3 != 3) {
                                defaultTimeBar.showScrubber();
                            }
                        }
                    }
                }
                Iterator it = c0731m.f12380y.iterator();
                while (it.hasNext()) {
                    View view2 = (View) it.next();
                    if (c0731m.f12353A && C0731m.m2966j(view2)) {
                        i = 4;
                    } else {
                        i = 0;
                    }
                    view2.setVisibility(i);
                }
                return;
            case 2:
                C0731m c0731m2 = this.f26096b;
                ViewGroup viewGroup3 = c0731m2.f12361f;
                if (viewGroup3 != null && (viewGroup = c0731m2.f12362g) != null) {
                    StyledPlayerControlView styledPlayerControlView = c0731m2.f12356a;
                    int width = (styledPlayerControlView.getWidth() - styledPlayerControlView.getPaddingLeft()) - styledPlayerControlView.getPaddingRight();
                    while (true) {
                        if (viewGroup.getChildCount() > 1) {
                            int childCount = viewGroup.getChildCount() - 2;
                            View childAt = viewGroup.getChildAt(childCount);
                            viewGroup.removeViewAt(childCount);
                            viewGroup3.addView(childAt, 0);
                        } else {
                            View view3 = c0731m2.f12366k;
                            if (view3 != null) {
                                view3.setVisibility(8);
                            }
                            int m2964c = C0731m.m2964c(c0731m2.f12364i);
                            int childCount2 = viewGroup3.getChildCount() - 1;
                            for (int i4 = 0; i4 < childCount2; i4++) {
                                m2964c += C0731m.m2964c(viewGroup3.getChildAt(i4));
                            }
                            if (m2964c > width) {
                                if (view3 != null) {
                                    view3.setVisibility(0);
                                    m2964c += C0731m.m2964c(view3);
                                }
                                ArrayList arrayList = new ArrayList();
                                for (int i5 = 0; i5 < childCount2; i5++) {
                                    View childAt2 = viewGroup3.getChildAt(i5);
                                    m2964c -= C0731m.m2964c(childAt2);
                                    arrayList.add(childAt2);
                                    if (m2964c <= width) {
                                        if (arrayList.isEmpty()) {
                                            viewGroup3.removeViews(0, arrayList.size());
                                            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                                                viewGroup.addView((View) arrayList.get(i6), viewGroup.getChildCount() - 1);
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (arrayList.isEmpty()) {
                                }
                            } else {
                                ViewGroup viewGroup4 = c0731m2.f12363h;
                                if (viewGroup4 != null && viewGroup4.getVisibility() == 0) {
                                    ValueAnimator valueAnimator = c0731m2.f12373r;
                                    if (!valueAnimator.isStarted()) {
                                        c0731m2.f12372q.cancel();
                                        valueAnimator.start();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    }
                } else {
                    return;
                }
                break;
            case 3:
                this.f26096b.f12369n.start();
                return;
            case 4:
                this.f26096b.f12368m.start();
                return;
            case 5:
                C0731m c0731m3 = this.f26096b;
                c0731m3.f12367l.start();
                c0731m3.m2969e(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, c0731m3.f12376u);
                return;
            default:
                this.f26096b.m2973i(2);
                return;
        }
    }
}
