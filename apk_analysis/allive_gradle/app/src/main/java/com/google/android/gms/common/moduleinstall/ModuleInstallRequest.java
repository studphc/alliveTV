package com.google.android.gms.common.moduleinstall;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ModuleInstallRequest {

    /* renamed from: a */
    public final ArrayList f13545a;

    /* renamed from: b */
    public final InstallStatusListener f13546b;

    /* renamed from: c */
    public final Executor f13547c;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public final ArrayList f13548a = new ArrayList();

        /* renamed from: b */
        public InstallStatusListener f13549b;

        /* renamed from: c */
        public Executor f13550c;

        @NonNull
        @CanIgnoreReturnValue
        public Builder addApi(@NonNull OptionalModuleApi optionalModuleApi) {
            this.f13548a.add(optionalModuleApi);
            return this;
        }

        @NonNull
        public ModuleInstallRequest build() {
            return new ModuleInstallRequest(this.f13548a, this.f13549b, this.f13550c);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setListener(@NonNull InstallStatusListener installStatusListener, @Nullable Executor executor) {
            this.f13549b = installStatusListener;
            this.f13550c = executor;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setListener(@NonNull InstallStatusListener installStatusListener) {
            return setListener(installStatusListener, null);
        }
    }

    public /* synthetic */ ModuleInstallRequest(ArrayList arrayList, InstallStatusListener installStatusListener, Executor executor) {
        Preconditions.checkNotNull(arrayList, "APIs must not be null.");
        Preconditions.checkArgument(!arrayList.isEmpty(), "APIs must not be empty.");
        if (executor != null) {
            Preconditions.checkNotNull(installStatusListener, "Listener must not be null when listener executor is set.");
        }
        this.f13545a = arrayList;
        this.f13546b = installStatusListener;
        this.f13547c = executor;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    @NonNull
    public List<OptionalModuleApi> getApis() {
        return this.f13545a;
    }

    @Nullable
    public InstallStatusListener getListener() {
        return this.f13546b;
    }

    @Nullable
    public Executor getListenerExecutor() {
        return this.f13547c;
    }
}
