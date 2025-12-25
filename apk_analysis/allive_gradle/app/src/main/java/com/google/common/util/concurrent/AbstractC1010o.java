package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;

/* renamed from: com.google.common.util.concurrent.o */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1010o {

    /* renamed from: a */
    public static final /* synthetic */ int[] f15410a;

    static {
        int[] iArr = new int[Service.State.values().length];
        f15410a = iArr;
        try {
            iArr[Service.State.NEW.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15410a[Service.State.STARTING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f15410a[Service.State.RUNNING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f15410a[Service.State.STOPPING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f15410a[Service.State.TERMINATED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f15410a[Service.State.FAILED.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
