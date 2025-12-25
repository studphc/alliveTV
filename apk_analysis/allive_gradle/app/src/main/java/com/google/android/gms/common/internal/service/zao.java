package com.google.android.gms.common.internal.service;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zao extends GoogleApi implements TelemetryLoggingClient {

    /* renamed from: j */
    public static final Api f13484j = new Api("ClientTelemetry.API", new Api.AbstractClientBuilder(), new Api.ClientKey());
    public static final /* synthetic */ int zab = 0;

    public zao(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        super(context, (Api<TelemetryLoggingOptions>) f13484j, telemetryLoggingOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.common.internal.TelemetryLoggingClient
    public final Task<Void> log(final TelemetryData telemetryData) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(zaf.zaa);
        builder.setAutoResolveMissingFeatures(false);
        builder.run(new RemoteCall() { // from class: com.google.android.gms.common.internal.service.zam
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                Api api = zao.f13484j;
                ((zai) ((zap) obj).getService()).zae(TelemetryData.this);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        });
        return doBestEffortWrite(builder.build());
    }
}
