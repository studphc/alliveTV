package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public class BaseImplementation {

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface ResultHolder<R> {
        @KeepForSdk
        void setFailedResult(@NonNull Status status);

        @KeepForSdk
        void setResult(@NonNull R r);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {

        /* renamed from: o */
        public final Api.AnyClientKey f13086o;

        /* renamed from: p */
        public final Api f13087p;

        @KeepForSdk
        @Deprecated
        public ApiMethodImpl(@NonNull Api.AnyClientKey<A> anyClientKey, @NonNull GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            this.f13086o = (Api.AnyClientKey) Preconditions.checkNotNull(anyClientKey);
            this.f13087p = null;
        }

        @KeepForSdk
        public abstract void doExecute(@NonNull A a);

        @Nullable
        @KeepForSdk
        public final Api<?> getApi() {
            return this.f13087p;
        }

        @NonNull
        @KeepForSdk
        public final Api.AnyClientKey<A> getClientKey() {
            return this.f13086o;
        }

        @KeepForSdk
        public void onSetFailedResult(@NonNull R r) {
        }

        @KeepForSdk
        public final void run(@NonNull A a) {
            try {
                doExecute(a);
            } catch (DeadObjectException e) {
                setFailedResult(new Status(8, e.getLocalizedMessage(), (PendingIntent) null));
                throw e;
            } catch (RemoteException e2) {
                setFailedResult(new Status(8, e2.getLocalizedMessage(), (PendingIntent) null));
            }
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        @KeepForSdk
        public final void setFailedResult(@NonNull Status status) {
            Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success");
            R createFailedResult = createFailedResult(status);
            setResult((ApiMethodImpl<R, A>) createFailedResult);
            onSetFailedResult(createFailedResult);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        @KeepForSdk
        public /* bridge */ /* synthetic */ void setResult(@NonNull Object obj) {
            setResult((ApiMethodImpl<R, A>) obj);
        }

        @KeepForSdk
        public ApiMethodImpl(@NonNull Api<?> api, @NonNull GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            Preconditions.checkNotNull(api, "Api must not be null");
            this.f13086o = api.zab();
            this.f13087p = api;
        }

        @KeepForSdk
        @VisibleForTesting
        public ApiMethodImpl(@NonNull BasePendingResult.CallbackHandler<R> callbackHandler) {
            super(callbackHandler);
            this.f13086o = new Api.AnyClientKey();
            this.f13087p = null;
        }
    }
}
