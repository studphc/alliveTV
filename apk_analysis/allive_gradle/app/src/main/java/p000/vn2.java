package p000;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract /* synthetic */ class vn2 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f27894a;

    static {
        int[] iArr = new int[TimeUnit.values().length];
        f27894a = iArr;
        try {
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f27894a[TimeUnit.MICROSECONDS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f27894a[TimeUnit.MILLISECONDS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f27894a[TimeUnit.SECONDS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f27894a[TimeUnit.MINUTES.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f27894a[TimeUnit.HOURS.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f27894a[TimeUnit.DAYS.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
