package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionSequencer;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class oa0 extends AtomicReference implements Executor, Runnable {

    /* renamed from: e */
    public static final /* synthetic */ int f23677e = 0;

    /* renamed from: a */
    public ExecutionSequencer f23678a;

    /* renamed from: b */
    public Executor f23679b;

    /* renamed from: c */
    public Runnable f23680c;

    /* renamed from: d */
    public Thread f23681d;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        boolean z;
        if (get() == na0.f23310b) {
            this.f23679b = null;
            this.f23678a = null;
            return;
        }
        this.f23681d = Thread.currentThread();
        try {
            ExecutionSequencer executionSequencer = this.f23678a;
            Objects.requireNonNull(executionSequencer);
            jz2 jz2Var = executionSequencer.f15319b;
            if (((Thread) jz2Var.f20698b) == this.f23681d) {
                this.f23678a = null;
                if (((Runnable) jz2Var.f20699c) == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                jz2Var.f20699c = runnable;
                Executor executor = this.f23679b;
                Objects.requireNonNull(executor);
                jz2Var.f20700d = executor;
                this.f23679b = null;
            } else {
                Executor executor2 = this.f23679b;
                Objects.requireNonNull(executor2);
                this.f23679b = null;
                this.f23680c = runnable;
                executor2.execute(this);
            }
            this.f23681d = null;
        } catch (Throwable th) {
            this.f23681d = null;
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Executor executor;
        Thread currentThread = Thread.currentThread();
        if (currentThread != this.f23681d) {
            Runnable runnable = this.f23680c;
            Objects.requireNonNull(runnable);
            this.f23680c = null;
            runnable.run();
            return;
        }
        jz2 jz2Var = new jz2(2);
        jz2Var.f20698b = currentThread;
        ExecutionSequencer executionSequencer = this.f23678a;
        Objects.requireNonNull(executionSequencer);
        executionSequencer.f15319b = jz2Var;
        this.f23678a = null;
        try {
            Runnable runnable2 = this.f23680c;
            Objects.requireNonNull(runnable2);
            this.f23680c = null;
            runnable2.run();
            while (true) {
                Runnable runnable3 = (Runnable) jz2Var.f20699c;
                if (runnable3 == null || (executor = (Executor) jz2Var.f20700d) == null) {
                    break;
                }
                jz2Var.f20699c = null;
                jz2Var.f20700d = null;
                executor.execute(runnable3);
            }
        } finally {
            jz2Var.f20698b = null;
        }
    }
}
