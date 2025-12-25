package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {

    /* renamed from: a */
    public final Feature[] f13157a;

    /* renamed from: b */
    public final boolean f13158b;

    /* renamed from: c */
    public final int f13159c;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder<A extends Api.AnyClient, ResultT> {

        /* renamed from: a */
        public RemoteCall f13160a;

        /* renamed from: b */
        public boolean f13161b;

        /* renamed from: c */
        public Feature[] f13162c;

        /* renamed from: d */
        public int f13163d;

        @NonNull
        @KeepForSdk
        public TaskApiCall<A, ResultT> build() {
            boolean z;
            if (this.f13160a != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "execute parameter required");
            return new C0748f(this, this.f13162c, this.f13161b, this.f13163d);
        }

        @NonNull
        @Deprecated
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, ResultT> execute(@NonNull final BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
            this.f13160a = new RemoteCall() { // from class: com.google.android.gms.common.api.internal.zacu
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    BiConsumer.this.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
                }
            };
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, ResultT> run(@NonNull RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.f13160a = remoteCall;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z) {
            this.f13161b = z;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, ResultT> setFeatures(@NonNull Feature... featureArr) {
            this.f13162c = featureArr;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, ResultT> setMethodKey(int i) {
            this.f13163d = i;
            return this;
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.f13157a = null;
        this.f13158b = false;
        this.f13159c = 0;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        Builder<A, ResultT> builder = (Builder<A, ResultT>) new Object();
        builder.f13161b = true;
        builder.f13163d = 0;
        return builder;
    }

    @KeepForSdk
    public abstract void doExecute(@NonNull A a, @NonNull TaskCompletionSource<ResultT> taskCompletionSource);

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.f13158b;
    }

    public final int zaa() {
        return this.f13159c;
    }

    @Nullable
    public final Feature[] zab() {
        return this.f13157a;
    }

    @KeepForSdk
    public TaskApiCall(@Nullable Feature[] featureArr, boolean z, int i) {
        this.f13157a = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.f13158b = z2;
        this.f13159c = i;
    }
}
