package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* loaded from: classes.dex */
public final class u03 implements ServiceConnection {

    /* renamed from: a */
    public IUnusedAppRestrictionsBackportService f27059a;

    /* renamed from: b */
    public ResolvableFuture f27060b;

    /* renamed from: c */
    public final Context f27061c;

    /* renamed from: d */
    public boolean f27062d = false;

    public u03(Context context) {
        this.f27061c = context;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService asInterface = IUnusedAppRestrictionsBackportService.Stub.asInterface(iBinder);
        this.f27059a = asInterface;
        try {
            asInterface.isPermissionRevocationEnabledForApp(new t03(this));
        } catch (RemoteException unused) {
            this.f27060b.set(0);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
