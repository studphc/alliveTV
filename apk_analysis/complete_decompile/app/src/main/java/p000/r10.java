package p000;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.GlobalLibraryVersionRegistrar;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final /* synthetic */ class r10 implements ComponentFactory {

    /* renamed from: a */
    public final /* synthetic */ int f25833a;

    public /* synthetic */ r10(int i) {
        this.f25833a = i;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f25833a) {
            case 0:
                return new DefaultUserAgentPublisher(componentContainer.setOf(C1868ud.class), GlobalLibraryVersionRegistrar.getInstance());
            case 1:
                return (ScheduledExecutorService) ExecutorsRegistrar.f15549a.get();
            case 2:
                return (ScheduledExecutorService) ExecutorsRegistrar.f15551c.get();
            case 3:
                return (ScheduledExecutorService) ExecutorsRegistrar.f15550b.get();
            case 4:
                Lazy lazy = ExecutorsRegistrar.f15549a;
                return UiExecutor.INSTANCE;
            default:
                return FirebaseInstallationsRegistrar.m4389a(componentContainer);
        }
    }
}
