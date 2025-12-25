package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
class CheckableImageView extends ImageView implements Checkable {

    /* renamed from: b */
    public static final int[] f5598b = {android.R.attr.state_checked};

    /* renamed from: a */
    public boolean f5599a;

    public CheckableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f5599a;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f5599a) {
            View.mergeDrawableStates(onCreateDrawableState, f5598b);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z) {
        if (this.f5599a != z) {
            this.f5599a = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f5599a);
    }

    public CheckableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
