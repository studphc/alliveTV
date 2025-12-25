package p000;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.ViewUtils;

/* renamed from: v9 */
/* loaded from: classes.dex */
public final class C1901v9 extends ListPopupWindow implements InterfaceC1938w9 {

    /* renamed from: J */
    public CharSequence f27671J;

    /* renamed from: K */
    public ListAdapter f27672K;

    /* renamed from: L */
    public final Rect f27673L;

    /* renamed from: M */
    public int f27674M;

    /* renamed from: N */
    public final /* synthetic */ AppCompatSpinner f27675N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1901v9(AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27675N = appCompatSpinner;
        this.f27673L = new Rect();
        setAnchorView(appCompatSpinner);
        setModal(true);
        setPromptPosition(0);
        setOnItemClickListener(new C1827t9(0, this));
    }

    @Override // p000.InterfaceC1938w9
    /* renamed from: a */
    public final CharSequence mo7230a() {
        return this.f27671J;
    }

    @Override // p000.InterfaceC1938w9
    /* renamed from: b */
    public final void mo7231b(CharSequence charSequence) {
        this.f27671J = charSequence;
    }

    @Override // p000.InterfaceC1938w9
    /* renamed from: c */
    public final void mo7232c(int i) {
        this.f27674M = i;
    }

    @Override // p000.InterfaceC1938w9
    /* renamed from: d */
    public final void mo7233d(int i, int i2) {
        ViewTreeObserver viewTreeObserver;
        boolean isShowing = isShowing();
        m7824g();
        setInputMethodMode(2);
        super.show();
        ListView listView = getListView();
        listView.setChoiceMode(1);
        listView.setTextDirection(i);
        listView.setTextAlignment(i2);
        AppCompatSpinner appCompatSpinner = this.f27675N;
        setSelection(appCompatSpinner.getSelectedItemPosition());
        if (!isShowing && (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) != null) {
            ViewTreeObserverOnGlobalLayoutListenerC1933w4 viewTreeObserverOnGlobalLayoutListenerC1933w4 = new ViewTreeObserverOnGlobalLayoutListenerC1933w4(2, this);
            viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC1933w4);
            setOnDismissListener(new C1864u9(this, viewTreeObserverOnGlobalLayoutListenerC1933w4));
        }
    }

    /* renamed from: g */
    public final void m7824g() {
        int i;
        int i2;
        Drawable background = getBackground();
        AppCompatSpinner appCompatSpinner = this.f27675N;
        if (background != null) {
            background.getPadding(appCompatSpinner.f1210h);
            if (ViewUtils.isLayoutRtl(appCompatSpinner)) {
                i = appCompatSpinner.f1210h.right;
            } else {
                i = -appCompatSpinner.f1210h.left;
            }
        } else {
            Rect rect = appCompatSpinner.f1210h;
            rect.right = 0;
            rect.left = 0;
            i = 0;
        }
        int paddingLeft = appCompatSpinner.getPaddingLeft();
        int paddingRight = appCompatSpinner.getPaddingRight();
        int width = appCompatSpinner.getWidth();
        int i3 = appCompatSpinner.f1209g;
        if (i3 == -2) {
            int m242a = appCompatSpinner.m242a((SpinnerAdapter) this.f27672K, getBackground());
            int i4 = appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = appCompatSpinner.f1210h;
            int i5 = (i4 - rect2.left) - rect2.right;
            if (m242a > i5) {
                m242a = i5;
            }
            setContentWidth(Math.max(m242a, (width - paddingLeft) - paddingRight));
        } else if (i3 == -1) {
            setContentWidth((width - paddingLeft) - paddingRight);
        } else {
            setContentWidth(i3);
        }
        if (ViewUtils.isLayoutRtl(appCompatSpinner)) {
            i2 = (((width - paddingRight) - getWidth()) - this.f27674M) + i;
        } else {
            i2 = paddingLeft + this.f27674M + i;
        }
        setHorizontalOffset(i2);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow, p000.InterfaceC1938w9
    public final void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.f27672K = listAdapter;
    }
}
