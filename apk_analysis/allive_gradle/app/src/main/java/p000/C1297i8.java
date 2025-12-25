package p000;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

/* renamed from: i8 */
/* loaded from: classes.dex */
public final class C1297i8 implements OnContextAvailableListener {

    /* renamed from: a */
    public final /* synthetic */ AppCompatActivity f18332a;

    public C1297i8(AppCompatActivity appCompatActivity) {
        this.f18332a = appCompatActivity;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context context) {
        AppCompatActivity appCompatActivity = this.f18332a;
        AppCompatDelegate delegate = appCompatActivity.getDelegate();
        delegate.installViewFactory();
        delegate.onCreate(appCompatActivity.getSavedStateRegistry().consumeRestoredStateForKey("androidx:appcompat"));
    }
}
