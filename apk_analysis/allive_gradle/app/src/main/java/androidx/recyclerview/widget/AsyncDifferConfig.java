package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class AsyncDifferConfig<T> {

    /* renamed from: a */
    public final Executor f6922a;

    /* renamed from: b */
    public final Executor f6923b;

    /* renamed from: c */
    public final DiffUtil.ItemCallback f6924c;

    /* loaded from: classes.dex */
    public static final class Builder<T> {

        /* renamed from: d */
        public static final Object f6925d = new Object();

        /* renamed from: e */
        public static ExecutorService f6926e;

        /* renamed from: a */
        public Executor f6927a;

        /* renamed from: b */
        public Executor f6928b;

        /* renamed from: c */
        public final DiffUtil.ItemCallback f6929c;

        public Builder(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
            this.f6929c = itemCallback;
        }

        @NonNull
        public AsyncDifferConfig<T> build() {
            if (this.f6928b == null) {
                synchronized (f6925d) {
                    try {
                        if (f6926e == null) {
                            f6926e = Executors.newFixedThreadPool(2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.f6928b = f6926e;
            }
            return new AsyncDifferConfig<>(this.f6927a, this.f6928b, this.f6929c);
        }

        @NonNull
        public Builder<T> setBackgroundThreadExecutor(@Nullable Executor executor) {
            this.f6928b = executor;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder<T> setMainThreadExecutor(@Nullable Executor executor) {
            this.f6927a = executor;
            return this;
        }
    }

    public AsyncDifferConfig(Executor executor, Executor executor2, DiffUtil.ItemCallback itemCallback) {
        this.f6922a = executor;
        this.f6923b = executor2;
        this.f6924c = itemCallback;
    }

    @NonNull
    public Executor getBackgroundThreadExecutor() {
        return this.f6923b;
    }

    @NonNull
    public DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.f6924c;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Executor getMainThreadExecutor() {
        return this.f6922a;
    }
}
