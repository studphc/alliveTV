package p000;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

/* renamed from: nt */
/* loaded from: classes.dex */
public final /* synthetic */ class C1597nt implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a */
    public final /* synthetic */ int f23483a;

    /* renamed from: b */
    public final /* synthetic */ Object f23484b;

    public /* synthetic */ C1597nt(int i, Object obj) {
        this.f23483a = i;
        this.f23484b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        FragmentActivity fragmentActivity;
        Object obj = this.f23484b;
        switch (this.f23483a) {
            case 0:
                int i = ComponentActivity.f458v;
                ComponentActivity componentActivity = (ComponentActivity) obj;
                componentActivity.getClass();
                Bundle bundle = new Bundle();
                componentActivity.f470n.onSaveInstanceState(bundle);
                return bundle;
            case 1:
                int i2 = FragmentActivity.f4475B;
                do {
                    fragmentActivity = (FragmentActivity) obj;
                } while (FragmentActivity.m1145c(fragmentActivity.getSupportFragmentManager(), Lifecycle.State.CREATED));
                fragmentActivity.f4478x.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                return new Bundle();
            case 2:
                return ((FragmentManager) obj).m1169T();
            default:
                return SavedStateHandle.m1535a((SavedStateHandle) obj);
        }
    }
}
