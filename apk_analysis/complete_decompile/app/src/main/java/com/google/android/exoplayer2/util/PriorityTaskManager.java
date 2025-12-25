package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public final class PriorityTaskManager {

    /* renamed from: a */
    public final Object f12747a = new Object();

    /* renamed from: b */
    public final PriorityQueue f12748b = new PriorityQueue(10, Collections.reverseOrder());

    /* renamed from: c */
    public int f12749c = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    public void add(int i) {
        synchronized (this.f12747a) {
            this.f12748b.add(Integer.valueOf(i));
            this.f12749c = Math.max(this.f12749c, i);
        }
    }

    public void proceed(int i) {
        synchronized (this.f12747a) {
            while (this.f12749c != i) {
                try {
                    this.f12747a.wait();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public boolean proceedNonBlocking(int i) {
        boolean z;
        synchronized (this.f12747a) {
            if (this.f12749c == i) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public void proceedOrThrow(int i) {
        synchronized (this.f12747a) {
            try {
                if (this.f12749c != i) {
                    throw new PriorityTooLowException(i, this.f12749c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void remove(int i) {
        int intValue;
        synchronized (this.f12747a) {
            this.f12748b.remove(Integer.valueOf(i));
            if (this.f12748b.isEmpty()) {
                intValue = Integer.MIN_VALUE;
            } else {
                intValue = ((Integer) Util.castNonNull((Integer) this.f12748b.peek())).intValue();
            }
            this.f12749c = intValue;
            this.f12747a.notifyAll();
        }
    }
}
