package p000;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.savedstate.SavedStateRegistry;

/* renamed from: h8 */
/* loaded from: classes.dex */
public final class C1260h8 implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a */
    public final /* synthetic */ AppCompatActivity f17969a;

    public C1260h8(AppCompatActivity appCompatActivity) {
        this.f17969a = appCompatActivity;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        Bundle bundle = new Bundle();
        this.f17969a.getDelegate().onSaveInstanceState(bundle);
        return bundle;
    }
}
