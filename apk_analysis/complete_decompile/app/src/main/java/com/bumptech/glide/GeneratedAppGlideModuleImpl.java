package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.hisona.allive.TrustAllGlideModule;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* renamed from: a */
    public final TrustAllGlideModule f8449a = new TrustAllGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.hisona.allive.TrustAllGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
        }
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    /* renamed from: a */
    public final Set mo2269a() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public final void applyOptions(Context context, GlideBuilder glideBuilder) {
        this.f8449a.applyOptions(context, glideBuilder);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bumptech.glide.manager.RequestManagerRetriever$RequestManagerFactory, java.lang.Object] */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    /* renamed from: b */
    public final RequestManagerRetriever.RequestManagerFactory mo2270b() {
        return new Object();
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public final boolean isManifestParsingEnabled() {
        return this.f8449a.isManifestParsingEnabled();
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule
    public final void registerComponents(Context context, Glide glide, Registry registry) {
        new OkHttpLibraryGlideModule().registerComponents(context, glide, registry);
        this.f8449a.registerComponents(context, glide, registry);
    }
}
