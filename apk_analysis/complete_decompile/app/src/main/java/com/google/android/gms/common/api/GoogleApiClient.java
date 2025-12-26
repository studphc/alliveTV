package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zada;
import com.google.android.gms.common.api.internal.zak;
import com.google.android.gms.common.api.internal.zat;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zab;
import com.google.android.gms.signin.SignInOptions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import p000.AbstractC1726qj;
import p000.ye0;

@Deprecated
/* loaded from: classes.dex */
public abstract class GoogleApiClient {

    @NonNull
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;

    /* renamed from: a */
    public static final Set f13047a = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    /* loaded from: classes.dex */
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    public static void dumpAll(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        Set<GoogleApiClient> set = f13047a;
        synchronized (set) {
            try {
                String str2 = str + "  ";
                int i = 0;
                for (GoogleApiClient googleApiClient : set) {
                    printWriter.append((CharSequence) str).append("GoogleApiClient#").println(i);
                    googleApiClient.dump(str2, fileDescriptor, printWriter, strArr);
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static Set<GoogleApiClient> getAllClients() {
        Set<GoogleApiClient> set = f13047a;
        synchronized (set) {
        }
        return set;
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    public abstract ConnectionResult blockingConnect();

    @NonNull
    @ResultIgnorabilityUnspecified
    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    @NonNull
    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr);

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    public <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    @NonNull
    @KeepForSdk
    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean hasApi(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public boolean maybeSignIn(@NonNull SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void maybeSignOut() {
        throw new UnsupportedOperationException();
    }

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(@NonNull L l) {
        throw new UnsupportedOperationException();
    }

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public void zao(zada zadaVar) {
        throw new UnsupportedOperationException();
    }

    public void zap(zada zadaVar) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public Account f13048a;

        /* renamed from: b */
        public final HashSet f13049b;

        /* renamed from: c */
        public final HashSet f13050c;

        /* renamed from: d */
        public int f13051d;

        /* renamed from: e */
        public View f13052e;

        /* renamed from: f */
        public final String f13053f;

        /* renamed from: g */
        public final String f13054g;

        /* renamed from: h */
        public final ArrayMap f13055h;

        /* renamed from: i */
        public final Context f13056i;

        /* renamed from: j */
        public final ArrayMap f13057j;

        /* renamed from: k */
        public LifecycleActivity f13058k;

        /* renamed from: l */
        public int f13059l;

        /* renamed from: m */
        public OnConnectionFailedListener f13060m;

        /* renamed from: n */
        public Looper f13061n;

        /* renamed from: o */
        public final GoogleApiAvailability f13062o;

        /* renamed from: p */
        public final Api.AbstractClientBuilder f13063p;

        /* renamed from: q */
        public final ArrayList f13064q;

        /* renamed from: r */
        public final ArrayList f13065r;

        public Builder(@NonNull Context context) {
            this.f13049b = new HashSet();
            this.f13050c = new HashSet();
            this.f13055h = new ArrayMap();
            this.f13057j = new ArrayMap();
            this.f13059l = -1;
            this.f13062o = GoogleApiAvailability.getInstance();
            this.f13063p = com.google.android.gms.signin.zad.zac;
            this.f13064q = new ArrayList();
            this.f13065r = new ArrayList();
            this.f13056i = context;
            this.f13061n = context.getMainLooper();
            this.f13053f = context.getPackageName();
            this.f13054g = context.getClass().getName();
        }

        /* renamed from: a */
        public final void m3081a(Api api, Api.ApiOptions.HasOptions hasOptions, Scope... scopeArr) {
            HashSet hashSet = new HashSet(((Api.BaseClientBuilder) Preconditions.checkNotNull(api.zac(), "Base client builder must not be null")).getImpliedScopes(hasOptions));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.f13055h.put(api, new zab(hashSet));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            Preconditions.checkNotNull(api, "Api must not be null");
            this.f13057j.put(api, null);
            List<Scope> impliedScopes = ((Api.BaseClientBuilder) Preconditions.checkNotNull(api.zac(), "Base client builder must not be null")).getImpliedScopes(null);
            this.f13050c.addAll(impliedScopes);
            this.f13049b.addAll(impliedScopes);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O o, @NonNull Scope... scopeArr) {
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o, "Null options are not permitted for this Api");
            this.f13057j.put(api, o);
            m3081a(api, o, scopeArr);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
            Preconditions.checkNotNull(connectionCallbacks, "Listener must not be null");
            this.f13064q.add(connectionCallbacks);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            Preconditions.checkNotNull(onConnectionFailedListener, "Listener must not be null");
            this.f13065r.add(onConnectionFailedListener);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addScope(@NonNull Scope scope) {
            Preconditions.checkNotNull(scope, "Scope must not be null");
            this.f13049b.add(scope);
            return this;
        }

        @NonNull
        @ResultIgnorabilityUnspecified
        public GoogleApiClient build() {
            boolean z;
            boolean z2;
            Preconditions.checkArgument(!this.f13057j.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings zaa = zaa();
            Map zad = zaa.zad();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api = null;
            boolean z3 = false;
            for (K k : this.f13057j.keySet()) {
                V v = this.f13057j.get(k);
                if (zad.get(k) != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                arrayMap.put(k, Boolean.valueOf(z2));
                zat zatVar = new zat(k, z2);
                arrayList.add(zatVar);
                Api.AbstractClientBuilder abstractClientBuilder = (Api.AbstractClientBuilder) Preconditions.checkNotNull(k.zaa());
                Api.Client buildClient = abstractClientBuilder.buildClient(this.f13056i, this.f13061n, zaa, (ClientSettings) v, (ConnectionCallbacks) zatVar, (OnConnectionFailedListener) zatVar);
                arrayMap2.put(k.zab(), buildClient);
                if (abstractClientBuilder.getPriority() == 1) {
                    if (v != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                if (buildClient.providesSignIn()) {
                    if (api == null) {
                        api = k;
                    } else {
                        throw new IllegalStateException(AbstractC1726qj.m7058n(k.zad(), " cannot be used with ", api.zad()));
                    }
                }
            }
            if (api != null) {
                if (!z3) {
                    if (this.f13048a == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkState(z, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.zad());
                    Preconditions.checkState(this.f13049b.equals(this.f13050c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.zad());
                } else {
                    throw new IllegalStateException(ye0.m8296p("With using ", api.zad(), ", GamesOptions can only be specified within GoogleSignInOptions.Builder"));
                }
            }
            zabe zabeVar = new zabe(this.f13056i, new ReentrantLock(), this.f13061n, zaa, this.f13062o, this.f13063p, arrayMap, this.f13064q, this.f13065r, arrayMap2, this.f13059l, zabe.zad(arrayMap2.values(), true), arrayList);
            Set set = GoogleApiClient.f13047a;
            synchronized (set) {
                set.add(zabeVar);
            }
            if (this.f13059l >= 0) {
                zak.zaa(this.f13058k).zad(this.f13059l, zabeVar, this.f13060m);
            }
            return zabeVar;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
            Preconditions.checkArgument(i >= 0, "clientId must be non-negative");
            this.f13059l = i;
            this.f13060m = onConnectionFailedListener;
            this.f13058k = lifecycleActivity;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setAccountName(@NonNull String str) {
            Account account;
            if (str == null) {
                account = null;
            } else {
                account = new Account(str, AccountType.GOOGLE);
            }
            this.f13048a = account;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setGravityForPopups(int i) {
            this.f13051d = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setHandler(@NonNull Handler handler) {
            Preconditions.checkNotNull(handler, "Handler must not be null");
            this.f13061n = handler.getLooper();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setViewForPopups(@NonNull View view) {
            Preconditions.checkNotNull(view, "View must not be null");
            this.f13052e = view;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder useDefaultAccount() {
            setAccountName("<<default account>>");
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public final ClientSettings zaa() {
            SignInOptions signInOptions = SignInOptions.zaa;
            ArrayMap arrayMap = this.f13057j;
            Api api = com.google.android.gms.signin.zad.zag;
            if (arrayMap.containsKey(api)) {
                signInOptions = (SignInOptions) arrayMap.get(api);
            }
            Account account = this.f13048a;
            HashSet hashSet = this.f13049b;
            ArrayMap arrayMap2 = this.f13055h;
            int i = this.f13051d;
            View view = this.f13052e;
            String str = this.f13054g;
            return new ClientSettings(account, hashSet, arrayMap2, i, view, this.f13053f, str, signInOptions, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public <T extends Api.ApiOptions.NotRequiredOptions> Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, @NonNull Scope... scopeArr) {
            Preconditions.checkNotNull(api, "Api must not be null");
            this.f13057j.put(api, null);
            m3081a(api, null, scopeArr);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O o) {
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o, "Null options are not permitted for this Api");
            this.f13057j.put(api, o);
            List<Scope> impliedScopes = ((Api.BaseClientBuilder) Preconditions.checkNotNull(api.zac(), "Base client builder must not be null")).getImpliedScopes(o);
            this.f13050c.addAll(impliedScopes);
            this.f13049b.addAll(impliedScopes);
            return this;
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            Preconditions.checkNotNull(connectionCallbacks, "Must provide a connected listener");
            this.f13064q.add(connectionCallbacks);
            Preconditions.checkNotNull(onConnectionFailedListener, "Must provide a connection failed listener");
            this.f13065r.add(onConnectionFailedListener);
        }
    }
}
