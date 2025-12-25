package p000;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class y33 {

    /* renamed from: e */
    public static Integer f28824e;

    /* renamed from: a */
    public final View f28825a;

    /* renamed from: b */
    public final ArrayList f28826b = new ArrayList();

    /* renamed from: c */
    public boolean f28827c;

    /* renamed from: d */
    public ViewTreeObserverOnPreDrawListenerC1527lx f28828d;

    public y33(View view) {
        this.f28825a = view;
    }

    /* renamed from: a */
    public final int m8216a(int i, int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > 0) {
            return i4;
        }
        boolean z = this.f28827c;
        View view = this.f28825a;
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
        if (Log.isLoggable("ViewTarget", 4)) {
            Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        Context context = view.getContext();
        if (f28824e == null) {
            Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            f28824e = Integer.valueOf(Math.max(point.x, point.y));
        }
        return f28824e.intValue();
    }
}
