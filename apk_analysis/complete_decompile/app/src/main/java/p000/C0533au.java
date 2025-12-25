package p000;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;

/* renamed from: au */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0533au implements Provider {

    /* renamed from: a */
    public final /* synthetic */ int f7738a;

    /* renamed from: b */
    public final /* synthetic */ Object f7739b;

    /* renamed from: c */
    public final /* synthetic */ Object f7740c;

    public /* synthetic */ C0533au(int i, Object obj, Object obj2) {
        this.f7738a = i;
        this.f7739b = obj;
        this.f7740c = obj2;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        Object obj = this.f7740c;
        Object obj2 = this.f7739b;
        switch (this.f7738a) {
            case 0:
                ComponentRuntime componentRuntime = (ComponentRuntime) obj2;
                componentRuntime.getClass();
                Component component = (Component) obj;
                return component.getFactory().create(new ic2(component, componentRuntime));
            case 1:
                return new j01((Context) obj2, (String) obj);
            default:
                String str = FirebaseApp.DEFAULT_APP_NAME;
                FirebaseApp firebaseApp = (FirebaseApp) obj2;
                String persistenceKey = firebaseApp.getPersistenceKey();
                ComponentRuntime componentRuntime2 = firebaseApp.f15456d;
                componentRuntime2.getClass();
                return new DataCollectionConfigStorage((Context) obj, persistenceKey, (Publisher) AbstractC1921vt.m7934b(componentRuntime2, Publisher.class));
        }
    }
}
