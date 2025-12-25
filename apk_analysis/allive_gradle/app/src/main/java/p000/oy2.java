package p000;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public abstract /* synthetic */ class oy2 {
    /* renamed from: a */
    public static int m6748a(String str) {
        str.getClass();
        if (!str.equals(TypedValues.MotionScene.S_DEFAULT_DURATION)) {
            if (!str.equals(TypedValues.MotionScene.S_LAYOUT_DURING_TRANSITION)) {
                return -1;
            }
            return 601;
        }
        return 600;
    }

    /* renamed from: b */
    public static int m6749b(int i) {
        if (i != 600) {
            if (i != 601) {
                return -1;
            }
            return 1;
        }
        return 2;
    }
}
