package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import p000.o13;
import p000.p13;

/* loaded from: classes.dex */
public final class VelocityTrackerCompat {

    /* renamed from: a */
    public static final Map f3907a = Collections.synchronizedMap(new WeakHashMap());

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface VelocityTrackableMotionEventAxis {
    }

    public static void addMovement(@NonNull VelocityTracker velocityTracker, @NonNull MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            Map map = f3907a;
            if (!map.containsKey(velocityTracker)) {
                map.put(velocityTracker, new p13());
            }
            p13 p13Var = (p13) map.get(velocityTracker);
            p13Var.getClass();
            long eventTime = motionEvent.getEventTime();
            int i = p13Var.f25006d;
            long[] jArr = p13Var.f25004b;
            if (i != 0 && eventTime - jArr[p13Var.f25007e] > 40) {
                p13Var.f25006d = 0;
                p13Var.f25005c = RecyclerView.f7068F0;
            }
            int i2 = (p13Var.f25007e + 1) % 20;
            p13Var.f25007e = i2;
            int i3 = p13Var.f25006d;
            if (i3 != 20) {
                p13Var.f25006d = i3 + 1;
            }
            p13Var.f25003a[i2] = motionEvent.getAxisValue(26);
            jArr[p13Var.f25007e] = eventTime;
        }
    }

    public static void clear(@NonNull VelocityTracker velocityTracker) {
        velocityTracker.clear();
        f3907a.remove(velocityTracker);
    }

    public static void computeCurrentVelocity(@NonNull VelocityTracker velocityTracker, int i, float f) {
        long j;
        int i2;
        velocityTracker.computeCurrentVelocity(i, f);
        p13 p13Var = (p13) f3907a.get(velocityTracker);
        if (p13Var != null) {
            int i3 = p13Var.f25006d;
            float f2 = RecyclerView.f7068F0;
            if (i3 >= 2) {
                int i4 = p13Var.f25007e;
                int i5 = ((i4 + 20) - (i3 - 1)) % 20;
                long[] jArr = p13Var.f25004b;
                long j2 = jArr[i4];
                while (true) {
                    j = jArr[i5];
                    if (j2 - j <= 100) {
                        break;
                    }
                    p13Var.f25006d--;
                    i5 = (i5 + 1) % 20;
                }
                int i6 = p13Var.f25006d;
                if (i6 >= 2) {
                    float[] fArr = p13Var.f25003a;
                    if (i6 == 2) {
                        int i7 = (i5 + 1) % 20;
                        long j3 = jArr[i7];
                        if (j != j3) {
                            f2 = fArr[i7] / ((float) (j3 - j));
                        }
                    } else {
                        int i8 = 0;
                        float f3 = 0.0f;
                        int i9 = 0;
                        while (true) {
                            if (i8 >= p13Var.f25006d - 1) {
                                break;
                            }
                            int i10 = i8 + i5;
                            long j4 = jArr[i10 % 20];
                            int i11 = (i10 + 1) % 20;
                            if (jArr[i11] == j4) {
                                i2 = i8;
                            } else {
                                i9++;
                                i2 = i8;
                                float sqrt = (f3 < f2 ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f3) * 2.0f));
                                float f4 = fArr[i11] / ((float) (jArr[i11] - j4));
                                f3 += Math.abs(f4) * (f4 - sqrt);
                                if (i9 == 1) {
                                    f3 *= 0.5f;
                                }
                            }
                            i8 = i2 + 1;
                            f2 = RecyclerView.f7068F0;
                        }
                        f2 = (f3 < f2 ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f3) * 2.0f));
                    }
                }
            }
            float f5 = f2 * i;
            p13Var.f25005c = f5;
            if (f5 < (-Math.abs(f))) {
                p13Var.f25005c = -Math.abs(f);
            } else if (p13Var.f25005c > Math.abs(f)) {
                p13Var.f25005c = Math.abs(f);
            }
        }
    }

    public static float getAxisVelocity(@NonNull VelocityTracker velocityTracker, int i) {
        if (Build.VERSION.SDK_INT >= 34) {
            return o13.m6404a(velocityTracker, i);
        }
        if (i == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i == 1) {
            return velocityTracker.getYVelocity();
        }
        p13 p13Var = (p13) f3907a.get(velocityTracker);
        return (p13Var == null || i != 26) ? RecyclerView.f7068F0 : p13Var.f25005c;
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }

    public static boolean isAxisSupported(@NonNull VelocityTracker velocityTracker, int i) {
        if (Build.VERSION.SDK_INT >= 34) {
            return o13.m6406c(velocityTracker, i);
        }
        if (i == 26 || i == 0 || i == 1) {
            return true;
        }
        return false;
    }

    public static void recycle(@NonNull VelocityTracker velocityTracker) {
        velocityTracker.recycle();
        f3907a.remove(velocityTracker);
    }

    public static float getAxisVelocity(@NonNull VelocityTracker velocityTracker, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 34) {
            return o13.m6405b(velocityTracker, i, i2);
        }
        if (i == 0) {
            return velocityTracker.getXVelocity(i2);
        }
        return i == 1 ? velocityTracker.getYVelocity(i2) : RecyclerView.f7068F0;
    }

    public static void computeCurrentVelocity(@NonNull VelocityTracker velocityTracker, int i) {
        computeCurrentVelocity(velocityTracker, i, Float.MAX_VALUE);
    }
}
