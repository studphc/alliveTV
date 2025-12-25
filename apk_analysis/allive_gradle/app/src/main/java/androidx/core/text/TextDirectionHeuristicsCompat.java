package androidx.core.text;

import p000.dx0;
import p000.ts2;
import p000.us2;
import p000.wd0;

/* loaded from: classes.dex */
public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE;
    public static final TextDirectionHeuristicCompat LTR = new ts2(null, false);
    public static final TextDirectionHeuristicCompat RTL = new ts2(null, true);

    static {
        dx0 dx0Var = dx0.f16576e;
        FIRSTSTRONG_LTR = new ts2(dx0Var, false);
        FIRSTSTRONG_RTL = new ts2(dx0Var, true);
        ANYRTL_LTR = new ts2(wd0.f28144e, false);
        LOCALE = us2.f27430b;
    }
}
