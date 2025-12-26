package p000;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

/* loaded from: classes.dex */
public final class m13 extends Drawable.ConstantState {

    /* renamed from: a */
    public int f22757a;

    /* renamed from: b */
    public l13 f22758b;

    /* renamed from: c */
    public ColorStateList f22759c;

    /* renamed from: d */
    public PorterDuff.Mode f22760d;

    /* renamed from: e */
    public boolean f22761e;

    /* renamed from: f */
    public Bitmap f22762f;

    /* renamed from: g */
    public ColorStateList f22763g;

    /* renamed from: h */
    public PorterDuff.Mode f22764h;

    /* renamed from: i */
    public int f22765i;

    /* renamed from: j */
    public boolean f22766j;

    /* renamed from: k */
    public boolean f22767k;

    /* renamed from: l */
    public Paint f22768l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f22757a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new VectorDrawableCompat(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new VectorDrawableCompat(this);
    }
}
