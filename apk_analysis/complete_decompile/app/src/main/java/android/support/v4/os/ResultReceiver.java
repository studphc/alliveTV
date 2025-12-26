package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import p000.RunnableC2049z9;
import p000.u82;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new u82(2);

    /* renamed from: a */
    public final boolean f448a;

    /* renamed from: b */
    public final Handler f449b;

    /* renamed from: c */
    public IResultReceiver f450c;

    public ResultReceiver(Handler handler) {
        this.f448a = true;
        this.f449b = handler;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void onReceiveResult(int i, Bundle bundle) {
    }

    public void send(int i, Bundle bundle) {
        if (this.f448a) {
            Handler handler = this.f449b;
            if (handler != null) {
                handler.post(new RunnableC2049z9(this, i, bundle));
                return;
            } else {
                onReceiveResult(i, bundle);
                return;
            }
        }
        IResultReceiver iResultReceiver = this.f450c;
        if (iResultReceiver != null) {
            try {
                iResultReceiver.send(i, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        synchronized (this) {
            try {
                if (this.f450c == null) {
                    this.f450c = new BinderC0068c(this);
                }
                parcel.writeStrongBinder(this.f450c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResultReceiver(Parcel parcel) {
        this.f448a = false;
        this.f449b = null;
        this.f450c = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }
}
