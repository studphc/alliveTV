package p000;

import android.graphics.RectF;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class j71 extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;

    /* renamed from: e */
    public int f20396e;

    public abstract boolean intersects(int i, int i2, RectF rectF, RectF rectF2, float f, float f2);

    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr);

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void getAttributeNames(HashSet hashSet) {
    }
}
