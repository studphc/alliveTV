package p000;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.internal.base.zau;

/* loaded from: classes.dex */
public final class h83 extends zau {

    /* renamed from: a */
    public final Context f17977a;

    /* renamed from: b */
    public final /* synthetic */ GoogleApiAvailability f17978b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h83(GoogleApiAvailability googleApiAvailability, Context context) {
        super(r1);
        Looper myLooper;
        this.f17978b = googleApiAvailability;
        if (Looper.myLooper() == null) {
            myLooper = Looper.getMainLooper();
        } else {
            myLooper = Looper.myLooper();
        }
        this.f17977a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i);
        } else {
            GoogleApiAvailability googleApiAvailability = this.f17978b;
            Context context = this.f17977a;
            int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
            if (googleApiAvailability.isUserResolvableError(isGooglePlayServicesAvailable)) {
                googleApiAvailability.showErrorNotification(context, isGooglePlayServicesAvailable);
            }
        }
    }
}
