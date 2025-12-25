package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: androidx.appcompat.widget.c */
/* loaded from: classes.dex */
public final class C0094c implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.appcompat.widget.ActionMenuPresenter$SavedState] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? obj = new Object();
        obj.f1071a = parcel.readInt();
        return obj;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new ActionMenuPresenter$SavedState[i];
    }
}
