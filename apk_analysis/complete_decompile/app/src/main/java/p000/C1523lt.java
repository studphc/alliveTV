package p000;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.heartbeatinfo.HeartBeatConsumer;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.concurrent.Executor;

/* renamed from: lt */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1523lt implements ComponentFactory {

    /* renamed from: a */
    public final /* synthetic */ int f22657a;

    /* renamed from: b */
    public final /* synthetic */ Object f22658b;

    public /* synthetic */ C1523lt(int i, Object obj) {
        this.f22657a = i;
        this.f22658b = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f22657a) {
            case 0:
                return this.f22658b;
            default:
                return new DefaultHeartBeatController((Context) componentContainer.get(Context.class), ((FirebaseApp) componentContainer.get(FirebaseApp.class)).getPersistenceKey(), componentContainer.setOf(HeartBeatConsumer.class), componentContainer.getProvider(UserAgentPublisher.class), (Executor) componentContainer.get((Qualified) this.f22658b));
        }
    }
}
