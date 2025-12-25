package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zza;

/* loaded from: classes.dex */
public interface IGmsServiceBroker extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IGmsServiceBroker {
        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        @NonNull
        @KeepForSdk
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.gms.internal.common.zza] */
        @Override // android.os.Binder
        public final boolean onTransact(int i, @NonNull Parcel parcel, @Nullable Parcel parcel2, int i2) {
            IGmsCallbacks iGmsCallbacks;
            if (i > 0 && i <= 16777215) {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                IBinder readStrongBinder = parcel.readStrongBinder();
                GetServiceRequest getServiceRequest = null;
                if (readStrongBinder == null) {
                    iGmsCallbacks = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                    if (queryLocalInterface instanceof IGmsCallbacks) {
                        iGmsCallbacks = (IGmsCallbacks) queryLocalInterface;
                    } else {
                        iGmsCallbacks = new zza(readStrongBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
                    }
                }
                if (i == 46) {
                    if (parcel.readInt() != 0) {
                        getServiceRequest = GetServiceRequest.CREATOR.createFromParcel(parcel);
                    }
                    getService(iGmsCallbacks, getServiceRequest);
                    Preconditions.checkNotNull(parcel2);
                    parcel2.writeNoException();
                    return true;
                }
                if (i == 47) {
                    if (parcel.readInt() != 0) {
                        zzal.CREATOR.createFromParcel(parcel);
                    }
                    throw new UnsupportedOperationException();
                }
                parcel.readInt();
                if (i != 4) {
                    parcel.readString();
                    if (i != 1) {
                        if (i != 2 && i != 23 && i != 25 && i != 27) {
                            if (i != 30) {
                                if (i != 34) {
                                    if (i != 41 && i != 43 && i != 37 && i != 38) {
                                        switch (i) {
                                            case 9:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                parcel.readString();
                                                parcel.readStrongBinder();
                                                parcel.readString();
                                                if (parcel.readInt() != 0) {
                                                    break;
                                                }
                                                break;
                                            case 10:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                break;
                                            case 19:
                                                parcel.readStrongBinder();
                                                if (parcel.readInt() != 0) {
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    parcel.readString();
                                }
                            }
                            parcel.createStringArray();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                            }
                        }
                        if (parcel.readInt() != 0) {
                        }
                    } else {
                        parcel.readString();
                        parcel.createStringArray();
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                        }
                    }
                }
                throw new UnsupportedOperationException();
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    @KeepForSdk
    void getService(@NonNull IGmsCallbacks iGmsCallbacks, @Nullable GetServiceRequest getServiceRequest);
}
