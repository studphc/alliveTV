package p000;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.fragment.app.FragmentActivity;

/* renamed from: ot */
/* loaded from: classes.dex */
public final /* synthetic */ class C1662ot implements OnContextAvailableListener {

    /* renamed from: a */
    public final /* synthetic */ int f24897a;

    /* renamed from: b */
    public final /* synthetic */ ComponentActivity f24898b;

    public /* synthetic */ C1662ot(ComponentActivity componentActivity, int i) {
        this.f24897a = i;
        this.f24898b = componentActivity;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context context) {
        ComponentActivity componentActivity = this.f24898b;
        switch (this.f24897a) {
            case 0:
                int i = ComponentActivity.f458v;
                Bundle consumeRestoredStateForKey = componentActivity.getSavedStateRegistry().consumeRestoredStateForKey("android:support:activity-result");
                if (consumeRestoredStateForKey != null) {
                    componentActivity.f470n.onRestoreInstanceState(consumeRestoredStateForKey);
                    return;
                }
                return;
            default:
                ((FragmentActivity) componentActivity).f4477w.attachHost(null);
                return;
        }
    }
}
