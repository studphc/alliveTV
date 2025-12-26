package com.google.firebase;

import android.os.Build;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.ArrayList;
import java.util.List;
import p000.C1255h3;
import p000.ee0;

/* loaded from: classes2.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    /* renamed from: a */
    public static String m4367a(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DefaultUserAgentPublisher.component());
        arrayList.add(DefaultHeartBeatController.component());
        arrayList.add(LibraryVersionComponent.create("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(LibraryVersionComponent.create("fire-core", BuildConfig.VERSION_NAME));
        arrayList.add(LibraryVersionComponent.create("device-name", m4367a(Build.PRODUCT)));
        arrayList.add(LibraryVersionComponent.create("device-model", m4367a(Build.DEVICE)));
        arrayList.add(LibraryVersionComponent.create("device-brand", m4367a(Build.BRAND)));
        arrayList.add(LibraryVersionComponent.fromContext("android-target-sdk", new C1255h3(28)));
        arrayList.add(LibraryVersionComponent.fromContext("android-min-sdk", new C1255h3(29)));
        arrayList.add(LibraryVersionComponent.fromContext("android-platform", new ee0(0)));
        arrayList.add(LibraryVersionComponent.fromContext("android-installer", new ee0(1)));
        String detectVersion = KotlinDetector.detectVersion();
        if (detectVersion != null) {
            arrayList.add(LibraryVersionComponent.create("kotlin", detectVersion));
        }
        return arrayList;
    }
}
