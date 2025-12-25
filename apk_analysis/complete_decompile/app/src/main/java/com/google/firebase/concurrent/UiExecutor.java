package com.google.firebase.concurrent;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class UiExecutor implements Executor {
    public static final UiExecutor INSTANCE;

    /* renamed from: a */
    public static final Handler f15553a;

    /* renamed from: b */
    public static final /* synthetic */ UiExecutor[] f15554b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, com.google.firebase.concurrent.UiExecutor] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        INSTANCE = r1;
        f15554b = new UiExecutor[]{r1};
        f15553a = new Handler(Looper.getMainLooper());
    }

    public static UiExecutor valueOf(String str) {
        return (UiExecutor) Enum.valueOf(UiExecutor.class, str);
    }

    public static UiExecutor[] values() {
        return (UiExecutor[]) f15554b.clone();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f15553a.post(runnable);
    }
}
