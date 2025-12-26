package p000;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.zzb;

/* loaded from: classes.dex */
public final class h93 implements Parcelable.Creator {

    /* renamed from: a */
    public static final h93 f17992a;

    /* JADX WARN: Type inference failed for: r0v0, types: [h93, java.lang.Object] */
    static {
        new zzb();
        f17992a = new Object();
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int dataPosition = parcel.dataPosition();
        if (parcel.readInt() == -204102970) {
            return zzb.zza(parcel);
        }
        parcel.setDataPosition(dataPosition - 4);
        return ApiMetadata.getEmptyInstance();
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ApiMetadata[i];
    }
}
