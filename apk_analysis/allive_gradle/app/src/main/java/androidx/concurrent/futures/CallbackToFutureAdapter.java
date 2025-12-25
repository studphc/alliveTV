package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import p000.C1289i0;

/* loaded from: classes.dex */
public final class CallbackToFutureAdapter {

    /* loaded from: classes.dex */
    public static final class Completer<T> {

        /* renamed from: a */
        public Object f1811a;

        /* renamed from: b */
        public C0118b f1812b;

        /* renamed from: c */
        public ResolvableFuture f1813c;

        /* renamed from: d */
        public boolean f1814d;

        public void addCancellationListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            ResolvableFuture resolvableFuture = this.f1813c;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        public void finalize() {
            ResolvableFuture resolvableFuture;
            C0118b c0118b = this.f1812b;
            if (c0118b != null) {
                C0117a c0117a = c0118b.f1818b;
                if (!c0117a.isDone()) {
                    c0117a.setException(new C1289i0("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f1811a, 2));
                }
            }
            if (!this.f1814d && (resolvableFuture = this.f1813c) != null) {
                resolvableFuture.set(null);
            }
        }

        public boolean set(T t) {
            boolean z = true;
            this.f1814d = true;
            C0118b c0118b = this.f1812b;
            if (c0118b == null || !c0118b.f1818b.set(t)) {
                z = false;
            }
            if (z) {
                this.f1811a = null;
                this.f1812b = null;
                this.f1813c = null;
            }
            return z;
        }

        public boolean setCancelled() {
            boolean z = true;
            this.f1814d = true;
            C0118b c0118b = this.f1812b;
            if (c0118b == null || !c0118b.f1818b.cancel(true)) {
                z = false;
            }
            if (z) {
                this.f1811a = null;
                this.f1812b = null;
                this.f1813c = null;
            }
            return z;
        }

        public boolean setException(@NonNull Throwable th) {
            boolean z = true;
            this.f1814d = true;
            C0118b c0118b = this.f1812b;
            if (c0118b == null || !c0118b.f1818b.setException(th)) {
                z = false;
            }
            if (z) {
                this.f1811a = null;
                this.f1812b = null;
                this.f1813c = null;
            }
            return z;
        }
    }

    /* loaded from: classes.dex */
    public interface Resolver<T> {
        @Nullable
        Object attachCompleter(@NonNull Completer<T> completer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.concurrent.futures.CallbackToFutureAdapter$Completer, java.lang.Object] */
    @NonNull
    public static <T> ListenableFuture<T> getFuture(@NonNull Resolver<T> resolver) {
        ?? obj = new Object();
        obj.f1813c = ResolvableFuture.create();
        C0118b c0118b = new C0118b(obj);
        obj.f1812b = c0118b;
        obj.f1811a = resolver.getClass();
        try {
            Object attachCompleter = resolver.attachCompleter(obj);
            if (attachCompleter != null) {
                obj.f1811a = attachCompleter;
            }
        } catch (Exception e) {
            c0118b.f1818b.setException(e);
        }
        return c0118b;
    }
}
