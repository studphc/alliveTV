package androidx.core.view;

import android.graphics.Point;
import android.view.Display;

/* renamed from: androidx.core.view.a */
/* loaded from: classes.dex */
public abstract class AbstractC0199a {
    /* renamed from: a */
    public static boolean m920a(Display.Mode mode, Point point) {
        if ((mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x)) {
            return true;
        }
        return false;
    }
}
