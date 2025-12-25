package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillValue;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.widget.TextViewCompat;
import androidx.leanback.widget.GuidedActionAutofillSupport;
import androidx.leanback.widget.ImeKeyMonitor;
import p000.gy0;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class GuidedActionEditText extends EditText implements ImeKeyMonitor, GuidedActionAutofillSupport {

    /* renamed from: a */
    public ImeKeyMonitor.ImeKeyListener f5783a;

    /* renamed from: b */
    public GuidedActionAutofillSupport.OnAutofillListener f5784b;

    /* renamed from: c */
    public final Drawable f5785c;

    /* renamed from: d */
    public final gy0 f5786d;

    public GuidedActionEditText(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void autofill(AutofillValue autofillValue) {
        super.autofill(autofillValue);
        GuidedActionAutofillSupport.OnAutofillListener onAutofillListener = this.f5784b;
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
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            setBackground(this.f5785c);
        } else {
            setBackground(this.f5786d);
        }
        if (!z) {
            setFocusable(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Class cls;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (isFocused()) {
            cls = EditText.class;
        } else {
            cls = TextView.class;
        }
        accessibilityNodeInfo.setClassName(cls.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        boolean z;
        ImeKeyMonitor.ImeKeyListener imeKeyListener = this.f5783a;
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
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (isInTouchMode() && !isFocusableInTouchMode() && !isTextSelectable()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    @Override // androidx.leanback.widget.ImeKeyMonitor
    public void setImeKeyListener(ImeKeyMonitor.ImeKeyListener imeKeyListener) {
        this.f5783a = imeKeyListener;
    }

    @Override // androidx.leanback.widget.GuidedActionAutofillSupport
    public void setOnAutofillListener(GuidedActionAutofillSupport.OnAutofillListener onAutofillListener) {
        this.f5784b = onAutofillListener;
    }

    public GuidedActionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.editTextStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.graphics.drawable.Drawable, gy0] */
    public GuidedActionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5785c = getBackground();
        ?? drawable = new Drawable();
        this.f5786d = drawable;
        setBackground(drawable);
    }
}
