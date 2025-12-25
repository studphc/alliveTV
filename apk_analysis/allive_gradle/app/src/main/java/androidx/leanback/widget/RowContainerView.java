package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
final class RowContainerView extends LinearLayout {

    /* renamed from: a */
    public final ViewGroup f6096a;

    /* renamed from: b */
    public Drawable f6097b;

    /* renamed from: c */
    public boolean f6098c;

    public RowContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6098c = true;
        setOrientation(1);
        LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_row_container, this);
        this.f6096a = (ViewGroup) findViewById(androidx.leanback.R.id.lb_row_container_header_dock);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f6097b;
        if (drawable != null) {
            if (this.f6098c) {
                this.f6098c = false;
                drawable.setBounds(0, 0, getWidth(), getHeight());
            }
            this.f6097b.draw(canvas);
        }
    }

    @Override // android.view.View
    public final Drawable getForeground() {
        return this.f6097b;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f6098c = true;
    }

    @Override // android.view.View
    public final void setForeground(Drawable drawable) {
        boolean z;
        this.f6097b = drawable;
        if (drawable == null) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }
}
