package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
class ResizingTextView extends TextView {

    /* renamed from: a */
    public final int f6083a;

    /* renamed from: b */
    public final int f6084b;

    /* renamed from: c */
    public final boolean f6085c;

    /* renamed from: d */
    public final int f6086d;

    /* renamed from: e */
    public final int f6087e;

    /* renamed from: f */
    public boolean f6088f;

    /* renamed from: g */
    public int f6089g;

    /* renamed from: h */
    public float f6090h;

    /* renamed from: i */
    public int f6091i;

    /* renamed from: j */
    public int f6092j;

    public ResizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6088f = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.lbResizingTextView, i, 0);
        try {
            this.f6083a = obtainStyledAttributes.getInt(androidx.leanback.R.styleable.lbResizingTextView_resizeTrigger, 1);
            this.f6084b = obtainStyledAttributes.getDimensionPixelSize(androidx.leanback.R.styleable.lbResizingTextView_resizedTextSize, -1);
            this.f6085c = obtainStyledAttributes.getBoolean(androidx.leanback.R.styleable.lbResizingTextView_maintainLineSpacing, false);
            this.f6086d = obtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.lbResizingTextView_resizedPaddingAdjustmentTop, 0);
            this.f6087e = obtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.lbResizingTextView_resizedPaddingAdjustmentBottom, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    public final void m1478a(int i, int i2) {
        if (isPaddingRelative()) {
            setPaddingRelative(getPaddingStart(), i, getPaddingEnd(), i2);
        } else {
            setPadding(getPaddingLeft(), i, getPaddingRight(), i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        boolean z2 = true;
        if (!this.f6088f) {
            this.f6089g = (int) getTextSize();
            this.f6090h = getLineSpacingExtra();
            this.f6091i = getPaddingTop();
            this.f6092j = getPaddingBottom();
            this.f6088f = true;
        }
        boolean z3 = false;
        setTextSize(0, this.f6089g);
        setLineSpacing(this.f6090h, getLineSpacingMultiplier());
        m1478a(this.f6091i, this.f6092j);
        super.onMeasure(i, i2);
        Layout layout = getLayout();
        if (layout != null && (this.f6083a & 1) > 0) {
            int lineCount = layout.getLineCount();
            int maxLines = getMaxLines();
            if (maxLines > 1 && lineCount == maxLines) {
                z = true;
                int textSize = (int) getTextSize();
                boolean z4 = this.f6085c;
                int i4 = this.f6084b;
                if (!z) {
                    if (i4 != -1 && textSize != i4) {
                        setTextSize(0, i4);
                        z3 = true;
                    }
                    float f = (this.f6090h + this.f6089g) - i4;
                    if (z4 && getLineSpacingExtra() != f) {
                        setLineSpacing(f, getLineSpacingMultiplier());
                        z3 = true;
                    }
                    int i5 = this.f6091i + this.f6086d;
                    int i6 = this.f6092j + this.f6087e;
                    if (getPaddingTop() != i5 || getPaddingBottom() != i6) {
                        m1478a(i5, i6);
                    }
                    z2 = z3;
                } else {
                    if (i4 != -1 && textSize != (i3 = this.f6089g)) {
                        setTextSize(0, i3);
                        z3 = true;
                    }
                    if (z4) {
                        float lineSpacingExtra = getLineSpacingExtra();
                        float f2 = this.f6090h;
                        if (lineSpacingExtra != f2) {
                            setLineSpacing(f2, getLineSpacingMultiplier());
                            z3 = true;
                        }
                    }
                    if (getPaddingTop() != this.f6091i || getPaddingBottom() != this.f6092j) {
                        m1478a(this.f6091i, this.f6092j);
                    }
                    z2 = z3;
                }
                if (!z2) {
                    super.onMeasure(i, i2);
                    return;
                }
                return;
            }
        }
        z = false;
        int textSize2 = (int) getTextSize();
        boolean z42 = this.f6085c;
        int i42 = this.f6084b;
        if (!z) {
        }
        if (!z2) {
        }
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public ResizingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }
}
