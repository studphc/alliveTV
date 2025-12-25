package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.TextViewCompat;
import androidx.leanback.widget.GuidedActionAutofillSupport;
import androidx.leanback.widget.ImeKeyMonitor;
import p000.gy0;

/* loaded from: classes.dex */
public class GuidedActionAppCompatEditText extends AppCompatEditText implements ImeKeyMonitor, GuidedActionAutofillSupport {

    /* renamed from: g */
    public ImeKeyMonitor.ImeKeyListener f5778g;

    /* renamed from: h */
    public GuidedActionAutofillSupport.OnAutofillListener f5779h;

    /* renamed from: i */
    public final Drawable f5780i;

    /* renamed from: j */
    public final gy0 f5781j;

    public GuidedActionAppCompatEditText(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void autofill(@Nullable AutofillValue autofillValue) {
        super.autofill(autofillValue);
        GuidedActionAutofillSupport.OnAutofillListener onAutofillListener = this.f5779h;
        if (onAutofillListener != null) {
            onAutofillListener.onAutofill(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    @RequiresApi(26)
    public int getAutofillType() {
        return 1;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            setBackground(this.f5780i);
        } else {
            setBackground(this.f5781j);
        }
        if (!z) {
            setFocusable(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@Nullable AccessibilityNodeInfo accessibilityNodeInfo) {
        Class cls;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (isFocused()) {
            cls = AppCompatEditText.class;
        } else {
            cls = TextView.class;
        }
        accessibilityNodeInfo.setClassName(cls.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, @Nullable KeyEvent keyEvent) {
        boolean z;
        ImeKeyMonitor.ImeKeyListener imeKeyListener = this.f5778g;
        if (imeKeyListener != null) {
            z = imeKeyListener.onKeyPreIme(this, i, keyEvent);
        } else {
            z = false;
        }
        if (!z) {
            return super.onKeyPreIme(i, keyEvent);
        }
        return z;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        if (isInTouchMode() && !isFocusableInTouchMode() && !isTextSelectable()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    @Override // androidx.leanback.widget.ImeKeyMonitor
    public void setImeKeyListener(@Nullable ImeKeyMonitor.ImeKeyListener imeKeyListener) {
        this.f5778g = imeKeyListener;
    }

    @Override // androidx.leanback.widget.GuidedActionAutofillSupport
    public void setOnAutofillListener(@Nullable GuidedActionAutofillSupport.OnAutofillListener onAutofillListener) {
        this.f5779h = onAutofillListener;
    }

    public GuidedActionAppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.editTextStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.graphics.drawable.Drawable, gy0] */
    public GuidedActionAppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5780i = getBackground();
        ?? drawable = new Drawable();
        this.f5781j = drawable;
        setBackground(drawable);
    }
}
