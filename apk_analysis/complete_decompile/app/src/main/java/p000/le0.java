package p000;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.leanback.graphics.FitWidthBitmapDrawable;

/* loaded from: classes.dex */
public final class le0 extends Drawable.ConstantState {

    /* renamed from: a */
    public final Paint f22476a;

    /* renamed from: b */
    public Bitmap f22477b;

    /* renamed from: c */
    public Rect f22478c;

    /* renamed from: d */
    public final Rect f22479d;

    /* renamed from: e */
    public int f22480e;

    public le0() {
        this.f22479d = new Rect();
        this.f22476a = new Paint();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new FitWidthBitmapDrawable(this);
    }

    public le0(le0 le0Var) {
        Rect rect = new Rect();
        this.f22479d = rect;
        this.f22477b = le0Var.f22477b;
        this.f22476a = new Paint(le0Var.f22476a);
        this.f22478c = le0Var.f22478c != null ? new Rect(le0Var.f22478c) : null;
        rect.set(le0Var.f22479d);
        this.f22480e = le0Var.f22480e;
    }
}
