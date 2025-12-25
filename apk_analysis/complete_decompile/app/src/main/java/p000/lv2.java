package p000;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes.dex */
public final class lv2 implements mv2 {

    /* renamed from: a */
    public final /* synthetic */ float f22679a;

    /* renamed from: b */
    public final /* synthetic */ float f22680b;

    /* renamed from: c */
    public final /* synthetic */ float f22681c;

    /* renamed from: d */
    public final /* synthetic */ float f22682d;

    public lv2(float f, float f2, float f3, float f4) {
        this.f22679a = f;
        this.f22680b = f2;
        this.f22681c = f3;
        this.f22682d = f4;
    }

    @Override // p000.mv2
    /* renamed from: b */
    public final void mo5987b(Canvas canvas, Paint paint, RectF rectF) {
        Path path = new Path();
        float f = this.f22679a;
        float f2 = this.f22680b;
        float f3 = this.f22681c;
        float f4 = this.f22682d;
        path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }
}
