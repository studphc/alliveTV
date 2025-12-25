package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

/* renamed from: n8 */
/* loaded from: classes.dex */
public final class C1576n8 {

    /* renamed from: a */
    public final CompoundButton f23272a;

    /* renamed from: b */
    public ColorStateList f23273b = null;

    /* renamed from: c */
    public PorterDuff.Mode f23274c = null;

    /* renamed from: d */
    public boolean f23275d = false;

    /* renamed from: e */
    public boolean f23276e = false;

    /* renamed from: f */
    public boolean f23277f;

    public C1576n8(CompoundButton compoundButton) {
        this.f23272a = compoundButton;
    }

    /* renamed from: a */
    public final void m6317a() {
        CompoundButton compoundButton = this.f23272a;
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        if (buttonDrawable != null) {
            if (this.f23275d || this.f23276e) {
                Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.f23275d) {
                    DrawableCompat.setTintList(mutate, this.f23273b);
                }
                if (this.f23276e) {
                    DrawableCompat.setTintMode(mutate, this.f23274c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005a A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:9:0x0052, B:11:0x005a, B:12:0x0061, B:14:0x0069, B:21:0x0039, B:23:0x0041, B:25:0x0047), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:9:0x0052, B:11:0x005a, B:12:0x0061, B:14:0x0069, B:21:0x0039, B:23:0x0041, B:25:0x0047), top: B:2:0x001d }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m6318b(AttributeSet attributeSet, int i) {
        int resourceId;
        int i2;
        int i3;
        int resourceId2;
        CompoundButton compoundButton = this.f23272a;
        Context context = compoundButton.getContext();
        int[] iArr = R.styleable.CompoundButton;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        CompoundButton compoundButton2 = this.f23272a;
        ViewCompat.saveAttributeDataForStyleable(compoundButton2, compoundButton2.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            int i4 = R.styleable.CompoundButton_buttonCompat;
            if (obtainStyledAttributes.hasValue(i4) && (resourceId2 = obtainStyledAttributes.getResourceId(i4, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(AppCompatResources.getDrawable(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                }
                i2 = R.styleable.CompoundButton_buttonTint;
                if (obtainStyledAttributes.hasValue(i2)) {
                    CompoundButtonCompat.setButtonTintList(compoundButton, obtainStyledAttributes.getColorStateList(i2));
                }
                i3 = R.styleable.CompoundButton_buttonTintMode;
                if (obtainStyledAttributes.hasValue(i3)) {
                    CompoundButtonCompat.setButtonTintMode(compoundButton, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i3, -1), null));
                }
            }
            int i5 = R.styleable.CompoundButton_android_button;
            if (obtainStyledAttributes.hasValue(i5) && (resourceId = obtainStyledAttributes.getResourceId(i5, 0)) != 0) {
                compoundButton.setButtonDrawable(AppCompatResources.getDrawable(compoundButton.getContext(), resourceId));
            }
            i2 = R.styleable.CompoundButton_buttonTint;
            if (obtainStyledAttributes.hasValue(i2)) {
            }
            i3 = R.styleable.CompoundButton_buttonTintMode;
            if (obtainStyledAttributes.hasValue(i3)) {
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
