package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {

    /* renamed from: a */
    public final Context f13036a;

    /* renamed from: b */
    public final String f13037b;

    /* renamed from: c */
    public final Api f13038c;

    /* renamed from: d */
    public final Api.ApiOptions f13039d;

    /* renamed from: e */
    public final ApiKey f13040e;

    /* renamed from: f */
    public final Looper f13041f;

    /* renamed from: g */
    public final int f13042g;

    /* renamed from: h */
    public final zabv f13043h;

    /* renamed from: i */
    public final StatusExceptionMapper f13044i;

    @NonNull
    protected final GoogleApiManager zaa;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Settings {

        @NonNull
        @KeepForSdk
        public static final Settings DEFAULT_SETTINGS = new Builder().build();

        @NonNull
        public final StatusExceptionMapper zaa;

        @NonNull
        public final Looper zab;

        @KeepForSdk
        /* loaded from: classes.dex */
        public static class Builder {

            /* renamed from: a */
            public StatusExceptionMapper f13045a;

            /* renamed from: b */
            public Looper f13046b;

            @KeepForSdk
            public Builder() {
            }

            @NonNull
            @KeepForSdk
            public Settings build() {
                if (this.f13045a == null) {
                    this.f13045a = new ApiExceptionMapper();
                }
                if (this.f13046b == null) {
                    this.f13046b = Looper.getMainLooper();
                }
                return new Settings(this.f13045a, this.f13046b);
            }

            @NonNull
            @CanIgnoreReturnValue
            @KeepForSdk
            public Builder setLooper(@NonNull Looper looper) {
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.f13046b = looper;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            @KeepForSdk
            public Builder setMapper(@NonNull StatusExceptionMapper statusExceptionMapper) {
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.f13045a = statusExceptionMapper;
                return this;
            }
        }

        public Settings(StatusExceptionMapper statusExceptionMapper, Looper looper) {
            this.zaa = statusExceptionMapper;
            this.zab = looper;
        }
    }

    @KeepForSdk
    @MainThread
    public GoogleApi(@NonNull Activity activity, @NonNull Api<O> api, @NonNull O o, @NonNull Settings settings) {
        this(activity, activity, api, o, settings);
    }

    @NonNull
    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.f13043h;
    }

    @NonNull
    @KeepForSdk
    public ClientSettings.Builder createClientSettingsBuilder() {
        Account account;
        Set<Scope> emptySet;
        GoogleSignInAccount googleSignInAccount;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        Api.ApiOptions apiOptions = this.f13039d;
        if ((apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) && (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount()) != null) {
            account = googleSignInAccount.getAccount();
        } else if (apiOptions instanceof Api.ApiOptions.HasAccountOptions) {
            account = ((Api.ApiOptions.HasAccountOptions) apiOptions).getAccount();
        } else {
            account = null;
        }
        builder.zab(account);
        if (apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) {
            GoogleSignInAccount googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount();
            if (googleSignInAccount2 == null) {
                emptySet = Collections.emptySet();
            } else {
                emptySet = googleSignInAccount2.getRequestedScopes();
            }
        } else {
            emptySet = Collections.emptySet();
        }
        builder.zaa(emptySet);
        Context context = this.f13036a;
        builder.zac(context.getClass().getName());
        builder.setRealClientPackageName(context.getPackageName());
        return builder;
    }

    @NonNull
    @KeepForSdk
    public Task<Boolean> disconnectService() {
        return this.zaa.zan(this);
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(@NonNull T t) {
        t.zak();
        this.zaa.zau(this, 2, t);
        return t;
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(@NonNull T t) {
        t.zak();
        this.zaa.zau(this, 0, t);
        return t;
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @Deprecated
    @KeepForSdk
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(@NonNull T t, @NonNull U u) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(u);
        Preconditions.checkNotNull(t.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(u.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(Objects.equal(t.getListenerKey(), u.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.zao(this, t, u, zad.zaa);
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(@NonNull ListenerHolder.ListenerKey<?> listenerKey) {
        return doUnregisterEventListener(listenerKey, 0);
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(@NonNull T t) {
        t.zak();
        this.zaa.zau(this, 1, t);
        return t;
    }

    @Nullable
    public String getApiFallbackAttributionTag(@NonNull Context context) {
        return null;
    }

    @Override // com.google.android.gms.common.api.HasApiKey
    @NonNull
    public final ApiKey<O> getApiKey() {
        return this.f13040e;
    }

    @NonNull
    @KeepForSdk
    public O getApiOptions() {
        return (O) this.f13039d;
    }

    @NonNull
    @KeepForSdk
    public Context getApplicationContext() {
        return this.f13036a;
    }

    @Nullable
    @KeepForSdk
    public String getContextAttributionTag() {
        return this.f13037b;
    }

    @Nullable
    @KeepForSdk
    @Deprecated
    public String getContextFeatureId() {
        return this.f13037b;
    }

    @NonNull
    @KeepForSdk
    public Looper getLooper() {
        return this.f13041f;
    }

    @NonNull
    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(@NonNull L l, @NonNull String str) {
        return ListenerHolders.createListenerHolder(l, this.f13041f, str);
    }

    public final int zaa() {
        return this.f13042g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final Api.Client zab(Looper looper, zabq zabqVar) {
        ClientSettings build = createClientSettingsBuilder().build();
        Api.Client buildClient = ((Api.AbstractClientBuilder) Preconditions.checkNotNull(this.f13038c.zaa())).buildClient(this.f13036a, looper, build, (ClientSettings) this.f13039d, (GoogleApiClient.ConnectionCallbacks) zabqVar, (GoogleApiClient.OnConnectionFailedListener) zabqVar);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (buildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) buildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (buildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) buildClient).zac(contextAttributionTag);
        }
        return buildClient;
    }

    public final zact zac(Context context, Handler handler) {
        return new zact(context, handler, createClientSettingsBuilder().build());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @KeepForSdk
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GoogleApi(@NonNull Activity activity, @NonNull Api<O> api, @NonNull O o, @NonNull StatusExceptionMapper statusExceptionMapper) {
        this(activity, (Api) api, (Api.ApiOptions) o, r0.build());
        Settings.Builder builder = new Settings.Builder();
        builder.setMapper(statusExceptionMapper);
        builder.setLooper(activity.getMainLooper());
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(@NonNull ListenerHolder.ListenerKey<?> listenerKey, int i) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.zaa.zap(this, listenerKey, i);
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zav(this, 2, taskApiCall, taskCompletionSource, this.f13044i);
        return taskCompletionSource.getTask();
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zav(this, 0, taskApiCall, taskCompletionSource, this.f13044i);
        return taskCompletionSource.getTask();
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zav(this, 1, taskApiCall, taskCompletionSource, this.f13044i);
        return taskCompletionSource.getTask();
    }

    public GoogleApi(Context context, Activity activity, Api api, Api.ApiOptions apiOptions, Settings settings) {
        String apiFallbackAttributionTag;
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) Preconditions.checkNotNull(context.getApplicationContext(), "The provided context did not have an application context.");
        this.f13036a = context2;
        if (Build.VERSION.SDK_INT >= 30) {
            apiFallbackAttributionTag = context.getAttributionTag();
        } else {
            apiFallbackAttributionTag = getApiFallbackAttributionTag(context);
        }
        this.f13037b = apiFallbackAttributionTag;
        this.f13038c = api;
        this.f13039d = apiOptions;
        this.f13041f = settings.zab;
        ApiKey sharedApiKey = ApiKey.getSharedApiKey(api, apiOptions, apiFallbackAttributionTag);
        this.f13040e = sharedApiKey;
        this.f13043h = new zabv(this);
        GoogleApiManager zak = GoogleApiManager.zak(context2);
        this.zaa = zak;
        this.f13042g = zak.zaa();
        this.f13044i = settings.zaa;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zaae.zad(activity, zak, sharedApiKey);
        }
        zak.zaz(this);
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(@NonNull RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull(registrationMethods.register.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(registrationMethods.zaa.getListenerKey(), "Listener has already been released.");
        return this.zaa.zao(this, registrationMethods.register, registrationMethods.zaa, registrationMethods.zab);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @InlineMe(imports = {"com.google.android.gms.common.api.GoogleApi.Settings"}, replacement = "this(context, api, options, new Settings.Builder().setLooper(looper).setMapper(mapper).build())")
    @KeepForSdk
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GoogleApi(@NonNull Context context, @NonNull Api<O> api, @NonNull O o, @NonNull Looper looper, @NonNull StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, r0.build());
        Settings.Builder builder = new Settings.Builder();
        builder.setLooper(looper);
        builder.setMapper(statusExceptionMapper);
    }

    @KeepForSdk
    public GoogleApi(@NonNull Context context, @NonNull Api<O> api, @NonNull O o, @NonNull Settings settings) {
        this(context, (Activity) null, api, o, settings);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @InlineMe(imports = {"com.google.android.gms.common.api.GoogleApi.Settings"}, replacement = "this(context, api, options, new Settings.Builder().setMapper(mapper).build())")
    @KeepForSdk
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GoogleApi(@NonNull Context context, @NonNull Api<O> api, @NonNull O o, @NonNull StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, r0.build());
        Settings.Builder builder = new Settings.Builder();
        builder.setMapper(statusExceptionMapper);
    }
}
