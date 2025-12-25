package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client, zaj {

    /* renamed from: D */
    public final ClientSettings f13437D;

    /* renamed from: E */
    public final Set f13438E;

    /* renamed from: F */
    public final Account f13439F;

    @KeepForSdk
    @VisibleForTesting
    public GmsClient(@NonNull Context context, @NonNull Handler handler, int i, @NonNull ClientSettings clientSettings) {
        super(context, handler, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i, null, null);
        this.f13437D = (ClientSettings) Preconditions.checkNotNull(clientSettings);
        this.f13439F = clientSettings.getAccount();
        this.f13438E = m3140e(clientSettings.getAllRequestedScopes());
    }

    /* renamed from: e */
    public final Set m3140e(Set set) {
        Set<Scope> validateScopes = validateScopes(set);
        Iterator<Scope> it = validateScopes.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @Nullable
    public final Account getAccount() {
        return this.f13439F;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @Nullable
    @KeepForSdk
    public Executor getBindServiceExecutor() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public final ClientSettings getClientSettings() {
        return this.f13437D;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    @KeepForSdk
    public final Set<Scope> getScopes() {
        return this.f13438E;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    @KeepForSdk
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        if (requiresSignIn()) {
            return this.f13438E;
        }
        return Collections.emptySet();
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> validateScopes(@NonNull Set<Scope> set) {
        return set;
    }

    @KeepForSdk
    public GmsClient(@NonNull Context context, @NonNull Looper looper, int i, @NonNull ClientSettings clientSettings) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i, clientSettings, null, null);
    }

    @KeepForSdk
    @Deprecated
    public GmsClient(@NonNull Context context, @NonNull Looper looper, int i, @NonNull ClientSettings clientSettings, @NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, i, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
    }

    @KeepForSdk
    public GmsClient(@NonNull Context context, @NonNull Looper looper, int i, @NonNull ClientSettings clientSettings, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i, clientSettings, (ConnectionCallbacks) Preconditions.checkNotNull(connectionCallbacks), (OnConnectionFailedListener) Preconditions.checkNotNull(onConnectionFailedListener));
    }

    @VisibleForTesting
    public GmsClient(@NonNull Context context, @NonNull Looper looper, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull GoogleApiAvailability googleApiAvailability, int i, @NonNull ClientSettings clientSettings, @Nullable ConnectionCallbacks connectionCallbacks, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, gmsClientSupervisor, googleApiAvailability, i, connectionCallbacks == null ? null : new C0754a(connectionCallbacks), onConnectionFailedListener == null ? null : new C0755b(onConnectionFailedListener), clientSettings.zac());
        this.f13437D = clientSettings;
        this.f13439F = clientSettings.getAccount();
        this.f13438E = m3140e(clientSettings.getAllRequestedScopes());
    }
}
