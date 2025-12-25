package com.google.android.gms.common.moduleinstall.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallClient;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.internal.base.zav;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import p000.a93;
import p000.b93;
import p000.x63;
import p000.x83;
import p000.z83;

/* loaded from: classes.dex */
public final class zay extends GoogleApi implements ModuleInstallClient {

    /* renamed from: j */
    public static final Api f13566j = new Api("ModuleInstall.API", new Api.AbstractClientBuilder(), new Api.ClientKey());
    public static final /* synthetic */ int zab = 0;

    public zay(Activity activity) {
        super(activity, (Api<Api.ApiOptions.NoOptions>) f13566j, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* renamed from: a */
    public static final ApiFeatureRequest m3176a(boolean z, OptionalModuleApi... optionalModuleApiArr) {
        boolean z2;
        Preconditions.checkNotNull(optionalModuleApiArr, "Requested APIs must not be null.");
        if (optionalModuleApiArr.length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "Please provide at least one OptionalModuleApi.");
        for (OptionalModuleApi optionalModuleApi : optionalModuleApiArr) {
            Preconditions.checkNotNull(optionalModuleApi, "Requested API must not be null.");
        }
        return ApiFeatureRequest.m3175a(Arrays.asList(optionalModuleApiArr), z);
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<ModuleAvailabilityResponse> areModulesAvailable(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest m3176a = m3176a(false, optionalModuleApiArr);
        if (m3176a.getApiFeatures().isEmpty()) {
            return Tasks.forResult(new ModuleAvailabilityResponse(true, 0));
        }
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(zav.zaa);
        builder.setMethodKey(27301);
        builder.setAutoResolveMissingFeatures(false);
        builder.run(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zal
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zae(new x83(0, (TaskCompletionSource) obj2), m3176a);
            }
        });
        return doRead(builder.build());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<Void> deferredInstall(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest m3176a = m3176a(false, optionalModuleApiArr);
        if (m3176a.getApiFeatures().isEmpty()) {
            return Tasks.forResult(null);
        }
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(zav.zaa);
        builder.setMethodKey(27302);
        builder.setAutoResolveMissingFeatures(false);
        builder.run(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zap
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zag(new x83(1, (TaskCompletionSource) obj2), m3176a, null);
            }
        });
        return doRead(builder.build());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<ModuleInstallIntentResponse> getInstallModulesIntent(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest m3176a = m3176a(true, optionalModuleApiArr);
        if (m3176a.getApiFeatures().isEmpty()) {
            return Tasks.forResult(new ModuleInstallIntentResponse(null));
        }
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(zav.zaa);
        builder.setMethodKey(27307);
        builder.run(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zan
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zaf(new x83(3, (TaskCompletionSource) obj2), m3176a);
            }
        });
        return doRead(builder.build());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<ModuleInstallResponse> installModules(ModuleInstallRequest moduleInstallRequest) {
        ListenerHolder createListenerHolder;
        final ApiFeatureRequest fromModuleInstallRequest = ApiFeatureRequest.fromModuleInstallRequest(moduleInstallRequest);
        final InstallStatusListener listener = moduleInstallRequest.getListener();
        Executor listenerExecutor = moduleInstallRequest.getListenerExecutor();
        if (fromModuleInstallRequest.getApiFeatures().isEmpty()) {
            return Tasks.forResult(new ModuleInstallResponse(0));
        }
        if (listener == null) {
            TaskApiCall.Builder builder = TaskApiCall.builder();
            builder.setFeatures(zav.zaa);
            builder.setAutoResolveMissingFeatures(true);
            builder.setMethodKey(27304);
            builder.run(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zao
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    ((zaf) ((zaz) obj).getService()).zag(new x83(2, (TaskCompletionSource) obj2), fromModuleInstallRequest, null);
                }
            });
            return doRead(builder.build());
        }
        Preconditions.checkNotNull(listener);
        if (listenerExecutor == null) {
            createListenerHolder = registerListener(listener, "InstallStatusListener");
        } else {
            createListenerHolder = ListenerHolders.createListenerHolder(listener, listenerExecutor, "InstallStatusListener");
        }
        final x63 x63Var = new x63(createListenerHolder);
        final AtomicReference atomicReference = new AtomicReference();
        RemoteCall remoteCall = new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zai
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zag(new z83(zay.this, atomicReference, (TaskCompletionSource) obj2, listener), fromModuleInstallRequest, x63Var);
            }
        };
        RemoteCall remoteCall2 = new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zaj
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zai(new a93((TaskCompletionSource) obj2), x63Var);
            }
        };
        RegistrationMethods.Builder builder2 = RegistrationMethods.builder();
        builder2.withHolder(createListenerHolder);
        builder2.setFeatures(zav.zaa);
        builder2.setAutoResolveMissingFeatures(true);
        builder2.register(remoteCall);
        builder2.unregister(remoteCall2);
        builder2.setMethodKey(27305);
        return doRegisterEventListener(builder2.build()).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.gms.common.moduleinstall.internal.zak
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Api api = zay.f13566j;
                AtomicReference atomicReference2 = atomicReference;
                if (atomicReference2.get() != null) {
                    return Tasks.forResult((ModuleInstallResponse) atomicReference2.get());
                }
                return Tasks.forException(new ApiException(Status.RESULT_INTERNAL_ERROR));
            }
        });
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<Void> releaseModules(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest m3176a = m3176a(false, optionalModuleApiArr);
        if (m3176a.getApiFeatures().isEmpty()) {
            return Tasks.forResult(null);
        }
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(zav.zaa);
        builder.setMethodKey(27303);
        builder.setAutoResolveMissingFeatures(false);
        builder.run(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zam
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zah(new b93((TaskCompletionSource) obj2), m3176a);
            }
        });
        return doRead(builder.build());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    @ResultIgnorabilityUnspecified
    public final Task<Boolean> unregisterListener(InstallStatusListener installStatusListener) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(installStatusListener, "InstallStatusListener"), 27306);
    }

    public zay(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) f13566j, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
