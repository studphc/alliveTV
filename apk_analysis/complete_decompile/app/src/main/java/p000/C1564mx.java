package p000;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;

/* renamed from: mx */
/* loaded from: classes.dex */
public final class C1564mx {

    /* renamed from: e */
    public static Integer f23147e;

    /* renamed from: a */
    public final View f23148a;

    /* renamed from: b */
    public final ArrayList f23149b = new ArrayList();

    /* renamed from: c */
    public boolean f23150c;

    /* renamed from: d */
    public ViewTreeObserverOnPreDrawListenerC1527lx f23151d;

    public C1564mx(View view) {
        this.f23148a = view;
    }

    /* renamed from: a */
    public final int m6261a(int i, int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > 0) {
            return i4;
        }
        boolean z = this.f23150c;
        View view = this.f23148a;
        if (z && view.isLayoutRequested()) {
            return 0;
        }
        int i5 = i - i3;
        if (i5 > 0) {
            return i5;
        }
        if (view.isLayoutRequested() || i2 != -2) {
            return 0;
        }
        if (Log.isLoggable("CustomViewTarget", 4)) {
            Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        Context context = view.getContext();
        if (f23147e == null) {
            Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            f23147e = Integer.valueOf(Math.max(point.x, point.y));
        }
        return f23147e.intValue();
    }
}
