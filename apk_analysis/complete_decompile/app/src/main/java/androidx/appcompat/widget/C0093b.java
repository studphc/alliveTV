package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import p000.C1341j4;

/* renamed from: androidx.appcompat.widget.b */
/* loaded from: classes.dex */
public final class C0093b extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {

    /* renamed from: d */
    public final /* synthetic */ C0095d f1596d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0093b(C0095d c0095d, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f1596d = c0095d;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        TooltipCompat.setTooltipText(this, getContentDescription());
        setOnTouchListener(new C1341j4(this, this, 0));
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public final boolean needsDividerAfter() {
        return false;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public final boolean needsDividerBefore() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f1596d.m316l();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            DrawableCompat.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
        }
        return frame;
    }
}
