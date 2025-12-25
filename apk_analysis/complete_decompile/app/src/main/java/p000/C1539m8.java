package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CheckedTextViewCompat;

/* renamed from: m8 */
/* loaded from: classes.dex */
public final class C1539m8 {

    /* renamed from: a */
    public final AppCompatCheckedTextView f22839a;

    /* renamed from: b */
    public ColorStateList f22840b = null;

    /* renamed from: c */
    public PorterDuff.Mode f22841c = null;

    /* renamed from: d */
    public boolean f22842d = false;

    /* renamed from: e */
    public boolean f22843e = false;

    /* renamed from: f */
    public boolean f22844f;

    public C1539m8(AppCompatCheckedTextView appCompatCheckedTextView) {
        this.f22839a = appCompatCheckedTextView;
    }

    /* renamed from: a */
    public final void m6090a() {
        AppCompatCheckedTextView appCompatCheckedTextView = this.f22839a;
        Drawable checkMarkDrawable = CheckedTextViewCompat.getCheckMarkDrawable(appCompatCheckedTextView);
        if (checkMarkDrawable != null) {
            if (this.f22842d || this.f22843e) {
                Drawable mutate = DrawableCompat.wrap(checkMarkDrawable).mutate();
                if (this.f22842d) {
                    DrawableCompat.setTintList(mutate, this.f22840b);
                }
                if (this.f22843e) {
                    DrawableCompat.setTintMode(mutate, this.f22841c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(appCompatCheckedTextView.getDrawableState());
                }
                appCompatCheckedTextView.setCheckMarkDrawable(mutate);
            }
        }
    }
}
