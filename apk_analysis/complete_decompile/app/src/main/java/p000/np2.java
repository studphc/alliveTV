package p000;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.google.android.exoplayer2.p003ui.C0731m;
import com.google.android.exoplayer2.p003ui.StyledPlayerControlView;

/* loaded from: classes.dex */
public final /* synthetic */ class np2 implements View.OnLayoutChangeListener {

    /* renamed from: a */
    public final /* synthetic */ int f23450a;

    /* renamed from: b */
    public final /* synthetic */ Object f23451b;

    public /* synthetic */ np2(int i, Object obj) {
        this.f23450a = i;
        this.f23451b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int height;
        int i10;
        int height2;
        boolean z;
        boolean z2 = true;
        Object obj = this.f23451b;
        switch (this.f23450a) {
            case 0:
                int i11 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
                StyledPlayerControlView styledPlayerControlView = (StyledPlayerControlView) obj;
                styledPlayerControlView.getClass();
                int i12 = i4 - i2;
                int i13 = i8 - i6;
                if (i3 - i != i7 - i5 || i12 != i13) {
                    PopupWindow popupWindow = styledPlayerControlView.f12227m0;
                    if (popupWindow.isShowing()) {
                        styledPlayerControlView.m2937l();
                        int width = styledPlayerControlView.getWidth() - popupWindow.getWidth();
                        int i14 = styledPlayerControlView.f12231o0;
                        popupWindow.update(view, width - i14, (-popupWindow.getHeight()) - i14, -1, -1);
                        return;
                    }
                    return;
                }
                return;
            default:
                C0731m c0731m = (C0731m) obj;
                StyledPlayerControlView styledPlayerControlView2 = c0731m.f12356a;
                int width2 = (styledPlayerControlView2.getWidth() - styledPlayerControlView2.getPaddingLeft()) - styledPlayerControlView2.getPaddingRight();
                int height3 = (styledPlayerControlView2.getHeight() - styledPlayerControlView2.getPaddingBottom()) - styledPlayerControlView2.getPaddingTop();
                ViewGroup viewGroup = c0731m.f12358c;
                int m2964c = C0731m.m2964c(viewGroup);
                if (viewGroup != null) {
                    i9 = viewGroup.getPaddingRight() + viewGroup.getPaddingLeft();
                } else {
                    i9 = 0;
                }
                int i15 = m2964c - i9;
                if (viewGroup == null) {
                    height = 0;
                } else {
                    height = viewGroup.getHeight();
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        height += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    }
                }
                if (viewGroup != null) {
                    i10 = viewGroup.getPaddingBottom() + viewGroup.getPaddingTop();
                } else {
                    i10 = 0;
                }
                int i16 = height - i10;
                int max = Math.max(i15, C0731m.m2964c(c0731m.f12366k) + C0731m.m2964c(c0731m.f12364i));
                ViewGroup viewGroup2 = c0731m.f12359d;
                if (viewGroup2 == null) {
                    height2 = 0;
                } else {
                    height2 = viewGroup2.getHeight();
                    ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        height2 += marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                    }
                }
                int i17 = (height2 * 2) + i16;
                if (width2 > max && height3 > i17) {
                    z = false;
                } else {
                    z = true;
                }
                if (c0731m.f12353A != z) {
                    c0731m.f12353A = z;
                    view.post(new rp2(c0731m, 1));
                }
                if (i3 - i == i7 - i5) {
                    z2 = false;
                }
                if (!c0731m.f12353A && z2) {
                    view.post(new rp2(c0731m, 2));
                    return;
                }
                return;
        }
    }
}
