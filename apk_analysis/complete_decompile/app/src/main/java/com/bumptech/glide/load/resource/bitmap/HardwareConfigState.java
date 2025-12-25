package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import android.util.Log;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class HardwareConfigState {
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED;
    public static final boolean HARDWARE_BITMAPS_SUPPORTED;
    public static final int NO_MAX_FD_COUNT = -1;

    /* renamed from: g */
    public static final File f8885g;

    /* renamed from: h */
    public static volatile HardwareConfigState f8886h;

    /* renamed from: i */
    public static volatile int f8887i;

    /* renamed from: a */
    public final boolean f8888a;

    /* renamed from: b */
    public final int f8889b;

    /* renamed from: c */
    public final int f8890c;

    /* renamed from: d */
    public int f8891d;

    /* renamed from: e */
    public boolean f8892e = true;

    /* renamed from: f */
    public final AtomicBoolean f8893f = new AtomicBoolean(false);

    static {
        boolean z;
        int i = Build.VERSION.SDK_INT;
        boolean z2 = false;
        if (i < 29) {
            z = true;
        } else {
            z = false;
        }
        BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = z;
        if (i >= 26) {
            z2 = true;
        }
        HARDWARE_BITMAPS_SUPPORTED = z2;
        f8885g = new File("/proc/self/fd");
        f8887i = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x009e, code lost:
    
        r26.f8888a = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00a4, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 28) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00a6, code lost:
    
        r26.f8889b = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        r26.f8890c = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ad, code lost:
    
        r26.f8889b = androidx.constraintlayout.core.motion.utils.TypedValues.TransitionType.TYPE_DURATION;
        r26.f8890c = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
    
        if (r2 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x009d, code lost:
    
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HardwareConfigState() {
        boolean contains;
        boolean z = true;
        if (Build.VERSION.SDK_INT == 26) {
            Iterator it = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
            while (it.hasNext()) {
                if (Build.MODEL.startsWith((String) it.next())) {
                    break;
                }
            }
        }
        if (Build.VERSION.SDK_INT != 27) {
            contains = false;
        } else {
            contains = Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
        }
    }

    public static HardwareConfigState getInstance() {
        if (f8886h == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (f8886h == null) {
                        f8886h = new HardwareConfigState();
                    }
                } finally {
                }
            }
        }
        return f8886h;
    }

    public boolean areHardwareBitmapsBlocked() {
        Util.assertMainThread();
        return !this.f8893f.get();
    }

    public void blockHardwareBitmaps() {
        Util.assertMainThread();
        this.f8893f.set(false);
    }

    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        int i3;
        boolean z4;
        if (!z) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!this.f8888a) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        }
        if (!HARDWARE_BITMAPS_SUPPORTED) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED && !this.f8893f.get()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z2) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        int i4 = this.f8890c;
        if (i < i4) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
            }
            return false;
        }
        if (i2 < i4) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
            }
            return false;
        }
        synchronized (this) {
            try {
                int i5 = this.f8891d + 1;
                this.f8891d = i5;
                if (i5 >= 50) {
                    this.f8891d = 0;
                    int length = f8885g.list().length;
                    if (f8887i != -1) {
                        i3 = f8887i;
                    } else {
                        i3 = this.f8889b;
                    }
                    long j = i3;
                    if (length < j) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    this.f8892e = z4;
                    if (!z4 && Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + j);
                    }
                }
                z3 = this.f8892e;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z3) {
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    public void unblockHardwareBitmaps() {
        Util.assertMainThread();
        this.f8893f.set(true);
    }
}
