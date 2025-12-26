package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

@KeepForSdk
/* loaded from: classes.dex */
public final class ListenerHolder<L> {

    /* renamed from: a */
    public final Executor f13128a;

    /* renamed from: b */
    public volatile Object f13129b;

    /* renamed from: c */
    public volatile ListenerKey f13130c;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class ListenerKey<L> {

        /* renamed from: a */
        public final Object f13131a;

        /* renamed from: b */
        public final String f13132b;

        public ListenerKey(Object obj, String str) {
            this.f13131a = obj;
            this.f13132b = str;
        }

        @KeepForSdk
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            if (this.f13131a == listenerKey.f13131a && this.f13132b.equals(listenerKey.f13132b)) {
                return true;
            }
            return false;
        }

        @KeepForSdk
        public int hashCode() {
            return this.f13132b.hashCode() + (System.identityHashCode(this.f13131a) * 31);
        }

        @NonNull
        @KeepForSdk
        public String toIdString() {
            return this.f13132b + "@" + System.identityHashCode(this.f13131a);
        }
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(@NonNull L l);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    public ListenerHolder(Object obj, Looper looper, String str) {
        this.f13128a = new HandlerExecutor(looper);
        this.f13129b = Preconditions.checkNotNull(obj, "Listener must not be null");
        this.f13130c = new ListenerKey(obj, Preconditions.checkNotEmpty(str));
    }

    @KeepForSdk
    public void clear() {
        this.f13129b = null;
        this.f13130c = null;
    }

    @Nullable
    @KeepForSdk
    public ListenerKey<L> getListenerKey() {
        return this.f13130c;
    }

    @KeepForSdk
    public boolean hasListener() {
        return this.f13129b != null;
    }

    @KeepForSdk
    public void notifyListener(@NonNull final Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.f13128a.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacb
            @Override // java.lang.Runnable
            public final void run() {
                ListenerHolder listenerHolder = ListenerHolder.this;
                ListenerHolder.Notifier notifier2 = notifier;
                Object obj = listenerHolder.f13129b;
                if (obj == null) {
                    notifier2.onNotifyListenerFailed();
                    return;
                }
                try {
                    notifier2.notifyListener(obj);
                } catch (RuntimeException e) {
                    notifier2.onNotifyListenerFailed();
                    throw e;
                }
            }
        });
    }

    public ListenerHolder(Object obj, Executor executor, String str) {
        this.f13128a = (Executor) Preconditions.checkNotNull(executor, "Executor must not be null");
        this.f13129b = Preconditions.checkNotNull(obj, "Listener must not be null");
        this.f13130c = new ListenerKey(obj, Preconditions.checkNotEmpty(str));
    }
}
