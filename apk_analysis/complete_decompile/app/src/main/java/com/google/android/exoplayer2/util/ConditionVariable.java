package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public class ConditionVariable {

    /* renamed from: a */
    public final Clock f12675a;

    /* renamed from: b */
    public boolean f12676b;

    public ConditionVariable() {
        this(Clock.DEFAULT);
    }

    public synchronized void block() {
        while (!this.f12676b) {
            wait();
        }
    }

    public synchronized void blockUninterruptible() {
        boolean z = false;
        while (!this.f12676b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean close() {
        boolean z;
        z = this.f12676b;
        this.f12676b = false;
        return z;
    }

    public synchronized boolean isOpen() {
        return this.f12676b;
    }

    public synchronized boolean open() {
        if (this.f12676b) {
            return false;
        }
        this.f12676b = true;
        notifyAll();
        return true;
    }

    public ConditionVariable(Clock clock) {
        this.f12675a = clock;
    }

    public synchronized boolean block(long j) {
        if (j <= 0) {
            return this.f12676b;
        }
        long elapsedRealtime = this.f12675a.elapsedRealtime();
        long j2 = j + elapsedRealtime;
        if (j2 < elapsedRealtime) {
            block();
        } else {
            while (!this.f12676b && elapsedRealtime < j2) {
                wait(j2 - elapsedRealtime);
                elapsedRealtime = this.f12675a.elapsedRealtime();
            }
        }
        return this.f12676b;
    }
}
