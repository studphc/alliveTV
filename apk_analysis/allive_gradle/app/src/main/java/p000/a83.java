package p000;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public final class a83 implements OnCompleteListener {

    /* renamed from: a */
    public final GoogleApiManager f83a;

    /* renamed from: b */
    public final int f84b;

    /* renamed from: c */
    public final ApiKey f85c;

    /* renamed from: d */
    public final long f86d;

    /* renamed from: e */
    public final long f87e;

    public a83(GoogleApiManager googleApiManager, int i, ApiKey apiKey, long j, long j2) {
        this.f83a = googleApiManager;
        this.f84b = i;
        this.f85c = apiKey;
        this.f86d = j;
        this.f87e = j2;
    }

    /* renamed from: a */
    public static ConnectionTelemetryConfiguration m41a(zabq zabqVar, BaseGmsClient baseGmsClient, int i) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i))) || zabqVar.f13269l >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        zabq zabqVar;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j;
        long j2;
        int i7;
        GoogleApiManager googleApiManager = this.f83a;
        if (googleApiManager.m3087a()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zabqVar = (zabq) googleApiManager.f13115j.get(this.f85c)) != null && (zabqVar.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zabqVar.zaf();
                long j3 = this.f86d;
                boolean z2 = true;
                if (j3 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                if (config != null) {
                    z &= config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    i = config.getVersion();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration m41a = m41a(zabqVar, baseGmsClient, this.f84b);
                        if (m41a != null) {
                            if (!m41a.getMethodTimingTelemetryEnabled() || j3 <= 0) {
                                z2 = false;
                            }
                            maxMethodInvocationsInBatch = m41a.getMaxMethodInvocationsLogged();
                            z = z2;
                        } else {
                            return;
                        }
                    }
                    i3 = batchPeriodMillis;
                    i2 = maxMethodInvocationsInBatch;
                } else {
                    i = 0;
                    i2 = 100;
                    i3 = 5000;
                }
                if (task.isSuccessful()) {
                    i6 = 0;
                    i5 = 0;
                } else if (task.isCanceled()) {
                    i5 = -1;
                    i6 = 100;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        Status status = ((ApiException) exception).getStatus();
                        i4 = status.getStatusCode();
                        ConnectionResult connectionResult = status.getConnectionResult();
                        if (connectionResult != null) {
                            i5 = connectionResult.getErrorCode();
                            i6 = i4;
                        }
                    } else {
                        i4 = 101;
                    }
                    i5 = -1;
                    i6 = i4;
                }
                if (z) {
                    j = j3;
                    j2 = System.currentTimeMillis();
                    i7 = (int) (SystemClock.elapsedRealtime() - this.f87e);
                } else {
                    j = 0;
                    j2 = 0;
                    i7 = -1;
                }
                b83 b83Var = new b83(new MethodInvocation(this.f84b, i6, i5, j, j2, null, null, gCoreServiceId, i7), i, i3, i2);
                zau zauVar = googleApiManager.f13119n;
                zauVar.sendMessage(zauVar.obtainMessage(18, b83Var));
            }
        }
    }
}
