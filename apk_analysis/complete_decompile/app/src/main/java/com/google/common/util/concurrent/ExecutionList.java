package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.AbstractC1726qj;
import p000.jz2;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class ExecutionList {

    /* renamed from: c */
    public static final Logger f15315c = Logger.getLogger(ExecutionList.class.getName());

    /* renamed from: a */
    public jz2 f15316a;

    /* renamed from: b */
    public boolean f15317b;

    /* renamed from: a */
    public static void m4326a(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            f15315c.log(level, AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 57, "RuntimeException while executing runnable ", valueOf, " with executor ", valueOf2), (Throwable) e);
        }
    }

    public void add(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        synchronized (this) {
            try {
                if (!this.f15317b) {
                    this.f15316a = new jz2(runnable, executor, this.f15316a, 1);
                } else {
                    m4326a(runnable, executor);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void execute() {
        synchronized (this) {
            try {
                if (this.f15317b) {
                    return;
                }
                this.f15317b = true;
                jz2 jz2Var = this.f15316a;
                jz2 jz2Var2 = null;
                this.f15316a = null;
                while (jz2Var != null) {
                    jz2 jz2Var3 = (jz2) jz2Var.f20700d;
                    jz2Var.f20700d = jz2Var2;
                    jz2Var2 = jz2Var;
                    jz2Var = jz2Var3;
                }
                while (jz2Var2 != null) {
                    m4326a((Runnable) jz2Var2.f20698b, (Executor) jz2Var2.f20699c);
                    jz2Var2 = (jz2) jz2Var2.f20700d;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
