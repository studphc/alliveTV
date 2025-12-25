package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@KeepForSdk
/* loaded from: classes.dex */
public class RegistrationMethods<A extends Api.AnyClient, L> {

    @NonNull
    @KeepForSdk
    public final RegisterListenerMethod<A, L> register;

    @NonNull
    public final UnregisterListenerMethod zaa;

    @NonNull
    public final Runnable zab;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder<A extends Api.AnyClient, L> {

        /* renamed from: a */
        public RemoteCall f13149a;

        /* renamed from: b */
        public RemoteCall f13150b;

        /* renamed from: c */
        public Runnable f13151c;

        /* renamed from: d */
        public ListenerHolder f13152d;

        /* renamed from: e */
        public Feature[] f13153e;

        /* renamed from: f */
        public boolean f13154f;

        /* renamed from: g */
        public int f13155g;

        @NonNull
        @KeepForSdk
        public RegistrationMethods<A, L> build() {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (this.f13149a != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Must set register function");
            if (this.f13150b != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Must set unregister function");
            if (this.f13152d != null) {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "Must set holder");
            return new RegistrationMethods<>(new C0746d(this, this.f13152d, this.f13153e, this.f13154f, this.f13155g), new C0747e(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(this.f13152d.getListenerKey(), "Key must not be null")), this.f13151c);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> onConnectionSuspended(@NonNull Runnable runnable) {
            this.f13151c = runnable;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> register(@NonNull RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.f13149a = remoteCall;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> setAutoResolveMissingFeatures(boolean z) {
            this.f13154f = z;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> setFeatures(@NonNull Feature... featureArr) {
            this.f13153e = featureArr;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> setMethodKey(int i) {
            this.f13155g = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> unregister(@NonNull RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.f13150b = remoteCall;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> withHolder(@NonNull ListenerHolder<L> listenerHolder) {
            this.f13152d = listenerHolder;
            return this;
        }
    }

    public /* synthetic */ RegistrationMethods(C0746d c0746d, C0747e c0747e, Runnable runnable) {
        this.register = c0746d;
        this.zaa = c0747e;
        this.zab = runnable;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        Builder<A, L> builder = (Builder<A, L>) new Object();
        builder.f13151c = zacj.zaa;
        builder.f13154f = true;
        return builder;
    }
}
